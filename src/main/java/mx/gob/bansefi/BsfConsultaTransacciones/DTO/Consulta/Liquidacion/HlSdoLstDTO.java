package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class HlSdoLstDTO {
	@Getter
	@Setter
	private ArrayList<HlSdoEVDTO> HL_SDO_E_V;
	@Getter
	@Setter
	private String NUM_ELEMS;
}
