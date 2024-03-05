package com.ea.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/com/ea/test/features"}, glue = {"com/ea/test/steps"})
public class CucumberTest {
}
