package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import jdk.jfr.internal.PlatformRecording;
import org.junit.Assert;
import pages.*;
import support.BaseSteps;

public class ProcessosSteps extends BaseSteps {

    private HomePage homePage = new HomePage(driver);
    private MenuLateral menuLateral = new MenuLateral(driver);
    private ListaProcessos listaProcessos = new ListaProcessos(driver);
    private NovoProcesso novoProcesso = new NovoProcesso(driver);
    private DetalheProceso detalheProcesso = new DetalheProceso(driver);
    private EditarProcesso editarProcesso = new EditarProcesso(driver);

    @Dado("^que o usuario esta na pagina inicial$")
    public void queOUsuarioEstáNaPáginaInicial()
    {
        homePage.open();
    }

    @E("^que o usuario clica no menu processos$")
    public void queOUsuarioClicaNoMenuProcessos()
    {
        menuLateral.clickProcessos();
    }

    @E("^o usuario clica no botao Novo Processo$")
    public void oUsuarioClicaNoBotãoNovoProcesso()
    {
        listaProcessos.clickNovoProcesso();
    }

    @Quando("^o usuario clicar no botao de salvar$")
    public void oUsuarioClicarNoBotaoDeSalvar()
    {
        novoProcesso.clickSalvar();
        novoProcesso.setCode(detalheProcesso.getCode());
    }

    @Então("^o usuario deveria ver a mensagem \"([^\"]*)\"$")
    public void oUsuarioDeveriaVerAMensagem(String message) throws Throwable
    {
        Assert.assertEquals(message, detalheProcesso.getText("notice"));
    }

    @E("^o usuario informar \"([^\"]*)\" com o valor igual a \"([^\"]*)\"$")
    public void oUsuarioInformarComOValorIgualA(String campo, String valor) throws Throwable {
        novoProcesso.campoInput(campo,valor);
    }

    @E("^o usuario clicar no botão voltar$")
    public void oUsuarioClicarNoBotãoVoltar() {
        detalheProcesso.clickVoltar();
    }

    @E("^o usuario clica no botao editar do processo cadastrado$")
    public void oUsuarioClicaNoBotaoEditarDoProcessoCadastrado() {
        listaProcessos.clickEditarProcesso(novoProcesso.getCode());
    }

    @E("^o usuario informar \"([^\"]*)\" com o valor igual a \"([^\"]*)\" na tela de edicao$")
    public void oUsuarioInformarComOValorIgualANaTelaDeEdicao(String campo, String valor) throws Throwable {
        editarProcesso.campoInput(campo, valor);
    }

    @Quando("^o usuario clicar no botao de salvar na tela de edicao$")
    public void oUsuarioClicarNoBotaoDeSalvarNaTelaDeEdicao() {
        editarProcesso.clickSalvar();
    }

    @Então("^o usuario deveria ver o valor \"([^\"]*)\" no campo \"([^\"]*)\"$")
    public void oUsuarioDeveriaVerOValorNoCampo(String valor, String campo) throws Throwable {
       Assert.assertEquals(valor, detalheProcesso.getText(campo));
    }

    @E("^o usuario selecionar \"([^\"]*)\" com o valor igual a \"([^\"]*)\"$")
    public void oUsuarioSelecionarComOValorIgualA(String campo, String valor) throws Throwable {
        novoProcesso.campoSelect(campo,valor);
    }

    @E("^o usuario escolher \"([^\"]*)\" com o valor igual a \"([^\"]*)\"$")
    public void oUsuarioEscolherComOValorIgualA(String campo, String valor) throws Throwable {
        novoProcesso.campoRadio(campo,valor);
    }
}
