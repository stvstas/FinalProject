package ExercisesPackage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by vstancu on 11/22/2016.
 */
public class Exercise1 {

    private WebDriver driver;


    public Exercise1(WebDriver driver){
        this.driver = driver;
        this.driver.get("http://192.168.100.125/drupal-7.15/");
    }


    //username login field
    @FindBy(id = "edit-name")
    private WebElement userField;

    //password login field
    @FindBy(id = "edit-pass")
    private WebElement passField;

    // login button
    @FindBy(id="edit-submit")
    private WebElement loginButton;

    //button "Hello user" used to verify if the login was succesfull
    @FindBy(xpath = "//li[@class='account first']")
    private WebElement loginassert;


    public void LoginTest (String user, String password) {
        //login
        userField.sendKeys(user);
        passField.sendKeys(password);
        loginButton.click();
    }

    public void verifyLoginSuccesfull(String user){

        //assert with console output
        String strng = loginassert.getText();
        System.out.println(strng);
        Assert.assertEquals("Hello "+user, strng);
        System.out.println("Login was succesfull !");
    }

}
