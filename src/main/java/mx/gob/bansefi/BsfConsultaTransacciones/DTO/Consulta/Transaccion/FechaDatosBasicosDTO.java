package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Transaccion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
/*DTO qe complementa a datos basicos por la respuesta de json anidado*/
public class FechaDatosBasicosDTO {
	@Getter @Setter
	private String FECHA_OPRCN; 
}
