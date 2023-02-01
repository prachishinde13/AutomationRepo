package util;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.WebTestBase;

import java.time.Duration;
import java.util.List;
import java.util.Set;



public class Utility extends WebTestBase{
    public static final long PAGE_LOAD_TIMEOUT =20;
    public static final long IMPLICITLY_WAIT = 20;

    public static void waitUntilElementToBeClick(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT));


        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void switchToWindows(WebDriver driver) {


        String parentWindows = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        for (String s : allWindow) {
            if (!parentWindows.contentEquals(s)) {
                driver.switchTo().window(s);
            }
        }
    }

        public static void selectValue(WebElement element, String term, String value){
            Select dropDown=new Select(element);
            if(term.equalsIgnoreCase("byValue")){
                dropDown.selectByValue(value);
            }else if(term.equalsIgnoreCase("byIndex")){
                dropDown.selectByIndex(Integer.parseInt(value));
            }else if(term.equalsIgnoreCase("byVisibleText")){
                dropDown.selectByVisibleText(value);
            }else {
                System.out.println("Please select the correct value");
            }
        }

        public static void dropDownElement(List<WebElement> elements, String course) {
            for (WebElement e : elements) {
                System.out.println(e.getText());
                if (e.getText().equalsIgnoreCase(course)) {
                    e.click();
                    break;
                }
            }
        }



    public static void addCookie() {
        Cookie cookie = new Cookie("Happy", "to Come Libas");
        driver.manage().addCookie(cookie);

    }

    public static void setCookies() {
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies) {
            System.out.println(c);
        }

    }
    }



