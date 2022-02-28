package com.capgemini.assignment2.Innings;

class Delivery{
	Long deliveryNumber, runs, inningsNumber;
	String batsman, bowler;
	Innings innings;
	Delivery(Long deliveryNumber, Long runs, Long inningsNumber, String batsman, String bowler, Innings innings) {
		this.deliveryNumber = deliveryNumber;
		this.runs = runs;
		this.inningsNumber = inningsNumber;
		this.batsman = batsman;
		this.bowler = bowler;
		this.innings = innings;
	}
	
	public Long getDeliveryNumber() {
		return deliveryNumber;
	}
	public Long getRuns() {
		return runs;
	}
	public Long getInningsNumber() {
		return inningsNumber;
	}
	public String getBatsman() {
		return batsman;
	}
	public String getBowler() {
		return bowler;
	}
	public Innings getInnings() {
		return innings;
	}
}
