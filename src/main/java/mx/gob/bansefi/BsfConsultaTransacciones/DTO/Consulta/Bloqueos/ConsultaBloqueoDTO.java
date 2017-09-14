package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaBloqueoDTO {
	@Getter
	@Setter
	private String TRANID;
	@Getter
	@Setter
	private String ESTATUS;
	@Getter
	@Setter
	private String CODIGO;
	@Getter
	@Setter
	private String NUMTASK;
	@Getter
	@Setter
	private String MENSAJE;
	@Getter
	@Setter
	private ResponseBansefiDTO ResponseBansefi;
}
