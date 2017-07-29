package org.silab.expertsystem.kie;


import java.net.URL;
import java.util.Collection;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.conf.EventProcessingOption;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.WorkingMemoryEntryPoint;
import org.silab.expertsystem.model.Game;
import org.silab.expertsystem.model.GameEvent;

public class KieService {
	
	WorkingMemoryEntryPoint entryPoint;
	StatefulKnowledgeSession kSession;

	public void kieInit(Game game) {
		

		KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		
		URL url = KieService.class.getClassLoader().getResource("Rules.drl");
		
		kBuilder.add(ResourceFactory.newFileResource(url.getPath()),ResourceType.DRL);
		
		
		if(kBuilder.hasErrors()){
			System.err.println(kBuilder.getErrors().toString());
		}
		
		KnowledgeBaseConfiguration kConfig = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
		
		kConfig.setOption(EventProcessingOption.STREAM);
		
		KnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase(kConfig);
		kBase.addKnowledgePackages(kBuilder.getKnowledgePackages());
		
		kSession = kBase.newStatefulKnowledgeSession();

		kSession.insert(game);
		
		entryPoint = kSession.getWorkingMemoryEntryPoint("game-event");
		
		
	}
	

   public void injectEvent(GameEvent game){
	   entryPoint.insert(game);
	   kSession.fireAllRules();
   }
}
