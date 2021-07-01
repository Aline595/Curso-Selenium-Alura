package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class LoginTest {
		
    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
    	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //Informa onde fica o driver do chrome
		WebDriver browser = new ChromeDriver(); // Abri o navegador
		browser.navigate().to("http://localhost:8080/login");
        browser.findElement(By.id("username")).sendKeys("fulano"); //sendkey -> coloca valor
        browser.findElement(By.id("password")).sendKeys("pass"); 
        browser.findElement(By.id("login-form")).submit(); // submit -> clica no botão

        Assert.assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/login")); // verifica se a página não é a mesma mais 
        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText()); // Verifica se aparece fulano  
        browser.quit();
    }
}
