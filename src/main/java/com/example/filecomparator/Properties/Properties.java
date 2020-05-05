package com.example.filecomparator.Properties;

public class Properties {
    private static Properties ourInstance = new Properties();

    private Boolean ignoreName =true;
    private String comparingFolder;

    public static Properties getInstance() {
        return ourInstance;
    }

    private Properties() {
    }

    public Boolean ignoreName() {
        return ignoreName;
    }

    public void setIgnoreName(Boolean ignoreName) {
        this.ignoreName = ignoreName;
    }

    public String comparingFolder() {
        return comparingFolder;
    }

    public void setComparingFolder(String comparingFolder) {
        this.comparingFolder = comparingFolder;
    }
}
