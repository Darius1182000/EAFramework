package steps;

import com.ea.framework.base.Base;
import com.ea.framework.utilities.CucumberUtil;
import pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps extends Base {
    @And("The application opens up")
    public void theApplicationOpensUp() {
        CurrentPage = GetInstance(LoginPage.class);
        Assert.assertTrue("The login page is not loaded",CurrentPage.As(LoginPage.class).isLogin());
    }

    @When("I enter the username and password")
    public void iEnterTheUsernameAndPassword(DataTable dataTable) {
        //List<List<String>> table = data.asLists();
        //CurrentPage.As(LoginPage.class).Login(table.get(1).get(0), table.get(1).get(1));
        CucumberUtil.convertDataTableToDictionary(dataTable);
        //CurrentPage.As(LoginPage.class).Login(CucumberUtil.getCellValue("Username"),CucumberUtil.getCellValue("Password"));
        CurrentPage.As(LoginPage.class).Login(CucumberUtil.getCellValueWithRowIndex("Username", 1),CucumberUtil.getCellValueWithRowIndex("Password", 1));
    }

    @Then("I click the login button")
    public void iClickTheLoginButton() throws InterruptedException {
        CurrentPage.As(LoginPage.class).clickLogin();
        //Thread.sleep(3000);
    }

    @Then("Home page opens up")
    public void homePageOpensUp() {
    }
}
