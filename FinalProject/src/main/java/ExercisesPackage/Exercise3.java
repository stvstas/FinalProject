package ExercisesPackage;

import org.openqa.selenium.WebDriver;

import java.sql.*;
import com.sun.prism.impl.Disposer;
import org.openqa.selenium.WebDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;

/**
 * Created by vstancu on 11/24/2016.
 */
public class Exercise3 {

    private WebDriver driver;

    public Exercise3(WebDriver driver){this.driver = driver;}

    public void Database(String _name,String _mail){
        System.out.println("The test that verifies in the database that there is a new entry with a specific name and email combination:");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.100.125:3306/drupal", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT name,mail FROM users WHERE name = '"+ _name + "' and mail='" + _mail + "'");

            while (rs.next()){
                String name = rs.getString("name");
                String mail = rs.getString("mail");
                System.out.format("%s,%s\n",name,mail);

            }
            st.close();
        }
        catch(Exception e){ System.out.println(e);
        }
    }
}

