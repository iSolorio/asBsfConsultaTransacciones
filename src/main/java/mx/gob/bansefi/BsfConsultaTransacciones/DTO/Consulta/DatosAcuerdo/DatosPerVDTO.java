package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class DatosPerVDTO {
	@Getter
	@Setter
	private String ID_INTERNO_PE;
	@Getter
	@Setter
	private String COD_ID_EXT_PERS;
	@Getter
	@Setter
	private String ID_EXT_PE;
	@Getter
	@Setter
	private String NOMB_50;
}
