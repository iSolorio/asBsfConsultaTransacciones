package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
/*Respuesta completa del anidamiento*/
public class ConsultaBansefiDTO {
	@Getter @Setter
	private String RTRN_CD;
	@Getter @Setter
	private String NUMBER_OF_RECORDS;
	@Getter @Setter
	private String MORE_DATA_IN;
	@Getter @Setter
	ConsultaApuntesDTO TR_CONSULTA_APNTES_PSV_EV;/*Todo el nido que trae la informacion importante*/
	@Getter @Setter
	private StdAutorizaV STD_AUTORIZA_V;/*El nido de errores*/
	@Getter @Setter
	private ArrayList<ArTrnMsjParmVDTO>  STD_TRN_MSJ_PARM_V;/*Errores de tcb, reutilizamos bean por que es exactamente el mismo*/
	@Getter @Setter
	private StdTrnOParmVDTO STD_TRN_O_PARM_V;
	//Faltan los nidos
}
