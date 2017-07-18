package org.silab.expertsystem.init;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.silab.expertsystem.consumer.StatsMessageConsumer;
import org.silab.expertsystem.db.broker.DBSession;
import org.silab.expertsystem.db.broker.MongoDBSession;
import org.silab.expertsystem.db.config.DBConfig;
import org.silab.expertsystem.db.dao.PlayerDao;
import org.silab.expertsystem.db.dao.PlayerDaoImpl;
import org.silab.expertsystem.db.datasource.DataSource;
import org.silab.expertsystem.model.Game;
import org.silab.expertsystem.model.Player;

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
		
		Game game = new Game();
		
		Thread thread = new Thread(new StatsMessageConsumer(players,props.getProperty("activemq-url"),props.getProperty("queue-name"), game));
		thread.start();
		
		while(true){
			System.out.println(game.getopponentPf().getName());
		}
		
	}
}
