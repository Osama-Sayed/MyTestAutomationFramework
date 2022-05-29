package fileReaders;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadProperties {
    public static Properties userData = loadProperties(System.getProperty("user.dir")+"\\src\\main\\properties\\userdata.properties");


    //Load Sauce Labs account data
    public static Properties sauceLabsData = loadProperties(System.getProperty("user.dir")+"\\src\\main\\properties\\sauceLabsUser.properties");
    private static Properties loadProperties(String path){
        Properties pro = new Properties();
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
        }catch (Exception e){
            System.out.println("Error : "+e.getMessage());
        }

        return pro;
    }
}
