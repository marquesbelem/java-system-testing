package pages;

import support.DriverQA;

public class ListaProcessos  extends  BasePage {

    public  ListaProcessos(DriverQA stepDriver)
    {
        super(stepDriver);
    }

    public void clickNovoProcesso() {
        driver.click("btn-novo");
    }

    public void clickEditarProcesso(String code) {
        String elemento = "btn-edit_" + code;
        driver.click(elemento);
    }
}
