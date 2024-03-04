package com.ea.test.steps;

import com.ea.framework.base.Base;
import com.ea.test.pages.LoginPage;
import com.ea.test.pages.SignUpPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class LoginSteps extends Base {

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
        Thread.sleep(1000);
    }

    @When("I enter Username and Password")
    public void iEnterUserNameAndPassword(DataTable data) {

        List<List<String>> table = data.asLists();
       //CurrentPage.As(LoginPage.class).Login(table.get(0).toString(),table.get(1).toString());
        CurrentPage.As(LoginPage.class).Login(table.get(1).get(0).toString(), table.get(1).get(1).toString());
    }

    @Then("I click login button")
    public void iClickLoginButton() throws InterruptedException {
        CurrentPage.As(LoginPage.class).clickLogin();
        Thread.sleep(3000);
    }

    @Then("I should see the username with hello")
    public void iShouldSeeTheUsernameWithHello() {
    }
}
