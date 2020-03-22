import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class AndroidTest {
    private AppiumDriverLocalService service;
    private AndroidDriver<WebElement> driver;
    private DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    private WebDriverWait wait;

    @BeforeSuite
    public void globalSetup() {
        this.service = AppiumDriverLocalService.buildDefaultService();
        this.service.start();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9");
        desiredCapabilities.setCapability("deviceName", "device");
        desiredCapabilities.setCapability("udid", "WQD4C18C11006674");
        desiredCapabilities.setCapability("app", "C:\\Users\\orino\\IdeaProjects\\androidAutoTest1\\Calculator.apk");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");

    }

    @BeforeMethod
    public void eachTestSetup() {
        this.driver = new AndroidDriver<WebElement>(this.service.getUrl(), desiredCapabilities);
        wait = new WebDriverWait(driver, 4);
    }

    @Test
    public void simpleMonoOperationTest() {
        CalcFiguresSteps calcFiguresSteps = new CalcFiguresSteps();
        CountBasicSteps countBasicSteps = new CountBasicSteps();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@resourse-id = 'com.google.android.calculator:id/pad_advanced']")));
        int[] numbersForAssessment = new int[]{2, 3};
        String operation = "вычесть";

        for (int i = 0; i < numbersForAssessment.length; i++) {
            MobileElement number = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text = '" + numbersForAssessment[i] + "']"));
            number.click();
            if (i < numbersForAssessment.length - 1) {
                MobileElement operationButton = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@content-desc = '" + operation + "']"));
                operationButton.click();
            }
        }

        MobileElement equalMark = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@content-desc = 'равно']"));
        equalMark.click();

        MobileElement resultMobileElement = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView"));
        String resFromMobileString = resultMobileElement.getText();
        int actualResult = calcFiguresSteps.intParse(resFromMobileString);
        int expectedResult = countBasicSteps.countResultForFixedNumberOperation(operation, numbersForAssessment);
        Assert.assertEquals(expectedResult, actualResult);
    }


    @Test
    public void numbersRightCombinationAssessment() {
        CalcFiguresSteps calcFiguresSteps = new CalcFiguresSteps();
        int numberForAssessment = 1068;
        int[] numbersForXpath = new int[]{1, 0, 6, 8};

        for (int i = 0; i < numbersForXpath.length; i++) {
            driver.findElement(By.xpath("//android.widget.Button[@text = '" + numbersForXpath[i] + "']")).click();
        }
        MobileElement resultMobileElement = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView"));
        String resFromMobileString = resultMobileElement.getText();
        int resFromMobileInt = calcFiguresSteps.intParse(resFromMobileString);
        Assert.assertEquals(numberForAssessment, resFromMobileInt);
    }

    @Test
    public void calcInfoTest() {
        MobileElement settingsButton = (MobileElement) driver.findElement(By.xpath("//android.widget.ImageView[@content-desc = 'Еще']"));
        settingsButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text = 'Справка']")));
        MobileElement infoButton = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text = 'Справка']"));
        infoButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text = 'Помощь']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Опишите проблему']")));
        MobileElement describeProblemButton = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Опишите проблему']"));
        describeProblemButton.click();

        MobileElement describeProblemButtonSeparatePage = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Опишите проблему']"));
        describeProblemButtonSeparatePage.click();
        describeProblemButtonSeparatePage.sendKeys("Калькулятор");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc = 'Как использовать приложение \"Калькулятор\"']")));

        MobileElement searchResultButton = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc = 'Как использовать приложение \"Калькулятор\"']"));
        searchResultButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text ='Как использовать приложение \"Калькулятор\"']")));
    }

    @AfterMethod()
    public void driverTearDown() {
        this.driver.quit();
    }

    @AfterSuite()
    public void serverTearDown() {
        this.service.stop();
    }
}