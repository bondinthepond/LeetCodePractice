package AutomationPractice.Selenium.DriverFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rohit on 1/02/18.
 */
public class DriverFactory {

    protected static WebDriver driver;
    protected static Actions actions;
    protected static WebDriverWait wait;
    protected static String test_environment;
    protected static String device_Type;
    protected static String deviceName;

    private final static Logger LOGGER = Logger.getLogger(DriverFactory.class.getName());

    public DriverFactory() {
        initialize();
    }

    public void initialize() {
        if (driver == null)
            createNewDriverInstance();
    }

    private void createNewDriverInstance() {

        LOGGER.setLevel(Level.INFO);

        test_environment = System.getProperty("environment", "Production_Codes");
        String cucumber_tags = System.getProperty("cucumber.tags", " ");
        device_Type = System.getProperty("device_Type","Mobile");
        deviceName=System.getProperty("device", "Pixel 2");
        String device = System.getProperty("device"," ");
        String os_version = System.getProperty("os_version", " ");
        String mobile_os_version = System.getProperty("mobile_os_version", " ");
        String browser = System.getProperty("browser", "Chrome");
        String browser_version = System.getProperty("browser_version", " ");
        String jenkins= System.getProperty("jenkins","false");
        String host = System.getProperty("host","localhost");

        LOGGER.log(Level.INFO, "Running Test for Browser : " + browser + " Browser_Version : " + browser_version +
                " on Device : " + device + " os_version : " + os_version + " on host :" + host);

        initiateDriverGivenAllDetails(host, browser, browser_version, device_Type, device, os_version, mobile_os_version, jenkins, cucumber_tags);

        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    private void initiateDriverGivenAllDetails(String host, String browser, String browser_version, String device_type,
                                               String device, String os_version, String mobile_os_version, String jenkins, String cucumber_tags) {
        switch (host) {
            case "localhost":
            case "127.0.0.1":
            case "0.0.0.0":
                initiateDriverGivenBrowser(browser, jenkins);
                break;
//            case "WindowsVM":
//                initiateWebDriverForQAWindowsVM(browser);
//                break;
            case "BrowserStack":
//                initiateWebdriverForBrowserStack(browser, browser_version, device_type, device, os_version, mobile_os_version, cucumber_tags);
                LOGGER.log(Level.INFO,"Browserstack method blocked temporarily");
                break;
            default:
//                initiateWebDriverForGivenRemoteHostAndBrowser(host, browser);
                break;
        }
    }

    public void initiateDriverGivenBrowser(String browser, String jenkins){

        ChromeOptions options = new ChromeOptions();

        switch (browser) {
            case "Chrome":

                if (jenkins.equals("true")) {
                    options = getChromeOptionsRequiredForJenkins(options);
                    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
                } else {
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
                    options.addArguments("--kiosk");
                    if(device_Type.equals(("Mobile"))){
                        Map<String, String> mobileEmulation = new HashMap<String, String>();
                        mobileEmulation.put("deviceName", deviceName);//iPhone X
                        options.setExperimentalOption("mobileEmulation", mobileEmulation);
                    }
                }
                driver = new ChromeDriver(options);
                break;
            case "Safari":
                System.setProperty("webdriver.safari.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/selenium-safari-driver-3.141.59.jar");
                driver = new SafariDriver();
                break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
        }
    }

//    private void initiateWebDriverForQAWindowsVM(String browser) {
//
//        LOGGER.log(Level.INFO, "Executing initiateWebDriverForQAWindowsVM method");
//
//        String windows_host = "10.30.17.90";
//        String url = "http://" + windows_host + ":4444/wd/hub";
//        LOGGER.log(Level.INFO, "Running tests on host " + url);
//
//        ChromeDriver driver = null;
//        DesiredCapabilities capabilities = null;
//
//        switch (browser) {
//            case "Chrome":
//                capabilities = DesiredCapabilities.chrome();
//                break;
//            case "IE":
//                capabilities = DesiredCapabilities.internetExplorer();
//                break;
//            case "Edge":
//                capabilities = DesiredCapabilities.edge();
//                break;
//            case "Firefox":
//                capabilities = DesiredCapabilities.firefox();
//                capabilities.setCapability("marionette",true);
//                capabilities.setCapability("firefox_binary", "C:\\Program Files\\Mozilla Firefox\firefox.exe");
////                FirefoxOptions options = new FirefoxOptions();
////                options.setBinary("C:\\Program Files\\Mozilla Firefox\firefox.exe");
////
////                try {
////                    driver = new RemoteWebDriver(new URL(url), options);
////                } catch (MalformedURLException e) {
////                    e.printStackTrace();
////                }
////                break;
//        }
//
//        LOGGER.log(Level.INFO, "url of remote host where tests are being run : " + url);
//        try {
//            driver = new RemoteWebDriver(new URL(url), capabilities);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }

  //Please ignore this method for now - after appropriate access are provided, and browser stack credentials are provided,this method can be used.
//    public void initiateWebdriverForBrowserStack(String browser, String browser_version, String device_type,
//                                                 String device, String os_version, String mobile_os_version, String cucumber_tags){
//
//        LOGGER.log(Level.INFO, "Executing initiateWebdriverForBrowserStack method");
//
//        //browserstack credentials here - will add the line once the consultants are given the appropriate accesses
//        DesiredCapabilities caps = new DesiredCapabilities();
//
//        if (device_type.equals("Desktop")) {
//            caps.setCapability("browser", browser);
//            caps.setCapability("browser_version", browser_version);
//            caps.setCapability("os", device);
//            caps.setCapability("os_version", os_version);
//            caps.setCapability("name", "Cucumber Test for cucumber tags : " + cucumber_tags +
//                    " for Environment : " + test_environment);
//            LOGGER.log(Level.INFO, "cucumber tags : " + cucumber_tags + " browser : " + browser +
//                    " browser_version : " + browser_version + " os : " + device + " os_version : ", os_version +
//                    " for Environment : " + test_environment);
//        } else if (device_type.equals("Mobile")){
//            //the below mapping might be confusing but this is what browserstack follows
//            caps.setCapability("browserName", device);
//            caps.setCapability("device", os_version);
//            caps.setCapability("realMobile", "true");
//            caps.setCapability("os_version", mobile_os_version);
//            caps.setCapability("name", "Cucumber Test for cucumber tags : " + cucumber_tags +
//                    " for Environment : " + test_environment);
//            LOGGER.log(Level.INFO, "cucumber tags : " + cucumber_tags + " browserName : " + device + " device : " +
//                    os_version + " os_version " + mobile_os_version + " for Environment : " + test_environment);
//        } else {
//            LOGGER.log(Level.INFO, "Invalid Device_Type");
//        }
//
//        try {
//            driver = new RemoteWebDriver(new URL(url), caps);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }

//    public void initiateWebDriverForGivenRemoteHostAndBrowser(String host, String browser){
//
//        LOGGER.log(Level.INFO, "Executing initiateWebDriverForGivenRemoteHostAndBrowser method");
//
//        String url = "http://" + host + ":4444/wd/hub";
//        DesiredCapabilities capability = null;
//        switch (browser) {
//            case "Safari":
//                capability = DesiredCapabilities.safari();
//                break;
//            case "Chrome":
//                capability = DesiredCapabilities.chrome();
//                break;
//            case "IE":
//                capability = DesiredCapabilities.internetExplorer();
//                break;
//            case "Edge":
//                capability = DesiredCapabilities.edge();
//                break;
//            case "Firefox":
//                capability = DesiredCapabilities.firefox();
//                break;
//        }
//
//        LOGGER.log(Level.INFO, "url of remote host where tests are being run : " + url);
//        try {
//            driver = new RemoteWebDriver(new URL(url), capability);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }

    public ChromeOptions getChromeOptionsRequiredForJenkins(ChromeOptions options){
        options.addArguments("-headless");
        options.addArguments("--no-sandbox"); //needed to run in headless mode
        options.addArguments("--kiosk");
        options.addArguments("--disable-dev-shm-usage"); //this is required for docker
        //docker runs a container with a /dev/shm shared memory which could be small  for chrome
        return options;
    }

    public String getEnvSpecificURL(){
        String url = null;

        switch (test_environment) {
            case "Staging":
                url = "https://couponsqtstage.pdn.coupons.com/coupon-codes/";
                break;
            case "QA":
                url = "https://couponsqtstage2.pdn.coupons.com/coupon-codes/";
                break;
            case "Rewrite-Staging":
                url = "https://codes-staging.pdn.coupons.com/coupon-codes/";
                break;
            case "Rewrite-QA":
                url = "https://codes-qa.pdn.coupons.com/coupon-codes/";
                break;
            case "Production_Codes":
                url = "https://www.coupons.com/coupon-codes/";
                break;
            case "Production":
                url = "https://www.coupons.com/";
                break;
        }
        return url;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void destroyDriver() {
        driver.quit();
        driver = null;
    }
}
