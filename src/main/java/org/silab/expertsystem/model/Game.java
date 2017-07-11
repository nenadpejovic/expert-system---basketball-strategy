package org.silab.expertsystem.model;

public class Game {

	Player pg;
	Player sg;
	Player sf;
	Player pf;
	Player c;
	Player subsPg;
	Player subsSg;
	Player subsSf;
	Player subsPf;
	Player subsC;
	Player subsCPf;
	Player subsPgSg;
	StringBuffer explanation = new StringBuffer();
	
	int score;
	double minute;
	String tactic;
	String qualituOfOponent;
	int personalFoulsUntilBonus;
	boolean host;
	boolean importansOfGame;
	boolean ball;
	
	Player oponentPg;
	Player oponentSg;
	Player oponentSf;
	Player oponentPf;
	Player oponentC;
	Player oponentSubsPg;
	Player oponentsSubsSg;
	Player oponentSubsSf;
	Player oponentSubsPf;
	Player oponentSubsC;
	Player oponentSubsCPf;
	Player oponentsSubsPgSg;
	public Player getPg() {
		return pg;
	}
	public void setPg(Player pg) {
		this.pg = pg;
	}
	public Player getSg() {
		return sg;
	}
	public void setSg(Player sg) {
		this.sg = sg;
	}
	public Player getSf() {
		return sf;
	}
	public void setSf(Player sf) {
		this.sf = sf;
	}
	public Player getPf() {
		return pf;
	}
	public void setPf(Player pf) {
		this.pf = pf;
	}
	public Player getC() {
		return c;
	}
	public void setC(Player c) {
		this.c = c;
	}
	public Player getSubsPg() {
		return subsPg;
	}
	public void setSubsPg(Player subsPg) {
		this.subsPg = subsPg;
	}
	public Player getSubsSg() {
		return subsSg;
	}
	public void setSubsSg(Player subsSg) {
		this.subsSg = subsSg;
	}
	public Player getSubsSf() {
		return subsSf;
	}
	public void setSubsSf(Player subsSf) {
		this.subsSf = subsSf;
	}
	public Player getSubsPf() {
		return subsPf;
	}
	public void setSubsPf(Player subsPf) {
		this.subsPf = subsPf;
	}
	public Player getSubsC() {
		return subsC;
	}
	public void setSubsC(Player subsC) {
		this.subsC = subsC;
	}
	public Player getSubsCPf() {
		return subsCPf;
	}
	public void setSubsCPf(Player subsCPf) {
		this.subsCPf = subsCPf;
	}
	public Player getSubsPgSg() {
		return subsPgSg;
	}
	public void setSubsPgSg(Player subsPgSg) {
		this.subsPgSg = subsPgSg;
	}
	public StringBuffer getExplanation() {
		return explanation;
	}
	public void setExplanation(StringBuffer explanation) {
		this.explanation = explanation;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public double getMinute() {
		return minute;
	}
	public void setMinute(double minute) {
		this.minute = minute;
	}
	public String getTactic() {
		return tactic;
	}
	public void setTactic(String tactic) {
		this.tactic = tactic;
	}
	public String getQualituOfOponent() {
		return qualituOfOponent;
	}
	public void setQualituOfOponent(String qualituOfOponent) {
		this.qualituOfOponent = qualituOfOponent;
	}
	public int getPersonalFoulsUntilBonus() {
		return personalFoulsUntilBonus;
	}
	public void setPersonalFoulsUntilBonus(int personalFoulsUntilBonus) {
		this.personalFoulsUntilBonus = personalFoulsUntilBonus;
	}
	public boolean isHost() {
		return host;
	}
	public void setHost(boolean host) {
		this.host = host;
	}
	public boolean isImportansOfGame() {
		return importansOfGame;
	}
	public void setImportansOfGame(boolean importansOfGame) {
		this.importansOfGame = importansOfGame;
	}
	public boolean isBall() {
		return ball;
	}
	public void setBall(boolean ball) {
		this.ball = ball;
	}
	public Player getOponentPg() {
		return oponentPg;
	}
	public void setOponentPg(Player oponentPg) {
		this.oponentPg = oponentPg;
	}
	public Player getOponentSg() {
		return oponentSg;
	}
	public void setOponentSg(Player oponentSg) {
		this.oponentSg = oponentSg;
	}
	public Player getOponentSf() {
		return oponentSf;
	}
	public void setOponentSf(Player oponentSf) {
		this.oponentSf = oponentSf;
	}
	public Player getOponentPf() {
		return oponentPf;
	}
	public void setOponentPf(Player oponentPf) {
		this.oponentPf = oponentPf;
	}
	public Player getOponentC() {
		return oponentC;
	}
	public void setOponentC(Player oponentC) {
		this.oponentC = oponentC;
	}
	public Player getOponentSubsPg() {
		return oponentSubsPg;
	}
	public void setOponentSubsPg(Player oponentSubsPg) {
		this.oponentSubsPg = oponentSubsPg;
	}
	public Player getOponentsSubsSg() {
		return oponentsSubsSg;
	}
	public void setOponentsSubsSg(Player oponentsSubsSg) {
		this.oponentsSubsSg = oponentsSubsSg;
	}
	public Player getOponentSubsSf() {
		return oponentSubsSf;
	}
	public void setOponentSubsSf(Player oponentSubsSf) {
		this.oponentSubsSf = oponentSubsSf;
	}
	public Player getOponentSubsPf() {
		return oponentSubsPf;
	}
	public void setOponentSubsPf(Player oponentSubsPf) {
		this.oponentSubsPf = oponentSubsPf;
	}
	public Player getOponentSubsC() {
		return oponentSubsC;
	}
	public void setOponentSubsC(Player oponentSubsC) {
		this.oponentSubsC = oponentSubsC;
	}
	public Player getOponentSubsCPf() {
		return oponentSubsCPf;
	}
	public void setOponentSubsCPf(Player oponentSubsCPf) {
		this.oponentSubsCPf = oponentSubsCPf;
	}
	public Player getOponentsSubsPgSg() {
		return oponentsSubsPgSg;
	}
	public void setOponentsSubsPgSg(Player oponentsSubsPgSg) {
		this.oponentsSubsPgSg = oponentsSubsPgSg;
	}
	
	
}
