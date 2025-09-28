package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Json_Data {

    private static final String Path_Json_File = "src/test/resources/Json_Data/" ;




        public static String Get_json_Data(String File_Name, String Field_Name) {
            try (FileReader reader = new FileReader(Path_Json_File + File_Name + ".json")) {
                JsonElement element = JsonParser.parseReader(reader);
                String[] keys = Field_Name.split("\\.");

                for (String key : keys) {
                    element = element.getAsJsonObject().get(key);
                    if (element == null) {
                        throw new RuntimeException("Field not found: " + Field_Name);
                    }
                }

                return element.getAsString();
            } catch (Exception e) {
                throw new RuntimeException("Error reading JSON field '" + Field_Name + "' from file: " + File_Name, e);
            }
        }

}
