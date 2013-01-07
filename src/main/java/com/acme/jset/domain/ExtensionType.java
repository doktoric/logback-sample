package com.acme.jset.domain;

public enum ExtensionType {
    
    PNG(".png"),
    JPG(".jpg"),
    BMP(".bmp");
    
    private final String extensionTypeString;

    ExtensionType(String extensionTypeString) {
        this.extensionTypeString = extensionTypeString;
    }

    public String getExtensionTypeString() {
        return extensionTypeString;
    }
}
