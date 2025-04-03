package libs.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import libs.Platform;

public class MainPageObject {
    protected RemoteWebDriver driver;
    protected static String
            ONBORDING_SKIP_BUTTON = "xpath://android.widget.Button[@resource-id=\"org.wikipedia:id/fragment_onboarding_skip_button\"]",
            ONBORDING_FOR_SWIPE = "xpath://android.widget.TextView[@resource-id=\"org.wikipedia:id/primaryTextView\"]",
            ONBORDING_ACCEPT_BUTTON = "xpath://android.widget.Button[@resource-id=\"org.wikipedia:id/acceptButton\"]",
            MAIN_PAGE = "xpath://android.widget.ImageView[@resource-id=\"org.wikipedia:id/main_toolbar_wordmark\"]";

    public MainPageObject(RemoteWebDriver driver) {
        this.driver = driver;
    }

    protected void swipeUp(int timeOfSwipe) {
        if (driver instanceof AppiumDriver) {
        TouchAction action = new TouchAction((AppiumDriver)driver);

            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int start_y = (int) (size.height * 0.8);
            int end_y = (int) (size.height * 0.2);
            action.press(PointOption.point(x, start_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                    .moveTo(PointOption.point(x, end_y))
                    .release().perform();
        } else {
            System.out.println("Method swipeUp() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }
//        protected void swipeElementToLeft(String locator, String errorMessage) {
//        if (driver instanceof AppiumDriver) {
//
//            WebElement element = waitForElementPresent(locator, errorMessage, 10);
//            int left_x = element.getLocation().getX();
//            int right_x = left_x + element.getSize().getWidth();
//            int upper_y = element.getLocation().getY();
//            int lower_y = upper_y + element.getSize().getHeight();
//            int middle_y = (upper_y + lower_y) / 2;
//
//            TouchAction action = new TouchAction( (AppiumDriver) driver);
//            action
////               .press(right_x, middle_y)
////               .waitAction(500)
//                    .press(PointOption.point(right_x, middle_y))
//                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
////               .moveTo(left_x, middle_y)
//                    .release()
//                    .perform();
//        } else {
//            System.out.println("Method swipeElementToLeft() does nothing for platform " + Platform.getInstance().getPlatformVar());
//
//        }
//
//    }



    public void swipeUpQuick() {
        //swipeUp(200);
        scroll(200);
    }

    public void scrollWebPageUp() {
    if (Platform.getInstance().isMW()) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.sсrollBy(0, 250)");
    } else {
        System.out.println("Method scrollWebPageUp() does nothing for platform " + Platform.getInstance().getPlatformVar());
    }
    }

    public void scrollWebPageTillElementNotVisible(String locator, String errorMessage, int maxSwipes) {
    int alreadySwiped = 0;
    WebElement element = this.waitForElementPresent(locator, errorMessage);

    while (!this.isElementLocatedOnTheScreen(locator)) {
        scrollWebPageUp();
        ++alreadySwiped;
        if (alreadySwiped > maxSwipes) {
            Assert.assertTrue(errorMessage, element.isDisplayed());
        }
    }
    }

    public void swipeUpToFindElement(String locator, String errorMessage, int maxSwipes) {
        int alreadySwiped = 0;
        By by = this.getLocatorByString(locator);
        while(driver.findElements(by).size()== 0) {
            if (alreadySwiped > maxSwipes) {
                waitForElementPresent(locator, "error", 0);
                return;
            }
            swipeUpQuick();
            ++alreadySwiped;
        }
    }

    public WebElement waitForElementPresent(String locator, String errorMessage, long timeOutSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable(String locator, String errorMessage, long timeOutSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitForElementPresent(String locator, String errorMessage) {
        return waitForElementPresent(locator, errorMessage, 5);
    }

    public WebElement waitForElementAndClick(String locator, String errorMessage, long timeOutInSeconds) {
        WebElement element =  waitForElementPresent(locator, errorMessage,  timeOutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String errorMessage, long timeOutInSeconds) {
        WebElement element =  waitForElementPresent(locator, errorMessage,  timeOutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(String locator, String errorMessage, long timeOutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClear(String locator, String errorMessage, long timeOutInSeconds) {
        WebElement element =  waitForElementPresent(locator, errorMessage,  timeOutInSeconds);
        element.clear();
        return element;
    }

//    public void skipOnboarding() {
//        waitForElementAndClick(ONBORDING_SKIP_BUTTON,
//                "Cannot find skip button in Onboarding",
//                5);
//    }

//    public void swipeOnbording() {
//        swipeElementToLeft(ONBORDING_FOR_SWIPE,
//                "Main page of Onbording not found");
//    }

//    public void clickAcceptButtonOnOnbording() {
//        waitForElementAndClick(ONBORDING_ACCEPT_BUTTON,
//                "Button Accept not found",
//                10);
//    }

//    public boolean assertMainPagePresent() {
//        WebElement element = waitForElementPresent(MAIN_PAGE, "Main page not found", 5);
//        return element.isEnabled();
//    }

    public int getAmountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    public boolean isElementPresent(String locator) {
    return  getAmountOfElements(locator) > 0;

    }

    public void tryClickElementWithFewAttempts(String locator, String errorMessage, int amountOfAttempts) {
    int currentAttempts = 0;
    boolean needMoreAttempts = true;

    while (needMoreAttempts) {
        try {
            waitForElementAndClick(locator, errorMessage, 1);
            needMoreAttempts = false;
        } catch (Exception e) {
            if (currentAttempts > amountOfAttempts) {
                waitForElementAndClick(locator, errorMessage, 1);
            }
        }
        ++currentAttempts;
    }

    }

    public void assertElementNotPresent(String locator, String errorMessage) {
        int amountOfElements = getAmountOfElements(locator);
        if (amountOfElements > 0) {
            String defaultMessage = "An element " + locator + " supposed to be not present ";
            throw new AssertionError(defaultMessage + "   " + errorMessage);

        }
    }

    public String wailForElementAndGetAttribute(String locator, String attribute, String error_message, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeOutInSeconds);
        return element.getAttribute(attribute);
    }

    public void swipeElementToLeft(String locator, String error_message) {

    if (driver instanceof AppiumDriver) {

        // Находим элемент на экране, ожидая его появления в течение 10 секунд.
        WebElement element = waitForElementPresent(locator, error_message, 10);

        // Получаем координаты элемента на экране.
        Point location = element.getLocation();
        // Получаем размеры элемента (ширину и высоту).
        Dimension size = element.getSize();

        // Координата по оси X левой границы элемента.
        int left_x = location.getX();
        // Координата по оси X правой границы элемента.
        int right_x = left_x + size.getWidth();
        // Координата по оси Y верхней границы элемента.
        int upper_y = location.getY();
        // Координата по оси Y нижней границы элемента.
        int lower_y = upper_y + size.getHeight();
        // Координата по оси Y средней линии элемента.
        int middle_y = upper_y + (size.getHeight() / 2);

        // Начальная координата по оси X для свайпа (чуть левее правого края элемента).
        int start_x = right_x - 20;
        // Конечная координата по оси X для свайпа (чуть правее левого края элемента).
        int end_x = left_x + 20;
        // Начальная координата по оси Y для свайпа (по центру элемента).
        int start_y = middle_y;
        // Конечная координата по оси Y для свайпа (также по центру элемента).
        int end_y = middle_y;

        // Выполняем свайп с начальной точки до конечной с заданной продолжительностью.

        if (Platform.getInstance().isAndroid()) {
            this.swipe(
                    new Point(start_x, start_y),
                    new Point(end_x, end_y),
                    Duration.ofMillis(550)  // Устанавливаем продолжительность свайпа 550 миллисекунд.
            );
        } else {
            int offset_x = (-1 * element.getSize().getWidth());

            this.swipe(
                    new Point(start_x, start_y),
                    new Point(offset_x, 0),
                    Duration.ofMillis(550)  // Устанавливаем продолжительность свайпа 550 миллисекунд.
            );
        }
    } else {
        System.out.println("Method swipeElementToLeft() does nothing for platform " + Platform.getInstance().getPlatformVar());

    }
    }

    public void swipeElementToFooter(String locator, String error_message) {

        // Находим элемент на экране, ожидая его появления в течение 10 секунд.
        WebElement element = waitForElementPresent(locator, error_message, 10);

        // Получаем координаты элемента на экране.
        Point location = element.getLocation();
        // Получаем размеры элемента (ширину и высоту).
        Dimension size = element.getSize();

        // Координата по оси X левой границы элемента.
        int left_x = location.getX();
        // Координата по оси X правой границы элемента.
        int right_x = left_x + size.getWidth();
        // Координата по оси Y верхней границы элемента.
        int upper_y = location.getY();
        // Координата по оси Y нижней границы элемента.
        int lower_y = upper_y + size.getHeight();
        // Координата по оси Y средней линии элемента.
        int middle_y = upper_y + (size.getHeight() / 2);

        // Начальная координата по оси X для свайпа (чуть левее правого края элемента).
        int start_x1 = right_x - 20;
        // Конечная координата по оси X для свайпа (чуть правее левого края элемента).
        int end_x1 = left_x + 20;
        // Начальная координата по оси Y для свайпа (по центру элемента).
        int start_y1 = middle_y;
        // Конечная координата по оси Y для свайпа (также по центру элемента).
        int end_y1 = middle_y;

        int x = size.width /2;
        int start_y = (int)(size.height * 0.8);
        int end_y = (int)(size.height * 0.2);

        // Выполняем свайп с начальной точки до конечной с заданной продолжительностью.
        this.swipe(
                new Point(x, end_y),
                new Point(x, start_y),
                Duration.ofMillis(550)  // Устанавливаем продолжительность свайпа 550 миллисекунд.
        );
    }

    public void swipe(Point start, Point end, Duration duration) {

        // Создаем объект, представляющий палец для выполнения свайпа.
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        // Создаем последовательность действий для выполнения свайпа.
        Sequence swipe = new Sequence(finger, 1);

        // Добавляем действие для перемещения пальца к начальной точке.
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        // Добавляем действие для нажатия на экран в начальной точке.
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        // Добавляем действие для перемещения пальца из начальной точки в конечную в течение заданного времени.
        swipe.addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        // Добавляем действие для отпускания пальца от экрана в конечной точке.
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Выполняем последовательность действий (свайп).
        this.driver.perform(Arrays.asList(swipe));
    }

    public By getLocatorByString(String locatorWithType) {
        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        if (byType.equals("xpath")) {
            return By.xpath(locator);
        } else if (byType.equals("id")) {
            return By.id(locator);
        } else if (byType.equals("css")) {
            return By.cssSelector(locator);
        }  else {
            throw  new IllegalArgumentException("Cannot get type of locator " + locatorWithType);
        }
    }

    // есть элемент на странице или нет по его положению по оси Y в отношении к длине всей странице
    public boolean isElementLocatedOnTheScreen(String locator) {
        // находим элемент по локатору и получаем расположение по оси Y
        int elementLocationByY = this.waitForElementPresent(locator, "Cannot find element by locator", 5).getLocation().getY();
        if (Platform.getInstance().isMW()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            Object jsResult = javascriptExecutor.executeScript("return window.pageYOffset");
            elementLocationByY -= Integer.parseInt(jsResult.toString());

        }

        int screenSizeByY = driver.manage().window().getSize().getHeight(); // длина всего экрана
        return elementLocationByY < screenSizeByY; // пока переменная больше, чем размер экрана по высоте, то false
    }

    public void swipeUpTillElementAppear(String locator, String errorMessage, int max_swipes) {
      int already_swiped = 0;
      while (!this.isElementLocatedOnTheScreen(locator)) {
          if (already_swiped > max_swipes) {
              Assert.assertTrue(errorMessage, this.isElementLocatedOnTheScreen(locator));
          }
          swipeUpQuick();
          ++already_swiped;
      }
    }

    public void scroll(int timeOfScroll)
    {
        Dimension size = driver.manage().window().getSize();

        int startY = (int) (size.height * 0.70);
        int endY = (int) (size.height * 0.30);
        int centerX = size.width / 2;
//        System.out.println(size);
//        System.out.println(startY);
//        System.out.println(endY);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swipe = new Sequence(finger,1)

                //Двигаем палец на начальную позицию
                .addAction(finger.createPointerMove(Duration.ofSeconds(0),
                        PointerInput.Origin.viewport(), centerX, startY))
                //Палец прикасается к экрану
                .addAction(finger.createPointerDown(0))

                //Палец двигается к конечной точке
                .addAction(finger.createPointerMove(Duration.ofMillis(timeOfScroll),
                        PointerInput.Origin.viewport(), centerX, endY))

                //Убираем палец с экрана
                .addAction(finger.createPointerUp(0));

        //Выполняем действия
        driver.perform(Arrays.asList(swipe));
    }

    public void clickElementToTheRightUpperCorner(String locator, String errorMessage) {
        if (driver instanceof AppiumDriver) {

            WebElement element = waitForElementPresent(locator, errorMessage);

            int right_x = element.getLocation().getX();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getHeight();
            int middle_y = (upper_y + lower_y) / 2;
            int width = element.getSize().getWidth();

            int pointToClickX = (right_x + width) - 3;
            int pointToClickY = middle_y;

            TouchAction action = new TouchAction((AppiumDriver) driver);
            action.tap(PointOption.point(pointToClickX, pointToClickY)).perform();
        } else {
            System.out.println("Method backgroundApp() does nothing for platform " + Platform.getInstance().getPlatformVar());

        }

    }

//    public WebElement waitForElementPresent(By by, String error_message, long timeOut) {
//    WebDriverWait wait = new WebDriverWait(driver, timeOut);
//    wait.withMessage("Cannot find locator");
//    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
//    }
//
//    public WebElement waitForElementAndClick(By by, String errorMessage, long timeOut) {
//    WebElement element = waitForElementPresent(by, errorMessage, timeOut);
//    element.click();
//    return element;
//    }
//
//    public boolean waitForElementNotPresent(By by, String errorMessage, long time) {
//    WebDriverWait wait = new WebDriverWait(driver, time);
//    wait.withMessage("");
//    return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
//    }

    public String takeScreenshot(String name) {
    TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
    File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
    String path = System.getProperty("user.dir") + "/" + name + "_screenshot.png";
    try {
        FileUtils.copyFile(source, new File(path));
        System.out.println("The screenshot was taken: " + path);
    } catch (Exception e) {
        System.out.println("Cannot take screenshot. Error:" + e.getMessage());
    }
    return path;
    }

    @Attachment
    @Description("Метод, возвращающий массив байтов. Информация будет добавлена в отчёт в виде файла")
    public static byte[] screenshot(String path) {
    byte[] bytes = new byte[0];

    try {
        bytes = Files.readAllBytes(Paths.get(path));
    } catch (IOException e) {
        System.out.println("Cannot get bytes from screenshot. Error: " + e.getMessage());
    } return bytes;
    }
}
