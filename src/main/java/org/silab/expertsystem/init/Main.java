package org.silab.expertsystem.init;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javafx.application.Application;

import org.silab.expertsystem.config.gui.MainGUI;
import org.silab.expertsystem.consumer.StatsMessageConsumer;
import org.silab.expertsystem.db.broker.DBSession;
import org.silab.expertsystem.db.broker.MongoDBSession;
import org.silab.expertsystem.db.config.DBConfig;
import org.silab.expertsystem.db.dao.PlayerDao;
import org.silab.expertsystem.db.dao.PlayerDaoImpl;
import org.silab.expertsystem.db.datasource.DataSource;
import org.silab.expertsystem.kie.KieService;
import org.silab.expertsystem.model.Game;
import org.silab.expertsystem.model.GameEvent;
import org.silab.expertsystem.model.Player;

import sun.launcher.resources.launcher;

public class Main {


	public static void main(String[] args) {
		
	
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("C:/Users/pc/workspace/ExpertSystem/application.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

		DBConfig config = new DBConfig();
		config.setDBProperties(props);
		config.setSession();
		
		DBSession db = config.getSession();
		
		PlayerDao playerDao = new PlayerDaoImpl(db);
		
		List<Player> players = playerDao.getPlayers();
		
		try {
			List<Player> list = db.all(Player.class);
			System.out.println(list.size());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		KieService ks = new KieService();
		
		
		Game game = new Game();
		game.setImportanceOfGame(true);
		game.setHost(true);
		game.setQualityOfOpponent("excellent");
		
		ks.kieInit();
		
		
		new Thread(){
			@Override
			public void run() {
				Application.launch(MainGUI.class);
			};
		}.start();
		
		MainGUI gui = MainGUI.waitStartUp();
		
		
		Thread threadListener = new Thread(new StatsMessageConsumer(players,props.getProperty("activemq-url"),props.getProperty("queue-name"),ks,game,gui));
		threadListener.start();
		
		
		
		while(true){
		}
		
	}
}
