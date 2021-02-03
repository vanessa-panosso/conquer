package br.com.conquer.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.conquer.domain.Despesa;
import br.com.conquer.dto.DespesaMunicipio;

/**
 * 
 * @author Vanessa Panosso
 * 
 */
public interface DespesaRepository extends JpaRepository<Despesa, Integer>{

	@Query("select new br.com.conquer.dto.DespesaMunicipio(m.codigoIbge, m.nomeIbge, sum(d.valorTransacao)) "
			+ "from Despesa d "
			+ "INNER JOIN d.estabelecimento e "
			+ "INNER JOIN e.municipio m "
			+ "WHERE d.dataTransacao between :dataInicio and :dataFinal "
			+ "GROUP BY m.codigoIbge, m.nomeIbge")
	List<DespesaMunicipio> findByDataTransacaoGroupByValor(LocalDate dataInicio, LocalDate dataFinal);

}
