package simulador.investimento.API;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteSimuladorAPICenarios  {
	
String uriBase = "http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador";
           
	
	@Test
	public void testConsultarSimulacaoGet() {
		
		given()
			.relaxedHTTPSValidation()
			.param("id", "1")
		.when()
			.get(uriBase)
		.then()
			.body("id", notNullValue())
			.body("meses", notNullValue())
			.body("valor", notNullValue())
			.statusCode(200)
			.contentType(ContentType.JSON);
	}
	
	@Test
	public void testCriarSimulacaoPost() {
		
		given()
			.relaxedHTTPSValidation()
			.body("{\"meses\" : \"20\"}")
			.body("{\"valor\" : \"100.00\"}")
		.when()
			.post(uriBase)
		.then()
			.statusCode(400)
			.contentType(ContentType.JSON);
	}

		
	@Test
	public void testSucessoApiSemAutenticacao() {
		RestAssured.authentication = RestAssured.DEFAULT_AUTH;
		
		given()
		.relaxedHTTPSValidation()
	.when()
		.get(uriBase)
	.then()
		.statusCode(200);
	}	
	
}
