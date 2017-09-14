package mx.gob.bansefi.BsfConsultaTransacciones.DTO.ConsultaNombre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class StdTrnOParmVDTO {
	@Getter
	@Setter
	private String FECHA_OPRCN;
	@Getter
	@Setter
	private String HORA_OPRCN;
}
