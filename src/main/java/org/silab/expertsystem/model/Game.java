package org.silab.expertsystem.model;

import org.silab.expertsystem.config.annotations.LabelId;

public class Game {

	@LabelId(id="ppg")
	Player pg;
	@LabelId(id="ssg")
	Player sg;
	@LabelId(id="ssf")
	Player sf;
	@LabelId(id="spf")
	Player pf;
	@LabelId(id="sc")
	Player c;
	Player subsPg;
	Player subsSg;
	Player subsSf;
	Player subsPf;
	Player subsC;
	Player cPf;
	Player pgSg;
	
	StringBuffer explanation = new StringBuffer();
	String qualityOfOpponent;
	boolean host;
	boolean importanceOfGame;
	
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
	
	
	
	public String getQualityOfOpponent() {
		return qualityOfOpponent;
	}
	public void setQualityOfOpponent(String qualityOfOpponent) {
		this.qualityOfOpponent = qualityOfOpponent;
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
	public Player getOpponentPg() {
		return opponentPg;
	}
	public void setOpponentPg(Player opponentPg) {
		this.opponentPg = opponentPg;
	}
	public Player getOpponentSg() {
		return opponentSg;
	}
	public void setOpponentSg(Player opponentSg) {
		this.opponentSg = opponentSg;
	}
	public Player getOpponentSf() {
		return opponentSf;
	}
	public void setOpponentSf(Player opponentSf) {
		this.opponentSf = opponentSf;
	}
	public Player getOpponentPf() {
		return opponentPf;
	}
	public void setOpponentPf(Player opponentPf) {
		this.opponentPf = opponentPf;
	}
	public Player getOpponentC() {
		return opponentC;
	}
	public void setOpponentC(Player opponentC) {
		this.opponentC = opponentC;
	}
	public Player getOpponentSubsPg() {
		return opponentSubsPg;
	}
	public void setOpponentSubsPg(Player opponentSubsPg) {
		this.opponentSubsPg = opponentSubsPg;
	}
	public Player getOpponentsSubsSg() {
		return opponentsSubsSg;
	}
	public void setOpponentsSubsSg(Player opponentsSubsSg) {
		this.opponentsSubsSg = opponentsSubsSg;
	}
	public Player getOpponentSubsSf() {
		return opponentSubsSf;
	}
	public void setOpponentSubsSf(Player opponentSubsSf) {
		this.opponentSubsSf = opponentSubsSf;
	}
	public Player getOpponentSubsPf() {
		return opponentSubsPf;
	}
	public void setOpponentSubsPf(Player opponentSubsPf) {
		this.opponentSubsPf = opponentSubsPf;
	}
	public Player getOpponentSubsC() {
		return opponentSubsC;
	}
	public void setOpponentSubsC(Player opponentSubsC) {
		this.opponentSubsC = opponentSubsC;
	}
	public Player getOpponentSubsCPf() {
		return opponentSubsCPf;
	}
	public void setOpponentSubsCPf(Player opponentSubsCPf) {
		this.opponentSubsCPf = opponentSubsCPf;
	}
	public Player getOpponentsSubsPgSg() {
		return opponentsSubsPgSg;
	}
	public void setOpponentsSubsPgSg(Player opponentsSubsPgSg) {
		this.opponentsSubsPgSg = opponentsSubsPgSg;
	}
	
	
}
