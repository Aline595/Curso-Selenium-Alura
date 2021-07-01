package leiloes;

import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {

    private WebDriver browser;

    public CadastroLeilaoPage(WebDriver browser) {
        this.browser = browser;
    }

    private void fechar() {
        this.browser.quit();
    }
}