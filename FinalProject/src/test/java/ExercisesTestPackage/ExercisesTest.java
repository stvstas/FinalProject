package ExercisesTestPackage;

import ExercisesPackage.Exercise1;
import ExercisesPackage.Exercise2;
import ExercisesPackage.Exercise3;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by vstancu on 11/22/2016.
 */
public class ExercisesTest  {
    private WebDriver driver;
    private Exercise1 exercise1;
    private Exercise2 exercise2;
    private Exercise3 exercise3;


    @Before
    public void before(){

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        exercise1 = PageFactory.initElements(driver, Exercise1.class);
        exercise2 = PageFactory.initElements(driver, Exercise2.class);
        exercise3 = PageFactory.initElements(driver, Exercise3.class);

    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void TestFinalProject() {

        exercise1.LoginTest("admin","admin_pass");
        exercise1.verifyLoginSuccesfull("admin");
        exercise2.goToCreateUser();
        exercise2.CreateUser("valentina" , "test.test@test.com" , "Pass123" , "Pass123",false);
        exercise1.LoginTest("admin","admin_pass");
        exercise2.goToCreateUser();
        exercise2.CreateUser("valentinaadmin" , "testa.testa@testa.com" , "Passadmin123" , "Passadmin123",true);
        exercise1.LoginTest("valentinaadmin" , "Passadmin123");
        exercise2.verifyAdminRoleOfUser();
        exercise1.LoginTest("valentina" , "Pass123");
        exercise2.verifyRoleUser();
        exercise3.Database("valentina","test.test@test.com");

    }
}
