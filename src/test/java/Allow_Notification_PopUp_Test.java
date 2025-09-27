import Pages.Allow_Notification_Popup;
import org.testng.annotations.Test;

public class Allow_Notification_PopUp_Test extends TestBase {
//Allow_Notification_Popup Allow_Notification;


    /*@Test
    public void Notification_Is_Allowed() {
        Allow_Notification = new Allow_Notification_Popup(driver);
Allow_Notification.Press_Allow_Button();

    }*/
    @Test
    public void Notification_Is_Not_Allowed() {
       // Allow_Notification = new Allow_Notification_Popup(driver);
        new Allow_Notification_Popup(driver).Press_Do_Not_Allow_Button();
}
}