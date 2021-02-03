package br.com.conquer.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

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

	public void exportarCSV(String dataInicio, String dataFinal, boolean todasPaginas, HttpServletResponse response) throws URISyntaxException, IOException {		
		final List<DespesaDTO> despedaDTOs = consumidorApi.findExpense(dataInicio, dataFinal, todasPaginas);
		repository.saveAll(mapper.toEntities(despedaDTOs));
		
		List<DespesaMunicipio> despesas = repository.findByDataTransacaoGroupByValor(mapper.from(dataInicio), mapper.from(dataFinal));
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Codigo IBGE","Nome municipio","Total"};
        String[] nameMapping = {"codigoIbge", "municipioNome", "valorTotal"};

        csvWriter.writeHeader(csvHeader);
        
        for (DespesaMunicipio despesaMunicipio : despesas) {
            csvWriter.write(despesaMunicipio, nameMapping);
		}
        csvWriter.close();
	}

}
