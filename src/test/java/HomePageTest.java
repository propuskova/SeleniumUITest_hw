import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


/*
1. Откройте страницу https://bonigarcia.dev/selenium-webdriver-java/
2. Проверьте, что все ссылки для Chapter 3-9 доступны и при нажатии открывается соответствующая страница
3. Проверьте заголовок страницы и url
4. Проверьте, что все ссылки принадлежат определенному Chapter, например, WebForm в Chapter 3. WebDriver Fundamentals
 */


public class HomePageTest {

    WebDriver driver; //запускает браузер
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver(); //запускает браузер
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterEach
    void tearDown () {
        driver.getPageSource(); //сохранение html страницы
        driver.quit(); //закрывает весь браузер

    }


    @Test
    void openHomePageTest () {
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();

        String expectedTitle = "Hands-On Selenium WebDriver with Java";
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

//2. Проверьте, что все ссылки для Chapter 3-9 доступны и при нажатии открывается соответствующая страница

    @Test
    void findWebFormTest () {
        //WebElement webForm = driver.findElement(By.xpath("//a[@href='web-form.html']")) ;// - внутри любой вложенности href
        //webForm.click();

        driver.findElement(By.xpath("//h5[text() = 'Chapter 3. WebDriver Fundamentals']/../a[contains(@href, 'web-form')]")).click();
        String expectedUrl = "web-form.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Web form", expectedTitle.getText()); //check

        driver.getPageSource();
    }

