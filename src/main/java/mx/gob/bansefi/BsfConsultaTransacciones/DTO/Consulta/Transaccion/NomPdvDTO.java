package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Transaccion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
/*DTO para obtener ese nomb_pdv , bean llamado asi por conveniencia, es ams facil ubicarlos por nombres asi de especificos */
public class NomPdvDTO {
	@Getter @Setter
	private String NOMB_PDV;
	
}
