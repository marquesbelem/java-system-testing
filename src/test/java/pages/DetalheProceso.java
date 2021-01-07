package pages;

import support.DriverQA;

public class DetalheProceso extends  BasePage  {
    public  DetalheProceso(DriverQA stepDriver)
    {
        super(stepDriver);
    }

    public String getText(String id) {
        return driver.getText(id);
    }

    public String getCode() {
        return driver.getText("codigo");
    }

    public void clickVoltar() {
        driver.click(".ls-btn-primary-danger", "css");
    }

    public String getVara() {
        return driver.getText("vara");
    }

    public String getNumeroProcesso() {
        return driver.getText("numero");
    }

    public String getNatureza() {
        return driver.getText("natureza");
    }

    public String getPartes() {
        return driver.getText("partes");
    }
}
