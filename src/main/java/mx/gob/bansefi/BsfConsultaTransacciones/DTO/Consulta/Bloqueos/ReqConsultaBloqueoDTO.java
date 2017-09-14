package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class ReqConsultaBloqueoDTO {
	@Getter
	@Setter
	private String usuario;
	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	private String terminal;
	@Getter
	@Setter
	private String entidad;
	@Getter
	@Setter
	private String acuerdo;
	@Getter
	@Setter String estado;
}