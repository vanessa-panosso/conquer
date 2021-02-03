package br.com.conquer.integration;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.conquer.dto.DespesaDTO;

@Component
public class ConsumidorApi {
	private static final String KEY = "6e23e6fa786e01c2cfb4cf2996e28194";
	private static final String API = "http://www.portaltransparencia.gov.br/api-de-dados/cartoes?pagina=1";
	
	public List<DespesaDTO> findExpense(final String startDate, final String endDate) throws URISyntaxException {
		System.out.println("Data: " + startDate);
		final String startDateFormat = "&dataTransacaoInicio=" + startDate;
		final String endDateFormat = "&dataTransacaoFim=" + endDate;
		
		final RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI(API + startDateFormat + endDateFormat);
		HttpHeaders headers = new HttpHeaders();
		headers.set("chave-api-dados", KEY);
		headers.set("Accept", "application/json");
		HttpEntity<List<DespesaDTO>> requestEntity = new HttpEntity<>(null, headers);

		ResponseEntity<DespesaDTO[]> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, DespesaDTO[].class);
		return Arrays.asList(result.getBody());
	}
}
