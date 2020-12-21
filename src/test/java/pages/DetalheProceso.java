package pages;

import support.DriverQA;

public class DetalheProceso extends  BasePage  {
    public  DetalheProceso(DriverQA stepDriver)
    {
        super(stepDriver);
    }

    public String getText(String id) {
        return  driver.getText(id);
    }

    public String getCode() {
        return  driver.getText("codigo");
    }

    public void clickVoltar() {
        driver.click(".ls-btn-primary-danger", "css");
    }
}
