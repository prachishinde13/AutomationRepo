package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import testbase.WebTestBase;

public class HomeTest extends WebTestBase {

    HomePage homePage;


    public HomeTest(){
        super();
    }
    @BeforeMethod
    public void beforeMethod() {
        initialization();
        homePage = new HomePage();
    }
    @Test
    public void verifySearchFunctionality() {
        SoftAssert softAssert = new SoftAssert();
        homePage.searchBar();
        homePage.searchFunction(prop.getProperty("search"));
        homePage.setSearchNext();
        softAssert.assertAll();
    }


    @Test
    public void verifyDropDownFunctionality() {
        SoftAssert softAssert = new SoftAssert();
        homePage.dropDownSelect(prop.getProperty("course"));
        softAssert.assertAll();
    }

    @Test
    public void verifyMouseOverFunctionality(){
        SoftAssert softAssert = new SoftAssert();
        homePage.setMouseOver();
        softAssert.assertAll();
    }

    @Test
    public void verifyWindowHandle(){
        SoftAssert softAssert = new SoftAssert();
        homePage.windowHandle();
        homePage.order();
        softAssert.assertAll();

    }

    @Test
    public void verifyCookiesSelect(){
        SoftAssert softAssert = new SoftAssert();
        homePage.cookiesSelect();
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}




