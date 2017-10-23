package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Nombre.StdTrnMsjParmVDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Nombre.StdTrnOParmVDTO;

import java.util.ArrayList;


@AllArgsConstructor
@NoArgsConstructor
public class OtrConsulAnAnotPantTDTO {
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
	private TrConsulAnAnotPantEvDTO TR_CONSUL_AN_ANOT_PANT_EV;
	@Getter
	@Setter
	private ArrayList<StdTrnMsjParmVDTO> STD_TRN_MSJ_PARM_V;
	@Getter
	@Setter
	private StdTrnOParmVDTO STD_TRN_O_PARM_V;
	
}
