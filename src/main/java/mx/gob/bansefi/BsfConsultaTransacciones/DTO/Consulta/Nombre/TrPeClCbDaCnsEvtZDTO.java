package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Nombre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class TrPeClCbDaCnsEvtZDTO {
	
	@Getter
	@Setter
	private String COD_NRBE_EN;
	@Getter
	@Setter
	private String ID_INTERNO_PE;
	@Getter
	@Setter
	private String NOMB_50;
	@Getter
	@Setter
	private String COD_PE;
	@Getter
	@Setter
	private String ID_EXT_PE;
}
