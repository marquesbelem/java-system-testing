package pages;

import support.DriverQA;

public class HomePage extends  BasePage {

    private String _url = "http://agapito-server.herokuapp.com";

    public  HomePage(DriverQA stepDriver)
    {
        super(stepDriver);
    }

    public void open()
    {
        driver.openURL(_url);
    }
}
