import Authentication.OTP;
import Authentication.Registration;
import Pages.Allow_Notification_Popup;
import Utilities.Json_Data;
import Utilities.Utility;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class Registration_Test extends TestBase {
    @BeforeMethod
    public void Reach_Login() throws InterruptedException, FileNotFoundException {




        new Allow_Notification_Popup(driver).Press_Allow_Button();
        new Registration(driver).Press_Continue_Button();
        new Registration(driver).Press_Allow_Location();
        new Registration(driver).Press_Skip_Button();
        new Registration(driver).Press_Join_Button();
    }


@Test(priority = 1)
@Epic("Registration")
@TmsLink("https://omarradwanpop.atlassian.net/projects/SCRUM?selectedItem=com.atlassian.plugins.atlassian-connect-plugin%3Acom.thed.zephyr.je__main-project-page&atlOrigin=eyJpIjoiNGFhZDZhZjFhYWRjNDkwYWE2M2M3NjM0MDUyMzQ4ZGYiLCJwIjoiaiJ9#!/v2/testCase/SCRUM-T16")
@Owner("Omar")
@Description("User can register with invalid credentials")
        public void Valid_Registration_With_NationalID_P() throws FileNotFoundException, InterruptedException {
            new Registration(driver).Press_On_NationalID().Enter_NationalID(Json_Data.Get_json_Data("Registration_Cases_Data","Valid_Registration_With_NationalID_P.NationalID")).Press_On_Title_Login().Press_Continue_Button().Press_On_Mobile_Number_Field();
new Registration(driver).Enter_Mobile_Number(Json_Data.Get_json_Data("Registration_Cases_Data","Valid_Registration_With_NationalID_P.Mobile_Number")).Press_On_Title_Registration().Press_On_Join_Now_Button().Press_On_Terms_And_Conditions_Check_Box().Press_Continue_Button();
new OTP(driver).Press_On_OTP_Field().Enter_OTP();new Registration(driver).Press_Continue_Button().Press_On_Go_To_Nafath_Button().Return_To_App().Press_On_Set_PIN_Button().Press_Number_One().Press_Number_Two().Press_Number_Three().Press_Number_Four().
Press_Number_One().Press_Number_Two().Press_Number_Three().Press_Number_Four();
new Registration(driver).Press_On_Tamawal_Contract_Checkbox_1().Press_On_Tamawal_Contract_Checkbox_2().Press_Continue_Button();
   Utility.Assert(driver,AppiumBy.accessibilityId("Log in or Sign up"),false,"Yess");
        }


}

