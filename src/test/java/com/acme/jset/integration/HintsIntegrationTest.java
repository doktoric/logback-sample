package com.acme.jset.integration;

import org.junit.Test;
import org.openqa.selenium.By;

import com.acme.jset.base.BaseIntegrationTest;

/**
 * Tests the display of hints on questionarie answers
 */
public class HintsIntegrationTest extends BaseIntegrationTest {

   
    
    @Test
    public void checkHintHiddenByDefault() throws Exception {
     
        findElement(By.id("submitButton")).click();
        tearDown();
        logger.info("end");
    }

    

}
