package simulador.investimento;

import org.apache.http.entity.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TesteSimuladorInvestimentoAPI {

	@Test
	public void Teste() {
		
	String uriBase ="http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador/post";
		
	given()
		.relaxedHTTPSValidation()
		.param("id", 1)
		.param("meses", "12", "24", "36", "48")
	    .param("valor", "2802", "3174", "3564", "3971")
	.when()
		.get(uriBase)
	
	.then()
		.statusCode(200) 
		//.contentType(ContentType.JASON) 
		.body("headers.host",is("http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador")) 
		.body("args.id", containsString("1")); 

	}
}
