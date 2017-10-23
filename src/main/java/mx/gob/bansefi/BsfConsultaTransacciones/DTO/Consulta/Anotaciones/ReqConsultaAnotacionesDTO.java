package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class ReqConsultaAnotacionesDTO {
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
	private String acuerdo;
	@Getter
	@Setter
	private String fechaDesde;
	@Getter
	@Setter
	private String fechaHasta;
	@Getter
	@Setter
	private String antInformativa;
	@Getter
	@Setter
	private String antAlerta;
	@Getter
	@Setter
	private String antImperativa;
	@Getter
	@Setter
	private String antAvisos;
	@Getter
	@Setter
	private String sucursal;
}
