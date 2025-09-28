package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Json_Data {

    private static final String Path_Json_File = "src/test/resources/Json_Data/" ;




    /*public static String Get_json_Data(String File_Name, String Field_Name) throws FileNotFoundException {
        FileReader reader = new FileReader(Path_Json_File+File_Name+".json");
        JsonElement jsonElement = JsonParser.parseReader(reader);
        return jsonElement.getAsJsonObject().get(Field_Name).getAsString();
    }*/
   /*public static String Get_json_Data(String File_Name, String Field_Path) throws FileNotFoundException {
       FileReader reader = new FileReader(Path_Json_File + File_Name + ".json");
       JsonElement jsonElement = JsonParser.parseReader(reader);
       JsonObject currentObj = jsonElement.getAsJsonObject();

       // Split path (e.g., "User1.NationalID1" → ["User1", "NationalID1"])
       String[] pathParts = Field_Path.split("\\.");

       // Traverse nested objects
       for (int i = 0; i < pathParts.length - 1; i++) {
           currentObj = currentObj.getAsJsonObject(pathParts[i]);
           if (currentObj == null) {
               throw new RuntimeException("Path not found: " + Field_Path);
           }
       }

       // Get the final field value
       JsonElement fieldValue = currentObj.get(pathParts[pathParts.length - 1]);
       if (fieldValue == null || fieldValue.isJsonNull()) {
           throw new RuntimeException("Field not found: " + Field_Path);
       }
       return fieldValue.getAsString();
   }*/


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
