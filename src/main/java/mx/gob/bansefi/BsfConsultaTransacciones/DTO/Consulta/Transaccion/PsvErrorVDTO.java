package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Transaccion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
/*Bean que trae los errores de los apuntes*/
public class PsvErrorVDTO {
	@Getter @Setter
	private String COD_ERROR;
	@Getter @Setter
	private String ID_EMPL_AUT;
	@Getter @Setter
	private String ATRIBUIDO_S_N;
}
