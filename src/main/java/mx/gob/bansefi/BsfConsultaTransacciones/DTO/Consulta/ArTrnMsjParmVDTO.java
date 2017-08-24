package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ArTrnMsjParmVDTO {
	@Getter @Setter
	private String TEXT_CODE;
	@Getter @Setter
	private String TEXT_ARG1;
}
