package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class HlInfAdicLtsDTO {
	@Getter
	@Setter
	private String NUM_ELEMS;
	@Getter
	@Setter
	private ArrayList<HlInfAdicVDTO> HL_INF_ADIC_V;
}
