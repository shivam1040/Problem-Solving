package com.capgemini.assignment3.TheRetailStoreDiscounts;

public class TheRetailStoreDiscounts {
	Double bill;
	
	public TheRetailStoreDiscounts(Double bill) {
		this.bill=bill;
	}
	
	public Double billAfterDiscount(Integer duration) {
		if(duration>2)
			return bill-bill*this.Discount();
		return bill-this.Discount();
	}
	
	public Double Discount() {
		return (int)(bill/100)*5.0;
	}
}