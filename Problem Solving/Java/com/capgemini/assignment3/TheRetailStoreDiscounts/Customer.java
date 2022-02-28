package com.capgemini.assignment3.TheRetailStoreDiscounts;

class Customer extends TheRetailStoreDiscounts{
	Integer duration;

	public Customer(Double bill, Integer duration) {
		super(bill);
		// TODO Auto-generated constructor stub
		this.duration=duration;
	}
	
	public Double Discount() {
		if(duration>2)
			return 0.05;
		return super.Discount();
	}
}
