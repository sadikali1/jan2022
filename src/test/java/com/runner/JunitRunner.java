package com.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"com.steps"},
		plugin = { "pretty", "json:target/cucumber-reports/CucumberTestReport.json",
	        "html:target/cucumber-reports/cucumber-html.html"
	        },
		tags = "@Regression",
		dryRun = true
		)
public class JunitRunner {

}

