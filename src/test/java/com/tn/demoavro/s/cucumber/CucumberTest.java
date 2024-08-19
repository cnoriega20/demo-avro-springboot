package com.tn.demoavro.s.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber", glue = "com.tn.demoavro.s.cucumber")
public class CucumberTest {
}
