package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Cheque;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ReqConsultaChequeDTO {
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
	private String codigoCaja;
	@Getter
	@Setter
	private String numCheque;
	@Getter
	@Setter
	private String acuerdo;
	@Getter
	@Setter
	private String codSeguridad;
	@Getter
	@Setter
	private String entidad;
}
