package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones.CodInternoUoDTO;
@AllArgsConstructor
@NoArgsConstructor
public class TrPeticionConsultaBpEDTO {
	@Getter
	@Setter
	private CodInternoUoDTO COD_INTERNO_UO_V;
	@Getter
	@Setter
	private ArrayList<BpListaBloqueoVDTO> BP_LISTA_BLOQUEO_V;
	@Getter
	@Setter
	private String NOMB_50;
}
