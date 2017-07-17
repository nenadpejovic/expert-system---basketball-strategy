package org.silab.expertsystem.consumer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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
import org.silab.expertsystem.model.Game;
import org.silab.expertsystem.model.Player;

public class StatsMessageConsumer implements Runnable {

	List<Player> players;
	String url;
	String queueName;
	Game game;
	
	List<Player> setted = new LinkedList<>();

	public StatsMessageConsumer(List<Player> players, String url, String queueName, Game game) {
		this.players = players;
		this.url = url;
		this.queueName = queueName;
		this.game = game;
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
							TextMessage textMessage = (TextMessage) message;
							populateGame(textMessage);
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

		game.setHost(true);
		game.setScore((int) gameObject.get("score"));
		game.setQualituOfOpponent((String) gameObject.get("quality of away team"));
		game.setBall((boolean) gameObject.get("score"));
		game.setPersonalFoulsUntilBonus((int) gameObject.get("bonus"));
		game.setMinute((double) gameObject.get("score"));

		game.setImportanceOfGame(true);
		game.setTactic("");

		JSONArray homePlayers = (JSONArray) object.get("home players");
		parsePlayers(homePlayers);
		
		JSONArray awayPlayers = (JSONArray) object.get("away players");
		parsePlayers(awayPlayers);
		
		unsetAll();
		resolveHomeLineup();
		resolveAwayLineup();

	}
	
	public void resolveAwayLineup(){
		for(Player player: players){
			if(player.getTeam().equals("away")){
				if(player.isLineup() && player.getPosition().contains("pg") && !setted.contains(player)){
					game.setopponentPg(player);
				} else if(player.isLineup() && player.getPosition().contains("sg") && !setted.contains(player)) {
					game.setopponentSg(player);
				} else if (player.isLineup() && player.getPosition().contains("sf") && !setted.contains(player)){
					game.setopponentSf(player);
				} else if (player.isLineup() && player.getPosition().contains("pf") && !setted.contains(player)){
					game.setopponentPg(player);
				} else if (player.isLineup() && player.getPosition().contains("c") && !setted.contains(player)){
					game.setopponentC(player);
				} else if (!player.isLineup() && player.getPosition().contains("pg") && !setted.contains(player)){
					game.setopponentSubsPg(player);
				} else 	if(!player.isLineup() && player.getPosition().contains("sg") && !setted.contains(player)){
					game.setopponentsSubsSg(player);
				} else if(!player.isLineup() && player.getPosition().contains("sf") && !setted.contains(player)) {
					game.setopponentSubsSf(player);
				} else if (!player.isLineup() && player.getPosition().contains("pf") && !setted.contains(player)){
					game.setopponentPf(player);
				} else if (player.isLineup() && player.getPosition().contains("c") && !setted.contains(player)){
					game.setopponentSubsC(player);
				} else if (player.isLineup() && player.getPosition().contains("pg") && !setted.contains(player)){
					game.setopponentsSubsPgSg(player);
				} else if (player.isLineup() && player.getPosition().contains("pf") && !setted.contains(player)){
					game.setopponentSubsCPf(player);
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
				if(player.isLineup() && player.getPosition().contains("pg") && !setted.contains(player)){
					game.setPg(player);
				} else if(player.isLineup() && player.getPosition().contains("sg") && !setted.contains(player)) {
					game.setSg(player);
				} else if (player.isLineup() && player.getPosition().contains("sf") && !setted.contains(player)){
					game.setSf(player);
				} else if (player.isLineup() && player.getPosition().contains("pf") && !setted.contains(player)){
					game.setPg(player);
				} else if (player.isLineup() && player.getPosition().contains("c") && !setted.contains(player)){
					game.setC(player);
				} else if (!player.isLineup() && player.getPosition().contains("pg") && !setted.contains(player)){
					game.setSubsPg(player);
				} else 	if(!player.isLineup() && player.getPosition().contains("sg") && !setted.contains(player)){
					game.setSubsSg(player);
				} else if(!player.isLineup() && player.getPosition().contains("sf") && !setted.contains(player)) {
					game.setSubsSf(player);
				} else if (!player.isLineup() && player.getPosition().contains("pf") && !setted.contains(player)){
					game.setPf(player);
				} else if (player.isLineup() && player.getPosition().contains("c") && !setted.contains(player)){
					game.setSubsC(player);
				} else if (player.isLineup() && player.getPosition().contains("pg") && !setted.contains(player)){
					game.setPgSg(player);;
				} else if (player.isLineup() && player.getPosition().contains("pf") && !setted.contains(player)){
					game.setcPf(player);;
				}
			}
		}
	}
	

	public void unsetHome(){
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
			if(player.getName().equalsIgnoreCase("name") && player.getName().equalsIgnoreCase("surname")){
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
