package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleAnotacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Nombre.StdTrnMsjParmVDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Nombre.StdTrnOParmVDTO;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class OtrConsulAnPantTrnODTO {
	@Getter
	@Setter
	private String RTRN_CD;
	@Getter
	@Setter
	private TrConsulAnPantEctZDTO TR_CONSUL_AN_PANT_EVT_Z;
	@Getter
	@Setter
	private ArrayList<StdTrnMsjParmVDTO> STD_TRN_MSJ_PARM_V;
	@Getter
	@Setter
	private StdTrnOParmVDTO STD_TRN_O_PARM_V;
}
