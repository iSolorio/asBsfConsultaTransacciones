package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class StdTargetTerminalVDTO {
	@Getter @Setter
	private String ID_INTERNO_EMPL_EP;
	@Getter @Setter
	private String ID_INTERNO_TERM_TN;
	@Getter @Setter
	private String COD_ECV_SESION;
}
