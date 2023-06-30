package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigManager {

    public static Map<String,String> filemap= new HashMap<>();
    static Properties prop = new Properties();

    public static String getConfig(String key){
        try{
            FileInputStream input= new FileInputStream("env.properties");
            prop.load(input);
            filemap.put(key,prop.getProperty(key));
        }catch (Exception e){
            e.printStackTrace();
        }

        String property= filemap.get(key);
        return property;
    }
}
