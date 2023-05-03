package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

    Properties pro;

    public ConfigDataProvider() {

        File file = new File("./Config/config.properties");
        try {
            FileInputStream fis = new FileInputStream(file);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Not able to load config file" + e.getMessage());
        }
    }

    public String getDataFromConfig(String keyToSearch) {
        return pro.getProperty(keyToSearch);

    }

    public String getBrowserFromConfig() {

        return pro.getProperty("Browser");
    }

    public String getStagingUrl() {

        return pro.getProperty("DMPURL");
    }
}
