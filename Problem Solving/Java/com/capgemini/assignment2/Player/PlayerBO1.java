package com.capgemini.assignment2.Player;

class PlayerBO1{
	Player createPlayer(String data) {
		Player obj=new Player(data.substring(0, data.indexOf(',')), data.substring(data.indexOf(',')+1, data.indexOf(',', data.indexOf(',')+1)), data.substring(data.lastIndexOf(',')+1, data.length()));
		return obj;
	}
}
