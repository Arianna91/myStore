package utils;

//import aplication.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;


public class SourceProperties {
    public static Properties properties;
    private InputStream input;

    public SourceProperties() throws IOException {
        properties=new Properties();
        URL url=new URL("file:///"+Utils.getCurrentRelativePath()+"/resources/configuration.properties");
        input=url.openStream();
        properties.load(input);
    }

    public static String getProperty(String name){
        return properties.getProperty(name);
    }
}
