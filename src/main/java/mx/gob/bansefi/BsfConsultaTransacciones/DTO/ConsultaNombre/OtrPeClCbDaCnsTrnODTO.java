package mx.gob.bansefi.BsfConsultaTransacciones.DTO.ConsultaNombre;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class OtrPeClCbDaCnsTrnODTO {
	@Getter
	@Setter
	private TrPeClCbDaCnsEvtZDTO TR_PE_CL_CB_DA_CNS_EVT_Z;
	@Getter
	@Setter
	private ArrayList<StdTrnMsjParmVDTO> STD_TRN_MSJ_PARM_V;
	@Getter
	@Setter
	private StdTrnOParmVDTO STD_TRN_O_PARM_V;
	
	@Getter
	@Setter
	private String RTRN_CD;
}
