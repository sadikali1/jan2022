package com.steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {

	static int a;
	static int b;
	static int result;

	@Given("Two integer number {int} and {int}")
	public void two_integer_number_and(Integer int1, Integer int2) {
		a = int1;
		b = int2;
	}

	@When("I added both interger number")
	public void i_added_both_interger_number() {
		result = a + b;
	}

	@Then("result is equals to {int}")
	public void result_is_equals_to(Integer int1) {
		Assert.assertEquals(result, int1);
	}

	@Given("I am background scenario")
	public void i_am_background_scenario() {
		System.out.println("I executed background");
	}

}
