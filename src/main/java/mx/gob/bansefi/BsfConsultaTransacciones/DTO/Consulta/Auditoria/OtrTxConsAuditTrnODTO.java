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
public class OtrTxConsAuditTrnODTO {
	@Getter
	@Setter
	private String RTRN_CD;
	@Getter
	@Setter
	private String NUMBER_OF_RECORDS;
	@Getter
	@Setter 
	private String MORE_DATA_IN;
	@Getter
	@Setter
	private TrTxConsAuditvtZDTO TR_TX_CONS_AUDIT_EVT_Z;
	@Getter
	@Setter
	private ArrayList<StdTrnMsjParmVDTO> STD_TRN_MSJ_PARM_V;
	@Getter
	@Setter
	private StdTrnOParmVDTO STD_TRN_O_PARM_V;
}
