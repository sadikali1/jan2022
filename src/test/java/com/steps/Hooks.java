package com.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {
	
	@Before
	public void setup() {
		System.out.println("Before running scenario");
	}
	
	@BeforeStep
	public void beforeStep() {
		System.out.println("Before Running each Steps");
	}
	
	
	@AfterStep
	public void afterStep() {
		System.out.println("After Running each Steps");
	}
	
	@After
	public void tearDown() {
		System.out.println("After running scenario");
	}

}
