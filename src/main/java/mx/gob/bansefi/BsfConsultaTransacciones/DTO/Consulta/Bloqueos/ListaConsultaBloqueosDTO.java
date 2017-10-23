package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class ListaConsultaBloqueosDTO {

	@Getter
	@Setter
	private String tipo;
	@Getter
	@Setter
	private String estado;
	@Getter
	@Setter
	private String fechaAlta;
	@Getter
	@Setter
	private String fechaVTO;
	@Getter
	@Setter
	private String empleado;
	@Getter
	@Setter
	private String centro;
	@Getter
	@Setter
	private String importe;
	@Getter
	@Setter
	private String motivo;
	@Getter
	@Setter
	private String numeroBloqueo;
	@Getter
	@Setter
	private String cancelacion;
	
}
