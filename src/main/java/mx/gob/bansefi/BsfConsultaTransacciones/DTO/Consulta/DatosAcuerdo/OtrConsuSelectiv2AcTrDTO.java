package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.StdTrnOParmVDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Nombre.StdTrnMsjParmVDTO;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
public class OtrConsuSelectiv2AcTrDTO {
	@Getter
	@Setter
	private String RTRN_CD;
	@Getter
	@Setter
	private String MORE_DATA_IN;
	@Getter
	@Setter
	private String NUMBER_OF_RECORDS;
	@Getter
	@Setter
	private ArrayList<TrConsuSelectiv2AcEvtDTO> TR_CONSU_SELECTIV2_AC_EVT;
	@Getter
	@Setter
	private ArrayList<StdTrnMsjParmVDTO> STD_TRN_MSJ_PARM_V;
	@Getter
	@Setter
	private StdTrnOParmVDTO STD_TRN_O_PARM_V;
}
