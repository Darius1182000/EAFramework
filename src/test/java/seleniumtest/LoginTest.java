package seleniumtest;

import com.ea.framework.utilities.ExcelUtil;
import pages.LoginPage;
import pages.SignUpPage;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestInitializeJunit {

    @Test
    public void Login() throws InterruptedException {

        CurrentPage = GetInstance(LoginPage.class);
        CurrentPage = CurrentPage.As(LoginPage.class).clickSignUp();
        CurrentPage = CurrentPage.As(SignUpPage.class).SignUp("darius", "merca", "darius112", "darius12345", "darius12345");

        Thread.sleep(1000);

        //Hardcoded
        //CurrentPage.As(LoginPage.class).Login("darius112","darius12345");

        //Retrieve data from Excel sheet
        CurrentPage.As(LoginPage.class).LoginM(ExcelUtil.readCell("Username",1),
                ExcelUtil.readCell("Password",1));
//        CurrentPage.As(LoginPage.class).Login(username, password);
    }
}
