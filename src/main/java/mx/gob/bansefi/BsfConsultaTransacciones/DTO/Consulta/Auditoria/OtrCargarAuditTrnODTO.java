package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.StdTrnOParmVDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Nombre.StdTrnMsjParmVDTO;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
public class OtrCargarAuditTrnODTO {
	@Getter
	@Setter
	private String RTRN_CD;
	@Getter
	@Setter
	private  TrCargarAuditEvtZDTO TR_CARGAR_AUDIT_EVT_Z;
	@Getter
	@Setter
	private ArrayList<StdTrnMsjParmVDTO> STD_TRN_MSJ_PARM_V;
	@Getter
	@Setter
	private StdTrnOParmVDTO STD_TRN_O_PARM_V;
	
}
