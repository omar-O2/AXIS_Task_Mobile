package Authentication;

import Utilities.Json_Data;
import Utilities.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.*;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;


public class PIN_Page_AND_Biometrics {
    public AppiumDriver driver;
    private final By Set_PIN_Button= AppiumBy.accessibilityId(Json_Data.Get_json_Data("PIN_Page_AND_Biometrics"
            ,"Set_PIN_Button"));
    private final By Number_One = AppiumBy.accessibilityId(Json_Data.Get_json_Data("PIN_Page_AND_Biometrics"
            ,"Number_One"));
    private final By Number_Two = AppiumBy.accessibilityId(Json_Data.Get_json_Data("PIN_Page_AND_Biometrics"
            ,"Number_Two"));
    private final By Number_Three = AppiumBy.accessibilityId(Json_Data.Get_json_Data("PIN_Page_AND_Biometrics"
            ,"Number_Three"));
    private final By Number_Four = AppiumBy.accessibilityId(Json_Data.Get_json_Data("PIN_Page_AND_Biometrics"
            ,"Number_Four"));
    private final By Number_Five = AppiumBy.accessibilityId(Json_Data.Get_json_Data("PIN_Page_AND_Biometrics"
            ,"Number_Five"));
    private final By Number_Six = AppiumBy.accessibilityId(Json_Data.Get_json_Data("PIN_Page_AND_Biometrics"
            ,"Number_Six"));
    private final By Number_Seven = AppiumBy.accessibilityId(Json_Data.Get_json_Data("PIN_Page_AND_Biometrics"
            ,"Number_Seven"));
    private final By Number_Eight = AppiumBy.accessibilityId(Json_Data.Get_json_Data("PIN_Page_AND_Biometrics"
            ,"Number_Eight"));
    private final By Number_Nine = AppiumBy.accessibilityId(Json_Data.Get_json_Data("PIN_Page_AND_Biometrics"
            ,"Number_Nine"));
    private final By Number_Zero= AppiumBy.accessibilityId(Json_Data.Get_json_Data("PIN_Page_AND_Biometrics"
            ,"Number_Zero"));
    private final By Enable_Biometrics_Button= By.xpath(Json_Data.Get_json_Data("PIN_Page_AND_Biometrics", "Enable_Biometrics_Button"));
    private final By Ignore_Biometrics_Button= By.xpath(Json_Data.Get_json_Data("PIN_Page_AND_Biometrics", "Ignore_Biometrics_Button"));










    public PIN_Page_AND_Biometrics(AppiumDriver driver) throws FileNotFoundException {
        this.driver= driver;
    }

    public PIN_Page_AND_Biometrics Press_Number_Zero(){
        Utility.Click_On_Element(driver, Number_Zero);
        return this;
    }
    public PIN_Page_AND_Biometrics Press_On_Set_PIN_Button(){
        Utility.Click_On_Element(driver, Set_PIN_Button);
        return this;
    }


    public PIN_Page_AND_Biometrics Press_Number_One(){
        Utility.Click_On_Element(driver, Number_One);
        return this;
    }

    public PIN_Page_AND_Biometrics Press_Number_Two(){
        Utility.Click_On_Element(driver, Number_Two);
        return this;
    }
    public PIN_Page_AND_Biometrics Press_Number_Three(){
        Utility.Click_On_Element(driver, Number_Three);
        return this;
    }
    public PIN_Page_AND_Biometrics Press_Number_Four(){
        Utility.Click_On_Element(driver, Number_Four);
        return this;
    }

    public PIN_Page_AND_Biometrics Press_Number_Five(){
        Utility.Click_On_Element(driver, Number_Five);
        return this;
    }
    public PIN_Page_AND_Biometrics Press_Number_Six(){
        Utility.Click_On_Element(driver, Number_Six);
        return this;
    }
    public PIN_Page_AND_Biometrics Press_Number_Seven(){
        Utility.Click_On_Element(driver, Number_Seven);
        return this;
    }
    public PIN_Page_AND_Biometrics Press_Number_Eight(){
        Utility.Click_On_Element(driver, Number_Eight);
        return this;
    } public PIN_Page_AND_Biometrics Press_Number_Nine(){
        Utility.Click_On_Element(driver, Number_Nine);
        return this;
    }
    public Home_Page Press_Enable_Button() throws FileNotFoundException {
        Utility.Click_On_Element(driver, Enable_Biometrics_Button);
        return new Home_Page(driver) ;
    }
    public Home_Page Press_Ignore_Button() throws FileNotFoundException {
        Utility.Click_On_Element(driver, Ignore_Biometrics_Button);
        return new Home_Page(driver);
    }





}
