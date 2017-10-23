package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleAnotacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResGralDTO;

@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaDetalleAnotacionDTO {
	@Getter
	@Setter
	private ResGralDTO cabecera;
	@Getter
	@Setter
	private String idEmpleado;
	@Getter
	@Setter
	private String fechaPlanificacion;
	@Getter
	@Setter
	private String fechaUltimaModificacion;
}
