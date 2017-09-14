package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ResErrorDTO {
	@Getter
	@Setter
	private String codigo;
	@Getter
	@Setter
	private String mensaje;
}
