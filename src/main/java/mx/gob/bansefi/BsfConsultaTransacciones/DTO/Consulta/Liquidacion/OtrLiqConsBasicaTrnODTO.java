package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Transaccion.StdTrnOParmVDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Nombre.StdTrnMsjParmVDTO;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class OtrLiqConsBasicaTrnODTO {
	@Getter
	@Setter
	private String RTRN_CD;
	@Getter
	@Setter
	private String OCCURS_NR;
	@Getter
	@Setter
	private TrLiqConsBasicaEvtZDTO TR_LIQ_CONS_BASICA_EVT_Z;
	@Getter
	@Setter
	private ArrayList<StdTrnMsjParmVDTO> STD_TRN_MSJ_PARM_V;
	@Getter
	@Setter
	private StdTrnOParmVDTO STD_TRN_O_PARM_V;
}
