package br.com.conquer.service;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.conquer.domain.Despesa;
import br.com.conquer.dto.DespesaDTO;
import br.com.conquer.dto.DespesaMunicipio;
import br.com.conquer.integration.ConsumidorApi;
import br.com.conquer.mapper.DespesaMapper;
import br.com.conquer.repository.DespesaRepository;

/**
 * 
 * @author Vanessa Panosso
 * 
 */
@Service
public class DespesaService {

	@Autowired
	private DespesaRepository repository;
	
	@Autowired
	private ConsumidorApi consumidorApi;
	
	@Autowired
	private DespesaMapper mapper;
	
	public Despesa save(final Despesa expense) {
		return repository.save(expense);
	}
	
	public Despesa findById(final Integer id) {
		return repository.getOne(id);
	}
	
	public List<Despesa> findAll() {
		return repository.findAll();
	}

	public String exportarCSV(String dataInicio, String dataFinal) throws URISyntaxException {		
		final List<DespesaDTO> despedaDTOs = consumidorApi.findExpense(dataInicio, dataFinal);
		repository.saveAll(mapper.toEntities(despedaDTOs));
		
		List<DespesaMunicipio> dadosCsv = repository.findByDataTransacaoGroupByValor(mapper.from(dataInicio), mapper.from(dataFinal));
		return generateCsv(dadosCsv);
	}
	
	private String generateCsv(List<DespesaMunicipio> dados) {
		final StringBuilder sb = new StringBuilder();
		sb.append("Codigo IBGE;Nome municipio; Total\r\n");
		for (DespesaMunicipio despesaCsvDto : dados) {
			sb.append(despesaCsvDto.getCodigoIbge());
			sb.append(";");
			sb.append(despesaCsvDto.getMunicipioNome());
			sb.append(";");
			sb.append(despesaCsvDto.getValorTotal());
			sb.append("\r\n");
		}
		return sb.toString();
	}

}
