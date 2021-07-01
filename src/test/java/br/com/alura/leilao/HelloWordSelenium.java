package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWordSelenium {
	
	@Test
    public void hello() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //Informa onde fica o driver do chrome
		WebDriver browser = new ChromeDriver(); // Abri o navegador
		browser.navigate().to("http://localhost:8080/leiloes"); // vai até está url
		browser.quit(); //Fecha janela do navegador
    }
}
