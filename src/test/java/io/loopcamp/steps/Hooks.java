package io.loopcamp.steps;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import io.loopcamp.jdbctests.utility.ConfigurationReader;
import io.loopcamp.jdbctests.utility.DB_Util;
import io.loopcamp.jdbctests.utility.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

//  @Before
//    public void setUp() {
//        Driver.getDriver();
//    }
//    @After("@db")
//    public void tearDown(Scenario scenario){
//        if (scenario.isFailed()){
//            final byte []screenshot =
//                    ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot,"image/png", scenario.getName());
//        }
//        Driver.closeDriver();
//    }

    @Before("@db")
    public void setUpDB() {

        String ip = ConfigurationReader.getProperty("docuportUrl");
        String un = ConfigurationReader.getProperty("dbUserName");
        String pw = ConfigurationReader.getProperty("dbPassword");
        DB_Util.createConnection(ip,un,pw);
    }

    @After("@db")
    public void destroyDb(){
        DB_Util.destroy();
    }



}

