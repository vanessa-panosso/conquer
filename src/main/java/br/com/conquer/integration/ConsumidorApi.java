package br.com.conquer.integration;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.conquer.dto.DespedaDTO;

@Component
public class ConsumidorApi {
	private static final String KEY = "6e23e6fa786e01c2cfb4cf2996e28194";
	private static final String API = "http://www.portaltransparencia.gov.br/api-de-dados/cartoes?pagina=1";
	private static final String BARRA = "%2F";
	
	public List<DespedaDTO> findExpense(final String startDate, final String endDate) throws URISyntaxException {
		final String startDateFormat = String.format("mesExtratoInicio=", startDate.replaceAll("/", BARRA));
		final String endDateFormat = String.format("mesExtratoFim==", endDate.replaceAll("/", BARRA));
		
		final RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI(API + startDateFormat + endDateFormat);
		HttpHeaders headers = new HttpHeaders();
		headers.set("chave-api-dados", KEY);
		headers.set("Accept", "application/json");
		HttpEntity<List<DespedaDTO>> requestEntity = new HttpEntity<>(null, headers);

		ResponseEntity<ArrayList> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, ArrayList.class);
		return result.getBody();
	}
}
