package ExercisesPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by vstancu on 11/22/2016.
 */
public class Exercise2 {
    private WebDriver driver;

    public Exercise2(WebDriver driver){
        this.driver = driver;}

    public Exercise2() {
    }

    //region Locators
    //press People Button
    @FindBy(xpath = "//li//a[@id='toolbar-link-admin-people']")
    private WebElement peopleButton;

    //add user Button
    @FindBy(xpath = "//div[@id='overlay']//ul[@class='action-links']//a")
    //@FindBy(xpath = "input[@id='edit-name']")
    private WebElement addUserButton;

    // username Field
    @FindBy(xpath = "//div[@class='clearfix']//div[@class='form-item form-type-textfield form-item-name']//input[@ class='username form-text required']")
    private WebElement newUserField;

    //email Field
    @FindBy(xpath = "//input[@id='edit-mail']")
    private WebElement newEmailField;

    //password Field
    @FindBy(xpath ="//input[@id='edit-pass-pass1']")
    private WebElement newPassField;

    //password confirmation Field
    @FindBy(xpath ="//input[@id='edit-pass-pass2']")
    private WebElement confPassField;

    //admin role check
    @FindBy(xpath = "//input[@id='edit-roles-3']")
    private WebElement checkBox;

    //create new account button
    @FindBy(xpath = "//input[@id='edit-submit']")
    private WebElement createButton;

    //People button from the navigation
    @FindBy(xpath = "//div[@class='breadcrumb']//a[3]")
    private WebElement people2Button;

    //Log Out Button
    @FindBy(xpath = "//div//ul[@id='toolbar-user']//li[@class='logout last']//a")
    private WebElement adminlogoutButton;

    @FindBy(xpath = "//div[@id='header']//ul[@class='links inline secondary-menu']//li[@class='menu-15 last']//a")
    private WebElement slogoutButton;

    //My account Button
    @FindBy(xpath = ".//*[@id='header']/ul[2]/li[1]/a")
    private WebElement myAccoutButton;

    //My accout /Edit Button
    @FindBy(xpath = "//div[@id='tabs-wrapper']//ul[@class='tabs primary']//li//a[contains(.,'Edit')]")
    private WebElement editButton;

    @FindBy(xpath="//div[@class='toolbar-menu clearfix']//ul[@id='toolbar-home']//li[@class='home first last']//a//span")
    private WebElement HomeButton;
    //endregion

    public void goToCreateUser() {
        peopleButton.click();
        driver.switchTo().frame (driver.findElement(By.xpath("//div[@id='overlay-container']/iframe[@title='People dialog']")));
        addUserButton.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.className("overlay-element")));}

    public void CreateUser(String newuser, String newemail,String newPass,String confPass,boolean roles){
        newUserField.sendKeys(newuser);
        newEmailField.sendKeys(newemail);
        newPassField.sendKeys(newPass);
        confPassField.sendKeys(confPass);
        if (roles==true)
            checkBox.click();;
        createButton.click();
        driver.switchTo().defaultContent();
        adminlogoutButton.click();
    }

    public void verifyAdminRoleOfUser() {
        myAccoutButton.click();
        editButton.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame (driver.findElement(By.xpath("//div[@id='overlay-container']/iframe[@class[contains(.,'overlay-active')]]")));
        List<WebElement> linkSearch = driver.findElements(By.xpath("//div[@class [contains(.,'form-item-roles-3')]]//label"));
        int checkLink = linkSearch.size();
        System.out.println("Verify if the user is an administrator:");
        if (checkLink != 0) {
            System.out.println("The user valentinaadmin is an administrator !");
        } else
            System.out.println("The user valentinaadmin is not an administrator !");
        driver.switchTo().defaultContent();
        adminlogoutButton.click();
    }

    public void verifyRoleUser(){

        myAccoutButton.click();
        editButton.click();
        List<WebElement> linkSearch=driver.findElements(By.xpath("/div[@class [contains(.,'form-item-roles-3')]]//label"));
        int checkLink=linkSearch.size();
                if(checkLink!=0){
            System.out.println("The user valentina is an administrator !");
        }
        else
            System.out.println("The user valentina is not an administrator !");
        slogoutButton.click();
    }
}
