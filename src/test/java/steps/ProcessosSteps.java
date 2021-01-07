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
    private String codigo = null;

    @Dado("^que o usuario esta na pagina inicial$")
    public void queOUsuarioEstaNaPaginaInicial() {
        homePage.open();
    }

    @E("^que o usuario clica no menu processos$")
    public void queOUsuarioClicaNoMenuProcessos()
    {
        menuLateral.clickProcessos();
    }

    @E("^o usuario clica no botao Novo Processo$")
    public void oUsuarioClicaNoBotaoNovoProcesso() {
        listaProcessos.clickNovoProcesso();
    }

    @Quando("^o usuario clicar no botao de salvar$")
    public void oUsuarioClicarNoBotaoDeSalvar()
    {
        novoProcesso.clickSalvar();
        novoProcesso.setCode(detalheProcesso.getCode());
    }

    @Então("^o usuario deveria ver a mensagem \"([^\"]*)\"$")
    public void oUsuarioDeveriaVerAMensagem(String message) {
        Assert.assertEquals(message, detalheProcesso.getText("notice"));
    }

    @E("^o usuario informar \"([^\"]*)\" com o valor igual a \"([^\"]*)\"$")
    public void oUsuarioInformarComOValorIgualA(String campo, String valor) {
        novoProcesso.campoInput(campo, valor);
    }

    @E("^o usuario clicar no botão voltar$")
    public void oUsuarioClicarNoBotaoVoltar() {
        detalheProcesso.clickVoltar();
    }

    @E("^o usuario clica no botao editar do processo cadastrado$")
    public void oUsuarioClicaNoBotaoEditarDoProcessoCadastrado() {
        listaProcessos.clickEditarProcesso(novoProcesso.getCode());
    }

    @E("^o usuario informar \"([^\"]*)\" com o valor igual a \"([^\"]*)\" na tela de edicao$")
    public void oUsuarioInformarComOValorIgualANaTelaDeEdicao(String campo, String valor) {
        editarProcesso.campoInput(campo, valor);
    }

    @Quando("^o usuario clicar no botao de salvar na tela de edicao$")
    public void oUsuarioClicarNoBotaoDeSalvarNaTelaDeEdicao() {
        editarProcesso.clickSalvar();
    }

    @Então("^o usuario deveria ver o valor \"([^\"]*)\" no campo \"([^\"]*)\"$")
    public void oUsuarioDeveriaVerOValorNoCampo(String valor, String campo) {
        Assert.assertEquals(valor, detalheProcesso.getText(campo));
    }

    @E("^o usuario selecionar \"([^\"]*)\" com o valor igual a \"([^\"]*)\"$")
    public void oUsuarioSelecionarComOValorIgualA(String campo, String valor) {
        novoProcesso.campoSelect(campo, valor);
    }

    @E("^o usuario escolher \"([^\"]*)\" com o valor igual a \"([^\"]*)\"$")
    public void oUsuarioEscolherComOValorIgualA(String campo, String valor) {
        novoProcesso.campoRadio(campo, valor);
    }

    @E("^pegar o codigo do processo salvo$")
    public void pegarOCodigoDoProcessoSalvo() {
        codigo = detalheProcesso.getCode();
    }

    @E("^clicar em voltar para Processos$")
    public void clicarEmVoltarParaProcessos() {
        detalheProcesso.clickVoltar();
    }

    @Quando("^clicar em Apagar$")
    public void clicarEmApagar() {
        listaProcessos.clickApagarProcesso(codigo);
    }

    @E("^clicar em sim no alerta de confirmação$")
    public void clicarEmSimNoAlertaDeConfirmacao() {
        driver.ChooseOkOnNextConfirmation();
    }

    @Então("^não deve exibir o processo no grid$")
    public void naoDeveExibirOProcessoNoGrid() {
        listaProcessos.validarProcessoApagado(codigo);
    }

    @Quando("^clicar em Mostrar no processo que foi criado$")
    public void clicarEmMostrarNoProcessoQueFoiCriado() {
        listaProcessos.clickMostrarProcesso(codigo);
    }

    @Então("^o sistema deve apresentar o valor de processo \"([^\"]*)\"$")
    public void oSistemaDeveApresentarOValorDeProcesso(String arg0) {
        Assert.assertEquals(arg0, detalheProcesso.getNumeroProcesso());
    }

    @E("^o valor de Vara \"([^\"]*)\"$")
    public void oValorDeVara(String arg0) {
        Assert.assertEquals(arg0, detalheProcesso.getVara());
    }

    @E("^o valor de natureza \"([^\"]*)\"$")
    public void oValorDeNatureza(String arg0) {
        Assert.assertEquals(arg0, detalheProcesso.getNatureza());
    }

    @E("^o valor de partes \"([^\"]*)\"$")
    public void oValorDePartes(String arg0) {
        Assert.assertEquals(arg0, detalheProcesso.getPartes());
    }
}
