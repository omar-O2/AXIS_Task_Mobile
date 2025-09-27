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
       /* new Walkthrough(driver).Press_Start_Discovery_Button();
        new Walkthrough(driver).Press_On_Salary_Field();
        new Walkthrough(driver).Enter_Salary("20000");
        new Walkthrough(driver).Press_No_Button();
        new Walkthrough(driver).Press_On_Select_Loan_Purpose();
        new Walkthrough(driver).Choose_Loan_Purpose();
        new Walkthrough(driver).Scroll_To_Tamawal_Button();
        new Walkthrough(driver).Press_Preferred_Amount_Field();
        new Walkthrough(driver).Enter_Preferred_Amount("367104");
      new Walkthrough(driver).Choose_Loan_Period();
        new Product_Details(driver).Press_On_Tamawal_Button();
        new Products_List(driver).Press_On_Close_Compare_Tour_Guide_Icon();
       */new Home_Page(driver).Press_On_Details_Button();
        new Product_Details(driver).Press_On_Tamawal_Button();
        new Personal_Details(driver).Click_On_Section_Personal_Details();
        new Personal_Details(driver).Click_On_Social_Status_DDL();
        new Personal_Details(driver).Choose_Single_In_Social_Status_DDL();
        new Personal_Details(driver).Click_On_Number_1_in_DDLs();
        new Personal_Details(driver).Click_On_Number_1_in_DDLs();

        new Personal_Details(driver).Click_On_Amount_Entry_Field().Enter_Education_Amount().Press_On_Title_Of_Amount_Entry_Field().Press_On_Ok_Button_In_Amount_Entry_Field();
        new Personal_Details(driver).Choose_Bank_Albilad();
        new Personal_Details(driver).Press_On_Yes_Button();
        new Personal_Details(driver).Press_On_Yes_Button();
        new Personal_Details(driver).Press_On_Yes_Button();
        new Personal_Details(driver).Press_On_Yes_Button();
        new Personal_Details(driver).Press_On_Yes_Button();
        new Personal_Details(driver).Choose_Abha_City();
        new Personal_Details(driver).Choose_Option_In_Education_Level_DDL();
        new Personal_Details(driver).Choose_Option_In_Source_Of_Income_DDL();
        new Personal_Details(driver).Choose_Option_In_Net_Worth_Category_DDL();
        new Personal_Details(driver).Choose_Option_In_Current_Job_Professions_DDL();
        new Personal_Details(driver).Press_On_Confirm_And_Next_Button();
        new Disclosure_Landing(driver).Press_On_Confirm_Data_Provided_Is_Accurate().Press_On_TAMAWAL_Button();



        new Personal_Details(driver).Press_Ok_Confirm_Button();
        new Checkout(driver).Press_On_Confirmation_Checkbox();
        new Checkout(driver).Press_On_Pay_Now_Button().Press_Pay_With_Credit();
        new Payment(driver).Press_On_Name_On_Card_Field();
        new Payment(driver).Enter_Name_On_Card("Omar Radwan");
        new Payment(driver).Press_On_Card_Number_Field();
        new Payment(driver).Enter_Card_Number("4111111111111111");
        new Payment(driver).Press_On_Month_Of_Card();
        new Payment(driver).Enter_Month_Of_Card("0828");
        new Payment(driver).Press_On_CVV_Of_Card();
        new Payment(driver).Enter_CVV_Of_Card("123");
        new Payment(driver).Press_On_Pay_SAR_20_Button();
        new Payment(driver).Press_On_Submit_Button();
        new Accurate_Results(driver).Press_On_TAMAWAL_In_Accurate();
        new OTP(driver).Press_On_OTP_Field();
        new OTP(driver).Enter_OTP();
        new Accurate_Results(driver).Press_Track_Order_Button();

        Utility.Assert(driver, By.xpath("//android.view.View[@content-desc=\"Tracking\"]"),false,"Yess");

    }
}
