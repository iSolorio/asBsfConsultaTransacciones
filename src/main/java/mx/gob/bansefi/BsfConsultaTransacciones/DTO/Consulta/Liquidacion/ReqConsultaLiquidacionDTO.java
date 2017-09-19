package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ReqConsultaLiquidacionDTO {
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
	private String fechaLiquidacion;
	@Getter
	@Setter
	private String liqOpcion;
	@Getter
	@Setter
	private String acuerdo;
	@Getter
	@Setter
	private String detalle;
}
