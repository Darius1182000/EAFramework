package com.ea.test.runner;

import io.cucumber.messages.types.PickleTag;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

@CucumberOptions(features = {"src/test/com/ea/test/features"}, glue = {"com/ea/test/steps"})
public class TestNgTest {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public  void setUpClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test(dataProvider = "features")
    public void runTests(PickleWrapper pickleWrapper){

        //DOesn't work
//        List<String> elements = pickleWrapper.getPickle().getTags();
//        for(Iterator<String> element = elements.iterator(); element.hasNext();){
//
//            //ToDO Bring the scenario name from Excel sheet using the out-of-the box library we have in utilities package
//            //Pass the hardcoded scenario
//            String scenarioName = element.next();
//            if(!scenarioName.equals("Scenario: Check Login")){
//                element.remove();
//            }
//        }
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] features(){
        Object[][] scenarios = testNGCucumberRunner.provideScenarios();
        Object[][] data = new Object[scenarios.length][1];
        for (int i = 0; i < scenarios.length; i++) {
            data[i][0] = scenarios[i][0];
        }
        return data;
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        testNGCucumberRunner.finish();
    }
}
//ToDo See online if features were renamed in scenarios in newer versions