package com.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {
                "pretty",
                "html:target/reports/result.html"
        }
)
public class TestRunner {
}
