package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class ConsBasicaVDOT {
	@Getter
	@Setter
	private String NOMB_50;
	@Getter
	@Setter
	private String NOMB_PDV;
	@Getter
	@Setter
	private String COD_TX;
}
