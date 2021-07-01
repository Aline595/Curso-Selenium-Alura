package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
		
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;

    @BeforeAll //Antes de todos
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");//Informa onde fica o driver do chrome
    }

    @BeforeEach // antes de cada
    public void beforeEach(){
        this.browser = new ChromeDriver();// Abri o navegador
        browser.navigate().to(URL_LOGIN);
    }

    @AfterEach// depois de cada
    public void afterEach(){
        this.browser.quit();
    }
    
    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
		browser.navigate().to(URL_LOGIN);
        browser.findElement(By.id("username")).sendKeys("fulano"); //sendkey -> coloca valor
        browser.findElement(By.id("password")).sendKeys("pass"); 
        browser.findElement(By.id("login-form")).submit(); // submit -> clica no botão

        Assert.assertFalse(browser.getCurrentUrl().equals(URL_LOGIN)); // verifica se a página não é a mesma mais 
        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText()); // Verifica se aparece fulano  
        browser.quit();
    }
    
    public void naoDeveriaLogarComDadosInvalidos() {
        browser.navigate().to(URL_LOGIN);
        browser.findElement(By.id("username")).sendKeys("invalido");
        browser.findElement(By.id("password")).sendKeys("123123");
        browser.findElement(By.id("login-form")).submit();

        Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
        Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos.")); // procura na página pra nãoprecisar procurar o id
        Assert.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado"))); // verifica se deu uma exception
        browser.quit();
    }
}
