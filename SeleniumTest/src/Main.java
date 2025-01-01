import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

import java.io.File;
import java.io.IOException;


public class Main {
    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kaan\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToURL(String url) {
        driver.get(url);
    }

    public void navigateToCareers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement companyMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='navbarDropdownMenuLink' and contains(text(), 'Company')]")));
        companyMenu.click();
        WebElement careersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://useinsider.com/careers/' and contains(@class, 'dropdown-sub')]")));
        careersLink.click();
    }

    public void navigateToQAJobs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement QAJobs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-outline-secondary.rounded.text-medium.mt-2.py-3.px-lg-5.w-100.w-md-50")));
        QAJobs.click();
    }

    public void chooseFilters() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement filters = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select2-filter-by-location-container\"]")));
        filters.click();
        WebElement chooseIstanbul = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select2-filter-by-location-result-pv1j-Istanbul, Turkey\"]")));
        chooseIstanbul.click();
    }

    public static void copyFile(File src, File dest) throws IOException {
        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

    public void takeScreenshot(Main obj) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) obj.driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        File destFile = new File("screenshot.png");
        obj.copyFile(srcFile, destFile);
    }

    public static void main(String[] args) throws IOException {
        Main obj = new Main();
        obj.launchBrowser();
        HomePage homePage = new HomePage(obj.driver);
        CareerPage careerPage = new CareerPage(obj.driver);


        obj.goToURL("https://useinsider.com/");

        if (!homePage.isHomePageLoaded()){
            obj.takeScreenshot(obj);
        }

        obj.navigateToCareers();

        if (!careerPage.isTeamsLoaded()){
            obj.takeScreenshot(obj);
        }
        if (!careerPage.isLocationsLoaded()){
            obj.takeScreenshot(obj);
        }
        if (!careerPage.isLifeAtLoaded()){
            obj.takeScreenshot(obj);
        }

        obj.goToURL("https://useinsider.com/careers/quality-assurance/");
        obj.navigateToQAJobs();
        obj.chooseFilters();

    }
}