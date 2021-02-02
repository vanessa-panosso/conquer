package br.com.conquer.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.conquer.domain.Despesa;
import br.com.conquer.domain.Municipio;
import br.com.conquer.domain.OrgaoVinculado;
import br.com.conquer.dto.DespedaDTO;
import br.com.conquer.dto.MunicipioDTO;
import br.com.conquer.dto.OrgaoVinculadoDTO;

/**
 * 
 * @author Vanessa Panosso
 * 
 */
@Mapper(componentModel = "spring")
public interface DespesaMapper {
	
	DespedaDTO toDto(final Despesa expense);
	Despesa toEntity(final DespedaDTO expenseDTO);

	List<DespedaDTO> toDto(final List<Despesa> expense);
	List<Despesa> toEntity(final List<DespedaDTO> expenseDTO);
	

	@Mapping(target = "codigoIBGE", source = "codigoIbge")
	@Mapping(target = "nomeIBGE", source = "nomeIbge")
	MunicipioDTO toDto(final Municipio entity);
	
	@Mapping(target = "codigoIbge", source = "codigoIBGE")
	@Mapping(target = "nomeIbge", source = "nomeIBGE")
	Municipio toEntity(final MunicipioDTO dto);
	
	// @Mapping(target = "codigoSiafi", source = "codigoSIAFI")
	OrgaoVinculado toEntity(final OrgaoVinculadoDTO dto);

	// @Mapping(target = "codigoSIAFI", source = "codigoSiafi")
	OrgaoVinculadoDTO toDto(final OrgaoVinculado entity);
}
