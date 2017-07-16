
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
	private int asists;
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

	public int getAsists() {
		return asists;
	}

	public void setAsists(int asists) {
		this.asists = asists;
	}

	public double getAverageAssists() {
		return averageAssists;
	}

	public void setAverageAssits(double averageAssists) {
		this.averageAssists = averageAssists;
	}

	public double getAverageSteals() {
		return averageSteals;
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
}