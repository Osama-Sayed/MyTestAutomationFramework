package fileReaders;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class JSONDataReader {
    public String firstName,lastName,email,password;
    public void JsonReader() throws Exception{
        String filePath = System.getProperty("user.dir")+"/src/test/java/data/userData.json";
        File srcFile = new File(filePath);
        JSONParser parser = new JSONParser();
        JSONArray Jarray = (JSONArray) parser.parse(new FileReader(srcFile));
        for(Object jsonObj: Jarray){
            JSONObject person = (JSONObject) jsonObj;
            firstName = (String) person.get("firstName");
            System.out.println(firstName);
            lastName = (String) person.get("lastName");
            System.out.println(lastName);
            email = (String) person.get("Email");
            System.out.println(email);
            password = (String) person.get("password");
            System.out.println(password);
        }
    }
}
