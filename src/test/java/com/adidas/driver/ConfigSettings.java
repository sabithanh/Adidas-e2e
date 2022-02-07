package net.adidas.driver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigSettings {

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        ConfigSettings.driver = driver;
    }

    public static String getWebBrowser() {
        return webBrowser;
    }

    public static void setWebBrowser(String webBrowser) {
        ConfigSettings.webBrowser = webBrowser;
    }

    private static String driver;
    private static String webBrowser;

    public void getConfigSettings() throws IOException {

        Properties property = new Properties();
        String propFileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        property.load(inputStream);

        setWebBrowser(property.getProperty("webBrowser"));
        setDriver(property.getProperty("driver"));

        System.out.println(String.format("WebBrowser: %s", getWebBrowser()));

    }
}
