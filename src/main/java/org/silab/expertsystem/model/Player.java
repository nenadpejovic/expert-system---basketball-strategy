
package org.silab.expertsystem.model;

import org.silab.expertsystem.config.annotations.ModelTable;

@ModelTable(name="player")
public class Player {

	private String team;
	
	private String name;
	private String surname;
	
	private String position;

	private double height;
	private double weight;
	
	private double percentageOnePoint;
	private double averagePercentageOnePoint;
	private double percentageTwoPoints;
	private double averagePercentageTwoPoints;
	private double percentageThreePoints;
	private double averagePercentageThreePoints;
	
	private int points;
	private double averagePoints;
	private int rebounds;
	private double averageRebounds;
	private int steals;
	private int assists;
	private double averageAssists;
	private double averageSteals;
	private int turnovers;
	private double averageTurnovers;
	private double time;
	private double averageTime;
	private int blocks;
	private double averageBlocks;
	
	private int pir;
	private double indexOfTiredness;
	
	private int personalFouls;
	 
	private boolean hurt;
	private boolean sentOff;
	
	private boolean lineup;	
	
	public boolean isLineup() {
		return lineup;
	}

	public void setLineup(boolean lineup) {
		this.lineup = lineup;
	}

	public void setAverageAssists(double averageAssists) {
		this.averageAssists = averageAssists;
	}

	private String qualityOfDefensePlay;
	
	public Player(){
		
	}
    
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPercentageOnePoint() {
		return percentageOnePoint;
	}

	public void setPercentageOnePoint(double percentageOnePoint) {
		this.percentageOnePoint = percentageOnePoint;
	}

	public double getAveragePercentageOnePoint() {
		return averagePercentageOnePoint;
	}

	public void setAveragePercentageOnePoint(double averagePercentageOnePoint) {
		this.averagePercentageOnePoint = averagePercentageOnePoint;
	}

	public double getPercentageTwoPoints() {
		return percentageTwoPoints;
	}

	public void setPercentageTwoPoints(double percentageTwoPoints) {
		this.percentageTwoPoints = percentageTwoPoints;
	}

	public double getAveragePercentageTwoPoints() {
		return averagePercentageTwoPoints;
	}

	public void setAveragePercentageTwoPoints(double averagePercentageTwoPoints) {
		this.averagePercentageTwoPoints = averagePercentageTwoPoints;
	}

	public double getPercentageThreePoints() {
		return percentageThreePoints;
	}

	public void setPercentageThreePoints(double percentageThreePoints) {
		this.percentageThreePoints = percentageThreePoints;
	}

	public double getAveragePercentageThreePoints() {
		return averagePercentageThreePoints;
	}

	public void setAveragePercentageThreePoints(double averagePercentageThreePoints) {
		this.averagePercentageThreePoints = averagePercentageThreePoints;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public double getAveragePoints() {
		return averagePoints;
	}

	public void setAveragePoints(double averagePoints) {
		this.averagePoints = averagePoints;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public double getAverageRebounds() {
		return averageRebounds;
	}

	public void setAverageRebounds(double averageRebounds) {
		this.averageRebounds = averageRebounds;
	}

	public int getSteals() {
		return steals;
	}

	public void setSteals(int steals) {
		this.steals = steals;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public double getAverageAssists() {
		return averageAssists;
	}


	public void setAverageSteals(double averageSteals) {
		this.averageSteals = averageSteals;
	}

	public int getTurnovers() {
		return turnovers;
	}

	public void setTurnovers(int turnovers) {
		this.turnovers = turnovers;
	}

	public double getAverageTurnovers() {
		return averageTurnovers;
	}

	public void setAverageTurnovers(double averageTurnovers) {
		this.averageTurnovers = averageTurnovers;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getAverageTime() {
		return averageTime;
	}

	public void setAverageTime(double averageTime) {
		this.averageTime = averageTime;
	}

	public int getBlocks() {
		return blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}

	public double getAverageBlocks() {
		return averageBlocks;
	}

	public void setAverageBlocks(double averageBlocks) {
		this.averageBlocks = averageBlocks;
	}

	public int getPir() {
		return pir;
	}

	public void setPir(int pir) {
		this.pir = pir;
	}

	public double getIndexOfTiredness() {
		return indexOfTiredness;
	}

	public void setIndexOfTiredness(double indexOfTiredness) {
		this.indexOfTiredness = indexOfTiredness;
	}

	public int getPersonalFouls() {
		return personalFouls;
	}

	public void setPersonalFouls(int personalFouls) {
		this.personalFouls = personalFouls;
	}

	public boolean isHurt() {
		return hurt;
	}

	public void setHurt(boolean hurt) {
		this.hurt = hurt;
	}

	public boolean isSentOff() {
		return sentOff;
	}

	public void setSentOff(boolean sentOff) {
		this.sentOff = sentOff;
	}

	public String getQualityOfDefensePlay() {
		return qualityOfDefensePlay;
	}

	public void setQualityOfDefensePlay(String qualityOfDefensePlay) {
		this.qualityOfDefensePlay = qualityOfDefensePlay;
	}
	
	public Player clone(){
		Player player = new Player(team, name, surname, position, height, weight, percentageOnePoint, averagePercentageOnePoint, percentageTwoPoints, averagePercentageTwoPoints, percentageThreePoints, averagePercentageThreePoints, points, averagePoints, rebounds, averageRebounds, steals, assists, averageAssists, averageSteals, turnovers, averageTurnovers, time, averageTime, blocks, averageBlocks, pir, indexOfTiredness, personalFouls, hurt, sentOff, lineup, qualityOfDefensePlay);
		return player;
	}
	
	public Player(String team, String name, String surname, String position,
			double height, double weight, double percentageOnePoint,
			double averagePercentageOnePoint, double percentageTwoPoints,
			double averagePercentageTwoPoints, double percentageThreePoints,
			double averagePercentageThreePoints, int points,
			double averagePoints, int rebounds, double averageRebounds,
			int steals, int assists, double averageAssists,
			double averageSteals, int turnovers, double averageTurnovers,
			double time, double averageTime, int blocks, double averageBlocks,
			int pir, double indexOfTiredness, int personalFouls, boolean hurt,
			boolean sentOff, boolean lineup, String qualityOfDefensePlay) {
		super();
		this.team = team;
		this.name = name;
		this.surname = surname;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.percentageOnePoint = percentageOnePoint;
		this.averagePercentageOnePoint = averagePercentageOnePoint;
		this.percentageTwoPoints = percentageTwoPoints;
		this.averagePercentageTwoPoints = averagePercentageTwoPoints;
		this.percentageThreePoints = percentageThreePoints;
		this.averagePercentageThreePoints = averagePercentageThreePoints;
		this.points = points;
		this.averagePoints = averagePoints;
		this.rebounds = rebounds;
		this.averageRebounds = averageRebounds;
		this.steals = steals;
		this.assists = assists;
		this.averageAssists = averageAssists;
		this.averageSteals = averageSteals;
		this.turnovers = turnovers;
		this.averageTurnovers = averageTurnovers;
		this.time = time;
		this.averageTime = averageTime;
		this.blocks = blocks;
		this.averageBlocks = averageBlocks;
		this.pir = pir;
		this.indexOfTiredness = indexOfTiredness;
		this.personalFouls = personalFouls;
		this.hurt = hurt;
		this.sentOff = sentOff;
		this.lineup = lineup;
		this.qualityOfDefensePlay = qualityOfDefensePlay;
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Player){
			Player p = (Player)obj;
			if(this.getName().equals(p.getName())&&this.getSurname().equals(((Player) obj).getSurname())){
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}