    @Test
    void findNavigationTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 3. WebDriver Fundamentals']/../a[contains(@href, 'navigation1')]")).click();
        String expectedUrl = "navigation1.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Navigation example", expectedTitle.getText()); //check
    }

    @Test
    void findDropdowmMenuTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 3. WebDriver Fundamentals']/../a[contains(@href, 'dropdown-menu.html')]")).click();
        String expectedUrl = "dropdown-menu.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Dropdown menu", expectedTitle.getText()); //check
    }

    @Test
    void findMouseOverTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 3. WebDriver Fundamentals']/../a[contains(@href, 'mouse-over.html')]")).click();
        String expectedUrl = "mouse-over.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Mouse over", expectedTitle.getText()); //check
    }

    @Test
    void findDragAndDropTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 3. WebDriver Fundamentals']/../a[contains(@href, 'drag-and-drop.html')]")).click();
        String expectedUrl = "drag-and-drop.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Drag and drop", expectedTitle.getText()); //check
    }

    @Test
    void findDrawInCanvasTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 3. WebDriver Fundamentals']/../a[contains(@href, 'draw-in-canvas.html')]")).click();
        String expectedUrl = "draw-in-canvas.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Drawing in canvas", expectedTitle.getText()); //check
    }

    @Test
    void findLoadingImagesTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 3. WebDriver Fundamentals']/../a[contains(@href, 'loading-images.html')]")).click();
        String expectedUrl = "loading-images.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Loading images", expectedTitle.getText()); //check
    }


    @Test
    void findSlowCalculatorTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 3. WebDriver Fundamentals']/../a[contains(@href, 'slow-calculator.html')]")).click();
        String expectedUrl = "slow-calculator.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Slow calculator", expectedTitle.getText()); //check
    }



    //Chapter-4
    @Test
    void findLongPageTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[contains(@href, 'long-page.html')]")).click();
        String expectedUrl = "long-page.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("This is a long page", expectedTitle.getText()); //check
    }

    @Test
    void findInfiniteScrollTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[contains(@href, 'infinite-scroll.html')]")).click();
        String expectedUrl = "infinite-scroll.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Infinite scroll", expectedTitle.getText()); //check
    }

    @Test
    void findShadowDOMTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[contains(@href, 'shadow-dom.html')]")).click();
        String expectedUrl = "shadow-dom.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Shadow DOM", expectedTitle.getText()); //check
    }

    @Test
    void findCookiesTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[contains(@href, 'cookies.html')]")).click();
        String expectedUrl = "cookies.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Cookies", expectedTitle.getText()); //check
    }

    @Test
    void findFramesTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[contains(@href, 'frames.html')]")).click();
        String expectedUrl = "frames.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Frames", expectedTitle.getText()); //check
    }

    @Test
    void findIFrameTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[contains(@href, 'iframes.html')]")).click();
        String expectedUrl = "iframes.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("IFrame", expectedTitle.getText()); //check
    }

    @Test
    void findDialogBoxesTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[contains(@href, 'dialog-boxes.html')]")).click();
        String expectedUrl = "dialog-boxes.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Dialog boxes", expectedTitle.getText()); //check
    }

    @Test
    void findWebStorageTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[contains(@href, 'web-storage.html')]")).click();
        String expectedUrl = "web-storage.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Web storage", expectedTitle.getText()); //check
    }

    //Chapter5
    @Test
    void findGeolocationTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 5. Browser-Specific Manipulation']/../a[contains(@href, 'geolocation.html')]")).click();
        String expectedUrl = "geolocation.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Geolocation", expectedTitle.getText()); //check
    }

    @Test
    void findNotificationsTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 5. Browser-Specific Manipulation']/../a[contains(@href, 'notifications.html')]")).click();
        String expectedUrl = "notifications.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Notifications", expectedTitle.getText()); //check
    }

    @Test
    void findGetUserMediaTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 5. Browser-Specific Manipulation']/../a[contains(@href, 'get-user-media.html')]")).click();
        String expectedUrl = "get-user-media.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Get user media", expectedTitle.getText()); //check
    }

    @Test
    void findMultilanguageTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 5. Browser-Specific Manipulation']/../a[contains(@href, 'multilanguage.html')]")).click();
        String expectedUrl = "multilanguage.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        //Assertions.assertEquals("multilanguage", expectedTitle.getText()); //check
    }

    @Test
    void findConsoleLogsTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 5. Browser-Specific Manipulation']/../a[contains(@href, 'console-logs.html')]")).click();
        String expectedUrl = "console-logs.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Console logs", expectedTitle.getText()); //check
    }

    //Chapter7
    @Test
    void findLoginFormTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 7. The Page Object Model (POM)']/../a[contains(@href, 'login-form.html')]")).click();
        String expectedUrl = "login-form.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Login form", expectedTitle.getText()); //check
    }

    @Test
    void findSlowLoginFormTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 7. The Page Object Model (POM)']/../a[contains(@href, 'login-slow.html')]")).click();
        String expectedUrl = "login-slow.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Slow login form", expectedTitle.getText()); //check
    }

    //Chapter8
    @Test
    void findRandomCalculatorTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 8. Testing Framework Specifics']/../a[contains(@href, 'random-calculator.html')]")).click();
        String expectedUrl = "random-calculator.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Random calculator", expectedTitle.getText()); //check
    }

    //Chapter9
    @Test
    void findDownloadFilesTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 9. Third-Party Integrations']/../a[contains(@href, 'download.html')]")).click();
        String expectedUrl = "download.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Download files", expectedTitle.getText()); //check
    }

    @Test
    void findABTestingTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 9. Third-Party Integrations']/../a[contains(@href, 'ab-testing.html')]")).click();
        String expectedUrl = "ab-testing.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("A/B Testing", expectedTitle.getText()); //check
    }

    @Test
    void findDataTypesTest () {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 9. Third-Party Integrations']/../a[contains(@href, 'data-types.html')]")).click();
        String expectedUrl = "data-types.html";
        String actualUrl = driver.getCurrentUrl();

        WebElement expectedTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals(BASE_URL + expectedUrl, actualUrl); //check URL
        Assertions.assertEquals("Data types", expectedTitle.getText()); //check
    }







}

//        String chapter3 = driver.findElement(By.linkText("Chapter 3. WebDriver Fundamentals")).getText();// - по тексту
//        String chapter4 = driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']")).getText();
//        String chapter5 = driver.findElement(By.xpath("//a[text() = 'Geolocation']/../h5[test() = 'Chapter 5. Browser-Specific Manipulation']")).getText();
//
//        String chapter7 = driver.findElement(By.linkText("Chapter 7. The Page Object Model (POM)")).getText();// - по тексту
//        String chapter8 = driver.findElement(By.xpath("//h5[text() = 'Chapter 8. Testing Framework Specifics']")).getText();
//        String chapter9 = driver.findElement(By.xpath("//a[text() = 'A/B Testing']/../h5[test() = 'Chapter 9. Third-Party Integrations']")).getText();





