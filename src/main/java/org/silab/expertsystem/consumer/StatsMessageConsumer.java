package org.silab.expertsystem.consumer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javafx.application.Platform;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.silab.expertsystem.config.gui.MainGUI;
import org.silab.expertsystem.kie.KieService;
import org.silab.expertsystem.model.Game;
import org.silab.expertsystem.model.GameEvent;
import org.silab.expertsystem.model.Player;

public class StatsMessageConsumer implements Runnable {

	List<Player> players;
	String url;
	String queueName;
	GameEvent game;
	Game g;
	List<Player> setted;
	KieService ks;
	private MainGUI gui;

	public StatsMessageConsumer(List<Player> players, String url, String queueName, KieService ks, Game game, MainGUI gui) {
		this.g = game;
		this.players = players;
		this.url = url;
		this.queueName = queueName;
		this.setted = new LinkedList<>();
		this.ks = ks;
		this.gui = gui;
	}

	@Override
	public void run() {
		try {
			
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			Connection connection = connectionFactory.createConnection();
			connection.start();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createQueue(queueName);

			MessageConsumer consumer = session.createConsumer(destination);

			MessageListener listener = new MessageListener() {

				@Override
				public void onMessage(Message message) {
					try {
						if (message instanceof TextMessage) {
							g.getExplanation().delete(0, g.getExplanation().length());
							TextMessage textMessage = (TextMessage) message;
							game = new GameEvent();
							populateGame(textMessage);
							Platform.runLater(new Runnable() {
								
								@Override
								public void run() {
									gui.initLineup(game);;
								}
							});
							ks.injectEvent(g,game,gui);
						}
					} catch (JMSException e) {
						System.out.println("Caught:" + e);
						e.printStackTrace();
					} catch (ParseException e) {
						e.printStackTrace();
					}

				}
			};
			consumer.setMessageListener(listener);
			System.in.read();
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void populateGame(TextMessage message) throws JMSException, ParseException {

		String json = message.getText();
		JSONParser parser = new JSONParser();

		JSONObject object = (JSONObject) parser.parse(json);

		JSONObject gameObject = (JSONObject) object.get("game");

		game.setScore((long) gameObject.get("score"));
		game.setBall((boolean) gameObject.get("ball"));
		game.setPersonalFoulsUntilBonus((long) gameObject.get("bonus"));
		game.setMinute((double) gameObject.get("minute"));

		game.setTactic("");
		

		JSONArray homePlayers = (JSONArray) object.get("home players");
		parsePlayers(homePlayers);
		
		JSONArray awayPlayers = (JSONArray) object.get("away players");
		parsePlayers(awayPlayers);
		
		unsetAll();
		resolveHomeLineup();
		resolveAwayLineup();
		
		g.setPg(game.getPg());
		g.setSg(game.getSg());
		g.setSf(game.getSf());
		g.setPf(game.getPf());
		g.setC(game.getC());
		g.setSubsPg(game.getSubsPg());
		g.setSubsSg(game.getSubsSg());
		g.setSubsSf(game.getSubsSf());
		g.setSubsPf(game.getSubsPf());
		g.setcPf(game.getcPf());
		g.setPgSg(game.getPgSg());
		g.setOpponentPg(game.getopponentPg());
		g.setOpponentSg(game.getopponentSg());
		g.setOpponentSf(game.getopponentSf());
		g.setOpponentPf(game.getopponentPf());
		g.setOpponentC(game.getopponentC());
		g.setOpponentSf(game.getopponentSf());
		g.setOpponentSubsPg(game.getopponentSubsPg());
		g.setOpponentsSubsSg(game.getopponentsSubsSg());
		g.setOpponentSubsSf(game.getopponentSubsSf());
		g.setOpponentSubsPf(game.getopponentSubsPf());
		g.setOpponentSubsC(game.getopponentSubsC());
		g.setOpponentsSubsPgSg(game.getopponentsSubsPgSg());
		g.setOpponentSubsCPf(game.getopponentSubsCPf());

	}
	
	public void resolveAwayLineup(){
		

		for(Player player: players){

			if(player.getTeam().equals("away")){
				if(player.isLineup() && player.getPosition().contains("pg") && !setted.contains(player) && game.getopponentPg()==null){
					game.setopponentPg(player.clone());
					g.setOpponentPg(player);
					setted.add(player);
				} else if(player.isLineup() && player.getPosition().contains("sg") && !setted.contains(player) && game.getopponentSg()==null) {
					game.setopponentSg(player.clone());
					g.setOpponentSg(player);
					setted.add(player);
				} else if (player.isLineup() && player.getPosition().contains("sf") && !setted.contains(player) && game.getopponentSf()==null){
					game.setopponentSf(player.clone());
					g.setOpponentSf(player);
					setted.add(player);
				} else if (player.isLineup() && player.getPosition().contains("pf") && !setted.contains(player) && game.getopponentPf()==null){
					game.setopponentPf(player.clone());
					g.setOpponentPf(player);
					setted.add(player);
				} else if (player.isLineup() && player.getPosition().contains("c") && !setted.contains(player) && game.getopponentC()==null){
					game.setopponentC(player.clone());
					g.setOpponentC(player);
					setted.add(player);
				} else if (!player.isLineup() && player.getPosition().contains("pg") && !setted.contains(player) && game.getopponentSubsPg()==null){
					game.setopponentSubsPg(player.clone());
					g.setOpponentSubsPg(player);
					setted.add(player);
				} else 	if(!player.isLineup() && player.getPosition().contains("sg") && !setted.contains(player) && game.getopponentsSubsSg() == null){
					game.setopponentsSubsSg(player.clone());
					g.setOpponentsSubsSg(player);
					setted.add(player);
				} else if(!player.isLineup() && player.getPosition().contains("sf") && !setted.contains(player) && game.getopponentSubsSf() == null) {
					game.setopponentSubsSf(player.clone());
					g.setOpponentSubsSf(player);
					setted.add(player);
				} else if (!player.isLineup() && player.getPosition().contains("pf") && !setted.contains(player) && game.getopponentSubsPf() == null){
					game.setopponentSubsPf(player.clone());
					g.setOpponentSubsPf(player);
					setted.add(player);
				} else if (!player.isLineup() && player.getPosition().contains("c") && !setted.contains(player) && game.getopponentSubsC() == null){
					game.setopponentSubsC(player.clone());
					g.setOpponentSubsC(player);
					setted.add(player);
				} else if (!player.isLineup() && player.getPosition().contains("pg") && !setted.contains(player) && game.getopponentsSubsPgSg() == null){
					game.setopponentsSubsPgSg(player.clone());
					g.setOpponentsSubsPgSg(player);
					setted.add(player);
				} else if (!player.isLineup() && player.getPosition().contains("pf") && !setted.contains(player) && game.getopponentSubsCPf() == null){
					game.setopponentSubsCPf(player.clone());
					g.setOpponentSubsCPf(player);
					setted.add(player);
				}
			}
		}
	}

	public void unsetAll(){
		setted.clear();
	}
	
	public void resolveHomeLineup(){
		for(Player player: players){
			if(player.getTeam().equals("home")){
				if(player.isLineup() && player.getPosition().contains("pg") && !setted.contains(player) && game.getPg()==null){
					game.setPg(player.clone());
					g.setPg(player);
					setted.add(player);
				} else if(player.isLineup() && player.getPosition().contains("sg") && !setted.contains(player) && game.getSg()==null) {
					game.setSg(player.clone());
					g.setSg(player);
					setted.add(player);
				} else if (player.isLineup() && player.getPosition().contains("sf") && !setted.contains(player) && game.getSf()==null){
					game.setSf(player.clone());
					g.setSf(player);
					setted.add(player);
				} else if (player.isLineup() && player.getPosition().contains("pf") && !setted.contains(player) && game.getPf() == null){
					game.setPf(player.clone());
					g.setPf(player);
					setted.add(player);
				} else if (player.isLineup() && player.getPosition().contains("c") && !setted.contains(player) && game.getC()==null){
					game.setC(player.clone());
					g.setC(player);
					setted.add(player);
				} else if (!player.isLineup() && player.getPosition().contains("pg") && !setted.contains(player) && game.getSubsPg()==null){
					game.setSubsPg(player.clone());
					g.setSubsPg(player);
					setted.add(player);
				} else 	if(!player.isLineup() && player.getPosition().contains("sg") && !setted.contains(player) && game.getSubsSg()==null){
					game.setSubsSg(player.clone());
					g.setSubsSg(player);
					setted.add(player);
				} else if(!player.isLineup() && player.getPosition().contains("sf") && !setted.contains(player) && game.getSubsSf()==null) {
					game.setSubsSf(player.clone());
					g.setSubsSf(player);
					setted.add(player);
				} else if (!player.isLineup() && player.getPosition().contains("pf") && !setted.contains(player) && game.getSubsPf()==null){
					game.setSubsPf(player.clone());
					g.setSubsPf(player);
					setted.add(player);
				} else if (!player.isLineup() && player.getPosition().contains("c") && !setted.contains(player) && game.getSubsC()==null){
					game.setSubsC(player.clone());
					g.setSubsC(player);
					setted.add(player);
				} else if (!player.isLineup() && player.getPosition().contains("pg") && !setted.contains(player) && game.getPgSg()==null){
					game.setPgSg(player.clone());
					g.setPgSg(player);
					setted.add(player);
				} else if (!player.isLineup() && player.getPosition().contains("pf") && !setted.contains(player) && game.getcPf()==null){
					game.setcPf(player.clone());
					g.setcPf(player);
					setted.add(player);
				}
			}
		}
	}
	
	
	

	public void parsePlayers(JSONArray players) {
		
		for (Object helpPlayer : players) {

			JSONObject playerObject = (JSONObject) helpPlayer;
			
			String name = (String) playerObject.get("name");
			String surname = (String) playerObject.get("surname");
			
			Player player = findPlayerFromList(name, surname);
			
			if(player != null){
				
				if(checkForUndefined(playerObject.get("playedTime"))){
					player.setTime(Double.parseDouble((String)playerObject.get("playedTime")));
				}
				if(checkForUndefined(playerObject.get("points"))){
					player.setPoints(Integer.parseInt((String)playerObject.get("points")));
				}
				if(checkForUndefined(playerObject.get("two points percentage"))){
					player.setPercentageTwoPoints(Double.parseDouble((String)playerObject.get("two points percentage")));
				}
				if(checkForUndefined(playerObject.get("three points percentage"))){
					player.setPercentageThreePoints(Double.parseDouble((String)playerObject.get("three points percentage")));
				}
				if(checkForUndefined(playerObject.get("one points percentage"))){
					player.setPercentageOnePoint(Double.parseDouble((String)playerObject.get("one points percentage")));
				}
				if(checkForUndefined(playerObject.get("rebounds"))){
					player.setRebounds(Integer.parseInt((String)playerObject.get("rebounds")));
				}
				if(checkForUndefined(playerObject.get("assists"))){
					player.setAssists(Integer.parseInt((String)playerObject.get("assists")));
				}
				if(checkForUndefined(playerObject.get("steals"))){
					player.setSteals(Integer.parseInt((String)playerObject.get("steals")));
				}
				if(checkForUndefined(playerObject.get("turnovers"))){
					player.setTurnovers(Integer.parseInt((String)playerObject.get("turnovers")));
				}
				if(checkForUndefined(playerObject.get("blocks"))){
					player.setBlocks(Integer.parseInt((String)playerObject.get("blocks")));
				}
				if(checkForUndefined(playerObject.get("personal fouls"))){
					player.setPersonalFouls(Integer.parseInt((String)playerObject.get("personal fouls")));
				}
				if(checkForUndefined(playerObject.get("form index"))){
					player.setPir(Integer.parseInt((String)playerObject.get("form index")));
				}
				if((boolean)playerObject.get("startingLineup")){
					player.setLineup(true);
				} else {
					player.setLineup(false);
				}
			}
		}
	}
	
	public Player findPlayerFromList(String name, String surname){
		for(Player player : players){
			if(player.getName().equalsIgnoreCase(name) && player.getSurname().equalsIgnoreCase(surname)){
				return player;
			}
		}
		return null;
	}
	
	public boolean checkForUndefined(Object field){
		try {
		if((((String)field).equals("/")) || (((String)field).equals("-")) || (((String)field).equals("")) ){
			return false;
		} else {
			return true;
		}
		} catch(Exception ex){
			return true;
		}
	}

}
