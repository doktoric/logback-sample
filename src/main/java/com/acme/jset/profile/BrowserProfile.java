package com.acme.jset.profile;

import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserProfile extends FirefoxProfile{
//    private String downloadPath = "\\files\\down\\";

    public BrowserProfile() {
        super();
//        File file = new File("");
//
//        this.setPreference("browser.download.folderList", 2);
//        this.setPreference("browser.download.manager.showWhenStarting", false);
//        this.setPreference("browser.download.dir", file.getAbsoluteFile() + downloadPath);
//        this.setPreference("browser.helperApps.neverAsk.saveToDisk",
//                "text/html,text/x-csv,application/x-download,application/vnd.ms-excel,application/pdf");
    }
}
