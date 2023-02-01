package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.Utility;

public class LoginPage extends WebTestBase {

    @FindBy(xpath ="//a[@class='site-nav__link site-nav__link--icon small--hide']")
    WebElement loginBox;

    @FindBy(id = "CustomerEmail")
    WebElement emailTextBox;

    @FindBy(id ="CustomerPassword")
    WebElement passwordTextBox;

    @FindBy(xpath= "//button[@class='btn btn--full']")
    WebElement signInBtn;


    public LoginPage(){
        PageFactory.initElements(driver,this);
    }


    public void loginClick(){
        loginBox.click();

    }

    public void login(String email, String password){
        Utility.waitUntilElementToBeClick(driver, emailTextBox);
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        signInBtn.click();
    }



}
