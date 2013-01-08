package com.acme.jset.integration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.jset.base.BaseIntegrationTest;

/**
 * Tests the display of hints on questionarie answers
 */
public class HintsIntegrationTest extends BaseIntegrationTest {

    protected final Logger logger = LoggerFactory.getLogger(HintsIntegrationTest.class);

    
    @Test
    public void checkHintHiddenByDefault() throws Exception {
        logger.error("dsfsdfdsfsdfsdfsdfsdfsdfsdfsd");
        findElement(By.id("submitButton")).click();
        tearDown();
        logger.info("end");
    }

    

}
