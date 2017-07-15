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
	Player cPf;
	Player pgSg;
	StringBuffer explanation = new StringBuffer();

	int score;
	double minute;
	String tactic;
	String qualityOfOpponent;
	int personalFoulsUntilBonus;
	boolean host;
	boolean importanceOfGame;
	boolean ball;

	Player opponentPg;
	Player opponentSg;
	Player opponentSf;
	Player opponentPf;
	Player opponentC;
	Player opponentSubsPg;
	Player opponentsSubsSg;
	Player opponentSubsSf;
	Player opponentSubsPf;
	Player opponentSubsC;
	Player opponentSubsCPf;
	Player opponentsSubsPgSg;

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

	public Player getcPf() {
		return cPf;
	}

	public void setcPf(Player cPf) {
		this.cPf = cPf;
	}

	public Player getPgSg() {
		return pgSg;
	}

	public void setPgSg(Player pgSg) {
		this.pgSg = pgSg;
	}


	public StringBuffer getExplanation() {
		return explanation;
	}

	public void addExplanation(String explanation) {
		this.explanation.append(explanation);
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

	public String getQualityOfOpponent() {
		return qualityOfOpponent;
	}

	public void setQualituOfOpponent(String qualityOfOpponent) {
		this.qualityOfOpponent = qualityOfOpponent;
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

	public boolean isImportanceOfGame() {
		return importanceOfGame;
	}

	public void setImportanceOfGame(boolean importanceOfGame) {
		this.importanceOfGame = importanceOfGame;
	}

	public boolean isBall() {
		return ball;
	}

	public void setBall(boolean ball) {
		this.ball = ball;
	}

	public Player getopponentPg() {
		return opponentPg;
	}

	public void setopponentPg(Player opponentPg) {
		this.opponentPg = opponentPg;
	}

	public Player getopponentSg() {
		return opponentSg;
	}

	public void setopponentSg(Player opponentSg) {
		this.opponentSg = opponentSg;
	}

	public Player getopponentSf() {
		return opponentSf;
	}

	public void setopponentSf(Player opponentSf) {
		this.opponentSf = opponentSf;
	}

	public Player getopponentPf() {
		return opponentPf;
	}

	public void setopponentPf(Player opponentPf) {
		this.opponentPf = opponentPf;
	}

	public Player getopponentC() {
		return opponentC;
	}

	public void setopponentC(Player opponentC) {
		this.opponentC = opponentC;
	}

	public Player getopponentSubsPg() {
		return opponentSubsPg;
	}

	public void setopponentSubsPg(Player opponentSubsPg) {
		this.opponentSubsPg = opponentSubsPg;
	}

	public Player getopponentsSubsSg() {
		return opponentsSubsSg;
	}

	public void setopponentsSubsSg(Player opponentsSubsSg) {
		this.opponentsSubsSg = opponentsSubsSg;
	}

	public Player getopponentSubsSf() {
		return opponentSubsSf;
	}

	public void setopponentSubsSf(Player opponentSubsSf) {
		this.opponentSubsSf = opponentSubsSf;
	}

	public Player getopponentSubsPf() {
		return opponentSubsPf;
	}

	public void setopponentSubsPf(Player opponentSubsPf) {
		this.opponentSubsPf = opponentSubsPf;
	}

	public Player getopponentSubsC() {
		return opponentSubsC;
	}

	public void setopponentSubsC(Player opponentSubsC) {
		this.opponentSubsC = opponentSubsC;
	}

	public Player getopponentSubsCPf() {
		return opponentSubsCPf;
	}

	public void setopponentSubsCPf(Player opponentSubsCPf) {
		this.opponentSubsCPf = opponentSubsCPf;
	}

	public Player getopponentsSubsPgSg() {
		return opponentsSubsPgSg;
	}

	public void setopponentsSubsPgSg(Player opponentsSubsPgSg) {
		this.opponentsSubsPgSg = opponentsSubsPgSg;
	}

}
