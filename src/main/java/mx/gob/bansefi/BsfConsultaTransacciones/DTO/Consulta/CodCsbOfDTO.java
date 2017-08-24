package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
/*DTO para obtener ese cod_csb_of , bean llamado asi por conveniencia, es ams facil ubicarlos por nombres asi de especificos */

public class CodCsbOfDTO {
	@Getter @Setter
	private String COD_CSB_OF;
}
