package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas;


import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ResGralDTO {
	@Getter
	@Setter
	private String mensaje;
	@Getter
	@Setter
	private String status;
	@Getter
	@Setter
	private ArrayList<ResErrorDTO> errores;
}
