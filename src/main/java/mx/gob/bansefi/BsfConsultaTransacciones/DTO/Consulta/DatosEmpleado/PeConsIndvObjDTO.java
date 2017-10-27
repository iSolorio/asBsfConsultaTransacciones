package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosEmpleado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class PeConsIndvObjDTO {
	@Getter @Setter
	private String NOMB_50;
	@Getter @Setter
	private String ID_INTERNO_PE;
	@Getter @Setter 
	private String ID_EXT_PE;
	@Getter @Setter
	private String NOMB_IN_NOMB_PILA;
	@Getter @Setter
	private String NOMB_IN_APE_1_IN;
	@Getter @Setter
	private String NOMB_IN_APE_2_IN;
}
