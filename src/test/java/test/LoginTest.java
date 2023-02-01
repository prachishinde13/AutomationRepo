package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testbase.WebTestBase;

public class LoginTest extends WebTestBase {
    pages.LoginPage loginPage;

    public LoginTest(){
        super();
    }

    @BeforeMethod
    public void beforeMethod(){
        initialization();
        loginPage= new pages.LoginPage();
    }
    @Test(description="Login Functionality")

    public void verifyLoginWithValidCredential(){
        SoftAssert softAssert =new SoftAssert();

        loginPage.loginClick();
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        softAssert.assertAll();
    }
    @AfterMethod
    public void afterMethod(){
        driver.close();
    }

}


