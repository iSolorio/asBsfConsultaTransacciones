package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class ReqConsultaDetalleTransaccionDTO {
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
	private String detalle;
	@Getter
	@Setter
	private String importe;
	@Getter
	@Setter
	private String fecha;
	@Getter
	@Setter
	private String signo;
	@Getter
	@Setter
	private String codorigen;
	@Getter
	@Setter
	private String codapunte;
	@Getter
	@Setter
	private String codcuenta;
}
