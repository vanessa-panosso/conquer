package br.com.conquer.integration;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
	private static final String API = "http://www.portaltransparencia.gov.br/api-de-dados/cartoes?pagina=";

	public List<DespesaDTO> findExpense(final String startDate, final String endDate, final boolean todasPaginas) throws URISyntaxException {
		final String startDateFormat = "&dataTransacaoInicio=" + startDate;
		final String endDateFormat = "&dataTransacaoFim=" + endDate;

		final RestTemplate restTemplate = new RestTemplate();
		boolean ultimaLista = false;
		final List<DespesaDTO> list = new ArrayList<>();
		Integer pagina = 1;
		while (!ultimaLista) {
			URI uri = new URI(API + pagina + startDateFormat + endDateFormat);
			HttpHeaders headers = new HttpHeaders();
			headers.set("chave-api-dados", KEY);
			headers.set("Accept", "application/json");
			HttpEntity<List<DespesaDTO>> requestEntity = new HttpEntity<>(null, headers);

			ResponseEntity<DespesaDTO[]> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity,
					DespesaDTO[].class);
			if (result.getBody() == null || result.getBody().length == 0) {
				ultimaLista = true;
				break;
			}

			list.addAll(Arrays.asList(result.getBody()));
			if (!todasPaginas) break;
			pagina++;
		}
		return list;
	}
}
