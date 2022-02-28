package com.capgemini.assignment2.Innings;

class DeliveryBO{
	 Delivery createDelivery(String data, Innings [] inningsList) {
		 String temp[]=data.split(",");
		 for(Innings i:inningsList) {
			 if(i.getInningsNumber().equals(Long.valueOf(temp[4])))
				 return new Delivery(Long.valueOf(temp[0]), Long.valueOf(temp[3]), Long.valueOf(temp[4]), temp[1], temp[2], i);
		 }
		 return null;
	 }
	 
	 String findInningsNumber(Delivery [] deliveriesList, Long deliveryNumber) {
		 for(Delivery i:deliveriesList) {
			 if(i.getDeliveryNumber().equals(deliveryNumber))
				 return i.getInnings().getInningsNumber().toString();
		 }
		 return "";
	 }
}
