package runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.ea.framework.utilities.ExtentReport;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Scenario;
import io.cucumber.messages.types.PickleTag;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.Pickle;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.SignUpSteps;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@CucumberOptions(features = {"src/test/java/features"}, glue = {"steps"}, plugin = {"pretty",
        "json:target/cucumber-json-report.json",
        "html:target/cucumber-report-html/report.html"})
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
        //Insert the feature name
        Pickle pickle = pickleWrapper.getPickle();
        String uri = pickle.getUri().toString();
        String[] uriParts = uri.split("/");
        String featureFileName = uriParts[uriParts.length - 1];
        ExtentReport.feature = ExtentReport.extentReport.createTest(Feature.class, featureFileName);

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

//May work
//    @DataProvider
//    public Object[] features(ITestContext context){
//        var featureName = testNGCucumberRunner.provideScenarios();
//        Object[] getFeature = null;
//        for(var item : featureName){
//            if(item[0].toString().equalsIgnoreCase(context.getName())){
//                getFeature = item;
//            }
//        }
//        return getFeature;
//    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        testNGCucumberRunner.finish();
    }

   //This is a better approach to work with datatables
//    @DataTableType(replaceWithEmptyString = "[blank]")
//    public SignUpSteps convert(Map<String, String> entry){
//        return  new SignUpSteps(
//                entry.get("Username"),
//                entry.get("Password")
//        );
//    }


}
//ToDo See online if features were renamed in scenarios in newer versions