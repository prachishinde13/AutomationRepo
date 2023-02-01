package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.ActionStuff;
import util.Utility;

import java.util.List;

public class HomePage extends WebTestBase {

    @FindBy(xpath = "//input[@class='st-search-input']")
    WebElement searchClk;

    @FindBy(xpath= "//span[@class='st-icon-search']")
    WebElement searchIcon;

    @FindBy(id = "//div[@class='grid-product__image-mask']")
    WebElement searchNext;

    @FindBy(xpath= "//a[@class='site-nav__link tracking']")
    WebElement windowHandle;

    @FindBy(xpath ="//label[@for='waybill']")
    WebElement trackOrder;

    @FindBy(id = "explDesk")
    WebElement dropDown;

    @FindBy(xpath = "//ul[@class='abs-m cd-secondary-dropdown is-hidden fade-in']//child::div/div/div/h4")
    List<WebElement> element;

    @FindBy(xpath = "//a[@class='site-nav__link site-nav__link--underline site-nav__link--has-dropdown']")
    WebElement mouseOver;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void searchBar() {
        searchClk.click();
    }
    public void searchFunction(String search){
        searchClk.sendKeys(search);
        searchIcon.click();
    }

    public void setSearchNext(){
        searchNext.click();
    }

    public void dropDownSelect(String course){
        Utility.waitUntilElementToBeClick(driver, dropDown);
        dropDown.click();
        Utility.dropDownElement(element, course);
    }

    public void windowHandle(){
        windowHandle.click();
        Utility.switchToWindows(driver);
    }

    public void order(){
        Utility.waitUntilElementToBeClick(driver, trackOrder);
        trackOrder.click();
    }

    public void setMouseOver(){
        ActionStuff.moveToElement(driver, mouseOver);
        mouseOver.click();
    }

    public void cookiesSelect(){
        Utility.addCookie();
        Utility.setCookies();
    }



}
