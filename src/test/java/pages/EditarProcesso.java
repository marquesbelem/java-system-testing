package pages;

import support.DriverQA;

public class EditarProcesso extends BasePage  {
    public  EditarProcesso(DriverQA stepDriver)
    {
        super(stepDriver);
    }

    public void campoInput(String idCampo, String valor) {
        driver.sendKeys(valor, idCampo);
    }
    public void campoSelect(String idCampo, String valor) {
        driver.selectByIndex(0,idCampo);
    }

    public void campoRadio(String idCampo, int valor) {
        driver.selectByIndex(valor, idCampo);
    }

    public void clickSalvar() {
        driver.click("btn-save");
    }
}
