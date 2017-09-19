package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResGralDTO;

@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaLiquidacionDTO {
	@Getter
	@Setter
	private ResGralDTO cabecera;
}
