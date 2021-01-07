package pages;

import support.DriverQA;

public class ListaProcessos extends BasePage {

    public ListaProcessos(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void clickNovoProcesso() {
        driver.click("btn-novo");
    }

    public void clickMostrarProcesso(String id) {
        String elemento = "btn-show_" + id;
        driver.waitElementToBeClickable(elemento);
        driver.click(elemento);
    }

    public void clickEditarProcesso(String code) {
        String elemento = "btn-edit_" + code;
        driver.click(elemento);
    }

    public void clickApagarProcesso(String id) {
        String elemento = "btn-delete_" + id;
        driver.click(elemento);
    }

    public void validarProcessoApagado(String codigo) {
        String elemento = "btn-delete_" + codigo;
        driver.waitInvisibilityOfElement(elemento);
    }

}
