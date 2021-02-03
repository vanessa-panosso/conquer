package br.com.conquer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.conquer.domain.Cnae;

public interface CnaeRepository extends JpaRepository<Cnae, Integer>{

	Integer findIdByCodigoClassseAndCodigoDivisaoAndCodigoGrupoAndCodigoSecaoAndCodigoSubclasse(String codigoClassse,
			String codigoDivisao, String codigoGrupo, String codigoSecao, String divisao);

	@Query("select max(id) from Cnae")
	Integer maxId();

}
