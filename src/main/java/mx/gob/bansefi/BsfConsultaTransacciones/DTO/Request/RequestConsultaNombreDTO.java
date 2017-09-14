package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class RequestConsultaNombreDTO {
	
	@Getter
	@Setter
	private String idInternoPe;
	@Getter
	@Setter
	private String entidad;
	@Getter
	@Setter
	private String terminal;
	@Getter
	@Setter
	private String usuario;
	@Getter
	@Setter 
	private String password;
	

}
