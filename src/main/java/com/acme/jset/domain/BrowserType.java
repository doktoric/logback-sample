package com.acme.jset.domain;

public enum BrowserType {

    OPERA("opera"),INTERNETEXPLORER("iexplorer"),FIREFOX("firefox"),CHROME("chrome");
    
    
    private String browserType;
    private BrowserType(String browserType){
        this.browserType=browserType;
    }
    public String getBrowserType() {
        return browserType;
    }
  
    
    
}
