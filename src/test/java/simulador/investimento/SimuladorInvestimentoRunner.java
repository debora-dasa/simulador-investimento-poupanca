package simulador.investimento;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\simulador-investimento", glue = {
		"simulador.investimento" }, plugin = { "pretty",
				"json:target/jsonReports/simulador-investimento.json" }, monochrome = true, snippets = SnippetType.CAMELCASE)

public class SimuladorInvestimentoRunner {

}
