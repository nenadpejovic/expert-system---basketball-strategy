package org.silab.expertsystem.kie;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Platform;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.rule.EntryPoint;
import org.kie.internal.KnowledgeBaseFactory;
import org.silab.expertsystem.config.gui.MainGUI;
import org.silab.expertsystem.model.Game;
import org.silab.expertsystem.model.GameEvent;

public class KieService {

	EntryPoint entryPoint;
	KieSession kieSession; 
	
	public void kieInit() {
		
		
		
		try {
		KieServices kieServices = KieServices.Factory.get();
	    KieFileSystem kfs = kieServices.newKieFileSystem();
	    FileInputStream fis = null;
		
		fis = new FileInputStream( "src/main/rules/Rules.drl" );

	    kfs.write( "src/main/resources/simple.drl",
	                kieServices.getResources().newInputStreamResource( fis ) );
	    KieBuilder kieBuilder = kieServices.newKieBuilder( kfs ).buildAll();
	    
	    
	    Results results = kieBuilder.getResults();
	    if( results.hasMessages( Message.Level.ERROR ) ){
	        System.out.println( results.getMessages() );
	        throw new IllegalStateException( "### errors ###" );
	    }
	    KieContainer kieContainer =
	        kieServices.newKieContainer( kieServices.getRepository().getDefaultReleaseId() );
	    KieBaseConfiguration kieConf = kieServices.newKieBaseConfiguration();
	    
	    kieConf.setOption(EventProcessingOption.STREAM);
	    
	    KieBase kieBase = kieContainer.newKieBase(kieConf);
	    KieSessionConfiguration sessionConf = kieServices.newKieSessionConfiguration();
	    
	    
	    kieSession = kieBase.newKieSession(sessionConf,null);
	    
	    
	    entryPoint = kieSession.getEntryPoint("DEFAULT");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

   public void injectEvent(final Game game,GameEvent gameEvent,final MainGUI gui){

	   kieSession.insert(game);
	   entryPoint.insert(gameEvent);
	   kieSession.fireAllRules();
	   
	   System.out.println(game.getExplanation());
	   
	   Platform.runLater(new Runnable() {
		
		@Override
		public void run() {
			gui.initLineup(game);
		}
	   });
	   
	   System.out.println("------------------"+game.getSubsSf().getSurname()+"----------------------");
   }
}
