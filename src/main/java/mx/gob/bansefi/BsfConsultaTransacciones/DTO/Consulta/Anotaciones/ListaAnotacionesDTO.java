package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class ListaAnotacionesDTO {
	@Getter
	@Setter
	private String anotacion;
	@Getter
	@Setter
	private String descripcion;
	@Getter
	@Setter
	private String codAnt;
	@Getter
	@Setter
	private String fechaActivacion;
	@Getter
	@Setter
	private String prioridad;
	@Getter
	@Setter
	private String codSubAnt;
	@Getter
	@Setter
	private String textSubAnt;
	@Getter
	@Setter
	private String area;
	@Getter
	@Setter
	private String empleado;
}
