package br.com.conquer.mapper;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.conquer.domain.Cnae;
import br.com.conquer.domain.Despesa;
import br.com.conquer.domain.Municipio;
import br.com.conquer.domain.OrgaoVinculado;
import br.com.conquer.dto.CnaeDTO;
import br.com.conquer.dto.DespesaDTO;
import br.com.conquer.dto.MunicipioDTO;
import br.com.conquer.dto.OrgaoVinculadoDTO;
import br.com.conquer.repository.CnaeRepository;

/**
 * 
 * @author Vanessa Panosso
 * 
 */
@Mapper(componentModel = "spring")
public abstract class DespesaMapper {

	@Autowired
	private CnaeRepository cnaeRepository;

	public abstract DespesaDTO toDto(final Despesa expense);

	public abstract Despesa toEntity(final DespesaDTO expenseDTO);

	public abstract List<DespesaDTO> toDtos(final List<Despesa> expense);

	public abstract List<Despesa> toEntities(final List<DespesaDTO> expenseDTO);

	@Mapping(target = "codigoIBGE", source = "codigoIbge")
	@Mapping(target = "nomeIBGE", source = "nomeIbge")
	public abstract MunicipioDTO toDto(final Municipio entity);

	@Mapping(target = "codigoIbge", source = "codigoIBGE")
	@Mapping(target = "nomeIbge", source = "nomeIBGE")
	public abstract Municipio toEntity(final MunicipioDTO dto);

	@Mapping(target = "codigoSiafi", source = "codigoSIAFI")
	public abstract OrgaoVinculado toEntity(final OrgaoVinculadoDTO dto);

	@Mapping(target = "codigoSIAFI", source = "codigoSiafi")
	public abstract OrgaoVinculadoDTO toDto(final OrgaoVinculado entity);

	@Mapping(target = "id", ignore = true)
	public abstract Cnae toEntity(final CnaeDTO dto);

	public LocalDate from(String strData) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(strData, dtf);
	}

	public String from(LocalDate localDateTime) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(localDateTime);
	}

	public BigDecimal fromBigdecimal(String valor) {
		return new BigDecimal(valor.replaceAll(",", ""));
	}

	public String fromString(BigDecimal valor) {
		return valor.toString();
	}

	@AfterMapping
	public void findCnaeId(@MappingTarget final Despesa despesa, final DespesaDTO despesaDTO) {
		final CnaeDTO dto = despesaDTO.getEstabelecimento().getCnae();
		
		final Integer id = cnaeRepository.findIdByCodigoClassseAndCodigoDivisaoAndCodigoGrupoAndCodigoSecaoAndCodigoSubclasse(
				dto.getCodigoClassse(), dto.getCodigoDivisao(), dto.getCodigoGrupo(), dto.getCodigoSecao(),
				dto.getDivisao());
		
		if (id != null)
			despesa.getEstabelecimento().getCnae().setId(id);
		
		final Integer maxId = cnaeRepository.maxId();
		if (maxId != null)
			despesa.getEstabelecimento().getCnae().setId(maxId + 1);
		
		despesa.getEstabelecimento().getCnae().setId(1);
			
	}
}
