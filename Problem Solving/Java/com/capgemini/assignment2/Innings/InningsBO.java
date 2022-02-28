package com.capgemini.assignment2.Innings;

class InningsBO{
	Innings createInnings(String data) {
		String temp[]=data.split(",");
		return new Innings(Long.valueOf(temp[0]), temp[1]);
	}
}
