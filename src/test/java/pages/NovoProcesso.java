package pages;

import support.DriverQA;

public class NovoProcesso  extends  BasePage  {
    public  NovoProcesso(DriverQA stepDriver)
    {
        super(stepDriver);
    }
    private  String processoCode;

    public void campoInput(String idCampo, String valor) {
        driver.sendKeys(valor, idCampo);
    }

    public void clickSalvar() {
        driver.click("#btn-save", "css");
    }

    public void campoSelect(String idCampo, String valor) {
        if (valor.equals("Não")) {
            driver.selectByIndex(0, idCampo);
        } else {
            driver.selectByIndex(1, idCampo);
        }

    }

    public void campoRadio(String idCampo, String valor) {
        if (valor.equals("Sim")) {
            driver.sendKeys(valor, idCampo + "_s");
        } else {
            driver.sendKeys(valor, idCampo + "_n");
        }
    }

    public void setCode(String code) {
        processoCode = code;
    }

    public String getCode() {
       return processoCode;
    }
}
