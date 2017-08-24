package mx.gob.bansefi.BsfConsultaTransacciones.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ReqConsultaGeneralDTO {
	@Getter @Setter
	private String usuario;
	@Getter @Setter
	private String password;
	@Getter @Setter
	private String numsec;
	@Getter @Setter
	private String impaut;
	@Getter @Setter
	private String acuerdo;
	@Getter @Setter
	private String terminal;
	@Getter @Setter
	private String fechadesde;
	@Getter @Setter
	private String fechahasta;
	@Getter @Setter
	private String acceso;
	@Getter @Setter
	private String impsdo;
}
