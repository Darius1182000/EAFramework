package steps;

import com.ea.framework.base.Base;
import com.ea.framework.utilities.CucumberUtil;
import pages.LoginPage;
import pages.SignUpPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignUpSteps extends Base {

    @And("I ensure application opened")
    public void iEnsureApplicationOpened() {

        CurrentPage = GetInstance(LoginPage.class);
        Assert.assertTrue("The login page is not loaded",CurrentPage.As(LoginPage.class).isLogin());
    }

    @Then("I click the signUp link")
    public void iClickTheLoginLink() {

        CurrentPage = CurrentPage.As(LoginPage.class).clickSignUp();
    }

    @When("I enter the signUp data")
    public void iEnterTheSignUpData() throws InterruptedException {
        CurrentPage = CurrentPage.As(SignUpPage.class).SignUp("darius", "merca", "darius112", "darius12345", "darius12345");
        //Thread.sleep(1000);
    }

    @When("I enter Username and Password")
    public void iEnterUserNameAndPassword(DataTable dataTable) {

//        List<List<String>> table = data.asLists();
//        CurrentPage.As(LoginPage.class).Login(table.get(1).get(0), table.get(1).get(1));
        CucumberUtil.convertDataTableToDictionary(dataTable);
        //CurrentPage.As(LoginPage.class).Login(CucumberUtil.getCellValue("Username"),CucumberUtil.getCellValue("Password"));
        CurrentPage.As(LoginPage.class).Login(CucumberUtil.getCellValueWithRowIndex("Username", 1),CucumberUtil.getCellValueWithRowIndex("Password", 1));
    }

    @Then("I click login button")
    public void iClickLoginButton() throws InterruptedException {
        CurrentPage.As(LoginPage.class).clickLogin();
        //Thread.sleep(3000);
        //DriverContext.waitForPageToLoad();
    }

    @Then("I should see the username with hello")
    public void iShouldSeeTheUsernameWithHello() {
    }
}
