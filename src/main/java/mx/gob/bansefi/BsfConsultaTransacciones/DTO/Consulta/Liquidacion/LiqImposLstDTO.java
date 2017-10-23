package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class LiqImposLstDTO {
	@Getter
	@Setter
	private ArrayList<LiqSbVDTO> LIQ_SB_V;
	@Getter
	@Setter
	private String NUMBER_OF_RECORDS;
}
