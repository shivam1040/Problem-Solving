package com.shrenik.ex1;

public class Player {
	private int playerId;
	private String playerName;
	private int totalRuns;
	
	public Player() {}

	public Player(int playerId, String playerName, int totalRuns) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.totalRuns = totalRuns;
	}

	public int getPlayerId() {
		return playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", totalRuns=" + totalRuns + "]";
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}
	
	
	
	
	
}
