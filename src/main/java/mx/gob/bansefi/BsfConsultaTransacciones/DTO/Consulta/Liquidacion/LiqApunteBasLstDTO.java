package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class LiqApunteBasLstDTO {
	@Getter
	@Setter
	private String NUMBER_OF_RECORDS;
	@Getter
	@Setter
	private ArrayList<LiqApunteBasVDTO> LIQ_APUNTE_BAS_V;
}
