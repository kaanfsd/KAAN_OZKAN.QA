import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareerPage {
    WebDriver driver;

    public CareerPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTeamsLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"career-find-our-calling\"]")));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLocationsLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"career-our-location\"]")));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLifeAtLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-id=\"a8e7b90\"]\n")));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



}
