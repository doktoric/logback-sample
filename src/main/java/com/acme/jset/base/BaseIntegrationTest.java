package com.acme.jset.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.jset.domain.ExtensionType;

public class BaseIntegrationTest {

    
    protected final Logger logger = LoggerFactory.getLogger(BaseIntegrationTest.class);

	private static final boolean TAKE_SCREENSHOT = true;
	private static final int SELENIUM_TIMEOUT_SECS = 5;
	
	private final String currentWorkDir = System.getProperty("user.dir");

	protected WebDriver driver;
    protected String baseUrl;


    public String getBaseUrl() {
		return baseUrl;
	}
    
    public WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setUp() throws Exception {
        logger.debug("dfsdfsdfsdfsdfsdfsdfsdf");
        File downloadDir = new File(currentWorkDir + File.separator + "downloads");
        if (!downloadDir.exists()) {
            downloadDir.mkdir();
        }

     
        logger.debug("dfsdfsdfsdfsdfsdfsdfsdf");
        baseUrl = "http://localhost:8080/doktorics/" ;
        logger.debug("dfsdfsdfsdfsdfsdfsdfsdf");
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(SELENIUM_TIMEOUT_SECS, TimeUnit.SECONDS);
        logger.debug("dfsdfsdfsdfsdfsdfsdfsdf");
        
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    
    /** save screenshot in the root of the current drive */
    protected void takeScreenshot(final String saveAsFilename) {
    	
    	if(TAKE_SCREENSHOT) {
	        try {
	            FileUtils.copyFile(getScreenshotFromWebDriver(), new File(getFullFilename(saveAsFilename)));
	        } catch (final IOException e) {
	            logger.error("IOException during screenshot saving. " + e.getMessage());
	        }
    	}
    }

    private File getScreenshotFromWebDriver() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }
    
    private String getFullFilename(final String saveAsFilename,ExtensionType extension) {
        final String extensionType = extension.getExtensionTypeString();
        return createFilePath(saveAsFilename, extensionType);
    }
    

    private String getFullFilename(final String saveAsFilename) {
        return getFullFilename(saveAsFilename, ExtensionType.PNG);
    }
    
    private String createFilePath(final String saveAsFilename, final String extension) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\\");
        sb.append(saveAsFilename);
        sb.append("-");
        sb.append(System.currentTimeMillis());
        sb.append(extension);
        return sb.toString();
    }
    
   
    /** convenience method to save a few keystrokes, calls getDriver().findElement(by) */
    protected WebElement findElement(By by) {
    	return getDriver().findElement(by);
    }
    
    protected List<WebElement> findElements(By by) {
    	return getDriver().findElements(by);
    }
    
    /** convenience method to look up element by id in document */
    protected String getTextForId(String id) {
    	return findElement(By.id(id)).getText();
    }

    /** convenience method to look up element by class attribute in document */
    protected String getTextForClass(String className) {
    	return findElement(By.className(className)).getText();
    }

    /** convenience method to look up element by tag name in document */
    protected String getTextForElement(String tagName) {
    	return findElement(By.tagName(tagName)).getText();
    }
    
    protected void hoverOver(WebElement element) {
    	new Actions(getDriver()).moveToElement(element).build().perform();
    }
}
