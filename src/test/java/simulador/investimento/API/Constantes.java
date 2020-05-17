package simulador.investimento.API;


import io.restassured.http.ContentType;

public interface Constantes {
	String APP_BASE_URL = "https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/";

	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	Long MAX_TIMEOUT = 100L;
}
