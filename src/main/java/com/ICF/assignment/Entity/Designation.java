package com.ICF.assignment.Entity;

public enum Designation {
	
	Manager("Manger"), Assistant("Assistant"),Developer("Developer"),Tester("Tester");

	private String post;
	
	Designation(String post){
		this.post=post;
	}
}
