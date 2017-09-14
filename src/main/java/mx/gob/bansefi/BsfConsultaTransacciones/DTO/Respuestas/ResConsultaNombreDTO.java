package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaNombreDTO {

	@Getter
	@Setter
	private ResGralDTO cabecera;
	@Getter
	@Setter
	private String nombre;
	@Getter
	@Setter
	private String idInternoPe;
	@Getter
	@Setter
	private String idExt;
}
