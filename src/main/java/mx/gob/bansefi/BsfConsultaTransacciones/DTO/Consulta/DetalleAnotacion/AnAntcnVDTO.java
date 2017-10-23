package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleAnotacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class AnAntcnVDTO {
	@Getter
	@Setter
	private String COD_TX;
	@Getter
	@Setter
	private String FECHA_PLANIF;
	@Getter
	@Setter
	private String HORA_PLANIF;
}
