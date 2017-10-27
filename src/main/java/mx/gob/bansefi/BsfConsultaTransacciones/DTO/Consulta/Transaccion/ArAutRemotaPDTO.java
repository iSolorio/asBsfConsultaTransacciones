package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Transaccion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ArAutRemotaPDTO {
	@Getter @Setter
	private String COD_NRBE_EN;
	@Getter @Setter
	private String ID_INTERNO_TERM_TN;
	@Getter @Setter
	private String FECHA_OPRCN;
	@Getter @Setter
	private String HORA_OPRCN;
	
}
