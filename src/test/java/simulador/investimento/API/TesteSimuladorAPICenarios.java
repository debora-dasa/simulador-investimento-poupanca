package simulador.investimento.API;

import org.junit.Test;

import io.restassured.RestAssured;


public class TesteSimuladorAPICenarios extends TesteSimuladorInvestimentoAPI {
	
	


	@Test 
	public void naoDeveAcessarAPISemToken () {
		RestAssured.given()
		.when()
		.then()
		;
		
		
		
	}
	
	
	
	

}
