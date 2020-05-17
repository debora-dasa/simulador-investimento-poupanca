package simulador.investimento;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SimuladorInvestimentoSteps {
	WebDriver driver;
	private static final By BY_VALOR_FIELD = By.id("valorAplicar");
	private static final By BY_MENSAL_FIELD = By.id("valorInvestir");
	private static final By BY_TEMPO_FIELD = By.id("tempo");
	private static final By BY_BUTTON_FIELD = By.className("simular");
	private static final By BY_RESULTADO_FIELD = By.className("blocoResultadoSimulacao");
	private static final By BY_VALOR_APLICAR_ERRADO_FIELD = By.id("valorAplicar-error");

	@Before
	public void initWebDriver() throws Throwable {
		driver = new ChromeDriver();
	}

	@Given("o usuario esta na pagina do simulador")
	public void o_usuario_esta_na_pagina_do_simulador() {
		driver.manage().window().maximize();
		driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
	}

	@When("informa o valor a aplicar {string}")
	public void informa_o_valor_a_aplicar(String valor) {
		WebElement valorField = new WebDriverWait(driver, 40)
				.until(ExpectedConditions.elementToBeClickable(BY_VALOR_FIELD));
		valorField.sendKeys(valor);

	}

	@When("informa o valor que quer poupar todo mes {string}")
	public void informa_o_valor_que_quer_poupar_todo_mes(String mensal) {
		WebElement mensalField = new WebDriverWait(driver, 40)
				.until(ExpectedConditions.elementToBeClickable(BY_MENSAL_FIELD));
		mensalField.sendKeys(mensal);
	}

	@When("informa o tempo {string}")
	public void informa_o_tempo(String tempo) {
		WebElement tempoField = new WebDriverWait(driver, 40)
				.until(ExpectedConditions.elementToBeClickable(BY_TEMPO_FIELD));
		tempoField.sendKeys(tempo);
	}

	@When("clicar em Simular")
	public void clicar_em_Simular() {
		WebElement buttonField = new WebDriverWait(driver, 40)
				.until(ExpectedConditions.elementToBeClickable(BY_BUTTON_FIELD));
		buttonField.click();

	}

	@Then("visualiza a tabela com simulacao")
	public void visualiza_a_tabela_com_simulacao() {
		WebElement resultadoField = new WebDriverWait(driver, 40)
				.until(ExpectedConditions.elementToBeClickable(BY_RESULTADO_FIELD));

	}
	
	/*@Given("que clico no botao refazer") public void queClicoNoBotaoRefazer() {
		 WebElement refazerField = new WebDriverWait(driver, 40)
		  .until(ExpectedConditions.elementToBeClickable(By.className("blocoResultadoSimulacao")));
		 
		 
		List<WebElement> botaoRefazer = refazerField.findElements(By.tagName("div"));
		for (WebElement botao1Refazer : botaoRefazer) {

			WebElement linkMenu = botao1Refazer.findElement(By.tagName("a"));

			if (linkMenu.getText().trim().equals("Refazer a simulação")) {
				linkMenu.click();
				break;
			}}*/



	@Given("o usuario esta novamente na pagina do simulador")
	public void o_usuario_esta_novamente_na_pagina_do_simulador() {
		driver.manage().window().maximize();
		driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
	}

	
	@When("informa o valor a aplicar menor que vinte reais{string}")
	public void informaOValorAAplicarMenorQueVinteReais(String valor) {
		WebElement mensalField = new WebDriverWait(driver, 40)
				.until(ExpectedConditions.elementToBeClickable(BY_VALOR_FIELD));
		mensalField.sendKeys(valor);
	}

	@When("clico no campo valor mensal")
	public void clicoNoCampoValorMensal() {
		WebElement mensalField = new WebDriverWait(driver, 40)
				.until(ExpectedConditions.elementToBeClickable(BY_MENSAL_FIELD));
		mensalField.sendKeys();
		mensalField.click();
	}

	@Then("visualiza a mensagem {string}")
	public void visualizoAMensagem(String mensagem) {
		WebElement mensalField = new WebDriverWait(driver, 40)
				.until(ExpectedConditions.elementToBeClickable(BY_VALOR_APLICAR_ERRADO_FIELD));
		mensalField.sendKeys(mensagem);
	}

	/*
	 * @After public void disposerWebDriver() throws Throwable { driver.quit(); }
	 */

}
