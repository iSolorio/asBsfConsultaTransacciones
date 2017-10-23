package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones.CodInternoUoDTO;
@AllArgsConstructor
@NoArgsConstructor
public class TrCargarAuditEvtZDTO {
	@Getter
	@Setter
	private NombEmplAutDTO NOMB_EMPL_AUT;
	@Getter
	@Setter
	private NombEmplAutDTO NOMB_EMPL_ORIG;
	@Getter
	@Setter
	private  CodInternoUoDTO COD_INTERNO_UO_AC_V;
	@Getter
	@Setter
	private String NOMB_ENT_EN;
}
