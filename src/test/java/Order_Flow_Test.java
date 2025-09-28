import Authentication.Login_Flow_Page;
import Authentication.OTP;
import Order_Flow.*;
import Order_Flow.Disclosures.Disclosure_Landing;
import Order_Flow.Disclosures.Personal_Details;
import Pages.*;
import Utilities.Json_Data;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class Order_Flow_Test extends TestBase {

    @BeforeMethod
    public void Reach_Login() throws InterruptedException, FileNotFoundException {

        new Allow_Notification_Popup(driver).Press_Allow_Button();
        new Login_Flow_Page(driver).Press_Continue_Button();
        new Login_Flow_Page(driver).Press_Allow_Location();
        new Login_Flow_Page(driver).Press_Skip_Button();
        new Login_Flow_Page(driver).Press_Join_Button();
        new Login_Flow_Page(driver).Press_On_NationalID().Enter_NationalID(Json_Data.Get_json_Data("Login", "NationalIDText")).Press_On_Title().Press_Continue_Button().Press_Number_One().
                Press_Number_Two().Press_Number_Three().Press_Number_Four();

    }
    @Test //TODO: When user is logged in to app for first time after registration
    public void Valid_Order_Flow() throws FileNotFoundException, InterruptedException {
        new Walkthrough(driver).Press_Start_Discovery_Button().Press_On_Salary_Field().Enter_Salary("20000").Press_No_Button().Press_On_Select_Loan_Purpose().Choose_Loan_Purpose().Scroll_To_Tamawal_Button().Press_Preferred_Amount_Field()
                .Enter_Preferred_Amount("367104").Choose_Loan_Period();
        new Product_Details(driver).Press_On_Tamawal_Button(); new Products_List(driver).Press_On_Close_Compare_Tour_Guide_Icon(); new Home_Page(driver).Press_On_Details_Button(); new Product_Details(driver).Press_On_Tamawal_Button();
        new Personal_Details(driver).Click_On_Section_Personal_Details().Click_On_Social_Status_DDL().Choose_Single_In_Social_Status_DDL().Click_On_Number_1_in_DDLs().Click_On_Number_1_in_DDLs().Click_On_Amount_Entry_Field().Enter_Education_Amount().Press_On_Title_Of_Amount_Entry_Field().Press_On_Ok_Button_In_Amount_Entry_Field()
                .Choose_Bank_Albilad().Press_On_Yes_Button().Press_On_Yes_Button().Press_On_Yes_Button().Press_On_Yes_Button().Press_On_Yes_Button().Choose_Abha_City().Choose_Option_In_Education_Level_DDL().Choose_Option_In_Source_Of_Income_DDL().Choose_Option_In_Net_Worth_Category_DDL()
                .Choose_Option_In_Current_Job_Professions_DDL().Press_On_Confirm_And_Next_Button();
        new Disclosure_Landing(driver).Press_On_Confirm_Data_Provided_Is_Accurate().Press_On_TAMAWAL_Button();

        new Personal_Details(driver).Press_Ok_Confirm_Button();
        new Checkout(driver).Press_On_Confirmation_Checkbox().Press_On_Pay_Now_Button().Press_Pay_With_Credit();
        new Payment(driver).Press_On_Name_On_Card_Field().Enter_Name_On_Card("Omar Radwan").Enter_Card_Number("4111111111111111").Press_On_Month_Of_Card().Enter_Month_Of_Card("0828").Press_On_CVV_Of_Card().Enter_CVV_Of_Card("123").Press_On_Pay_SAR_20_Button().Press_On_Submit_Button();

        new Accurate_Results(driver).Press_On_TAMAWAL_In_Accurate();
        new OTP(driver).Press_On_OTP_Field().Enter_OTP();
        new Accurate_Results(driver).Press_Track_Order_Button();

        Utility.Assert(driver, By.xpath("//android.view.View[@content-desc=\"Tracking\"]"),false,"Yess");

    }
}
