package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleAnotacion;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ReqConsultaDetalleAnotacionDTO {
	@Getter
	@Setter
	private String usuario;
	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	private String entidad;
	@Getter
	@Setter
	private String terminal;
	@Getter
	@Setter
	private String codAnt;
	@Getter
	@Setter
	private String codSubAnt;
	@Getter
	@Setter
	private String anotacion; 
}
