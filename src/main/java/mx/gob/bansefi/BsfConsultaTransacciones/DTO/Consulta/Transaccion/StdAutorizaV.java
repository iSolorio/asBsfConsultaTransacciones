package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Transaccion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class StdAutorizaV {
	@Getter @Setter
	private String IND_BORRADO_AR;
	@Getter @Setter
	private String DESCR_TX;
	@Getter @Setter
	private String IND_AUT_SOLIC;
	@Getter @Setter
	private String IND_ATRIB_MANC_EP;
	@Getter @Setter
	private String COD_ESTADO_AR;
	@Getter @Setter
	private String ID_EMPL_SOL_AUT;
	@Getter @Setter
	private String IND_VERIF_ATRIB;
	@Getter @Setter
	private String IND_URG_AR;
	@Getter @Setter
	private String MOTIVO_ACCION_AUT_LEN;
	@Getter @Setter
	private String MOTIVO_ACCION_AUT;
	@Getter @Setter
	private String IND_ESCALABLE;
	@Getter @Setter
	private String IMP_AUT;
	@Getter @Setter
	private String IMPORTE_AR;
	@Getter @Setter
	private ArAutRemotaPDTO AR_AUT_REMOTA_P;
	@Getter @Setter
	private ArrayList<ArTrnMsjParmVDTO> AR_TRN_MSJ_PARM_V;
	@Getter @Setter
	private ArrayList<StdTargetTerminalVDTO> STD_TARGET_TERMINAL_V;
	@Getter @Setter
	private ArIdSaltadoV AR_ID_SALTADO_V;
}
