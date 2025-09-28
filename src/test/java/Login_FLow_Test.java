import Authentication.OTP;
import Authentication.PIN_Page_AND_Biometrics;
import Pages.*;
import Authentication.Login_Flow_Page;
import Utilities.Json_Data;
import Utilities.Utility;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.FileNotFoundException;

public class Login_FLow_Test extends TestBase {


    @BeforeMethod
    public void Reach_Login() throws InterruptedException, FileNotFoundException {

        new Allow_Notification_Popup(driver).Press_Allow_Button();
        new Login_Flow_Page(driver).Press_Continue_Button();
        new Login_Flow_Page(driver).Press_Allow_Location();
        new Login_Flow_Page(driver).Press_Skip_Button();
        new Login_Flow_Page(driver).Press_Join_Button();


    }


    @Test(priority = 1)
    @Epic("Login")
    @TmsLink("https://team-1591718611727.atlassian.net/jira/software/c/projects/TM/boards/33")
    @Owner("Mahmoud")
    @Description("Valid Login")
    public void Valid_Login_With_NationalID() throws InterruptedException, FileNotFoundException {
        new Login_Flow_Page(driver).Press_On_NationalID().Enter_NationalID(Json_Data.Get_json_Data("Login", "NationalIDText")).Press_On_Title().Press_Continue_Button().Press_Number_One().Press_Number_Two()
                .Press_Number_Three().Press_Number_Four();
        Utility.Assert(driver, By.xpath("//android.widget.ScrollView/android.view.View[1]/android.widget.ImageView[1]"),false,"Yess");


    }


    @Test(priority = 3)
    public void Enter_Valid_NationalID() throws InterruptedException, FileNotFoundException {
        new Login_Flow_Page(driver).Press_On_NationalID().Enter_NationalID("1005530090").Press_On_Title().Press_Continue_Button();
        Utility.Assert(driver, By.xpath("//android.view.View[@content-desc=\"Enter your PIN\"]"),false,"Yess");


    }


    @Test(priority = 4)
    public void Valid_Login_With_NationalID_New_Phone() throws InterruptedException, FileNotFoundException {
        new Login_Flow_Page(driver).Press_On_NationalID().Enter_NationalID(Json_Data.Get_json_Data("Login", "NationalIDText")).Press_On_Title().Press_Continue_Button();
        new OTP(driver).Press_On_OTP_Field().Enter_OTP();
        new PIN_Page_AND_Biometrics(driver).Press_Number_One().Press_Number_Two().Press_Number_Three().Press_Number_Four().Press_Ignore_Button();
        Utility.Assert(driver,By.xpath("//android.widget.ScrollView/android.view.View[1]/android.widget.ImageView[2]"),false,"Yess");


    }

    @Test(priority = 2)
    public void Enter_Invalid_NationalID() throws InterruptedException, FileNotFoundException {
        new Login_Flow_Page(driver).Press_On_NationalID().Enter_NationalID("1005560090").Press_On_Title().Press_Continue_Button();
        Utility.Assert(driver,By.xpath("//android.view.View[@content-desc=\"Invalid ID\"]"),false,"Yess");


    }

    /*@AfterMethod
    public void resetApp() {
        try {
            // Clean app state without quitting driver
            ((AndroidDriver) driver).terminateApp("sa.tamawal.capp");
            ((AndroidDriver) driver).activateApp("sa.tamawal.capp");
            Thread.sleep(1000); // Small delay for app to stabilize
        } catch (Exception e) {
            System.err.println("Error resetting app: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}

    









