package leiloes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import login.LoginPage;

public class LeiloesTest {
		
	private LeiloesPage paginaDeLeiloes;

    @AfterEach
    public void afterEach(){
        this.paginaDeLeiloes.fechar();
    }
    
    @Test
    public void deveriaCadastrarLeilao() {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
        this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
        CadastroLeilaoPage paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
    }
}
