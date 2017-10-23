package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class AnClavePadreVDTO {
	@Getter
	@Setter
	private String COD_NRBE_EN;
	@Getter
	@Setter
	private String COD_ANTCN;
	@Getter
	@Setter
	private String SUBCD_ANTCN;
	@Getter
	@Setter
	private String NUMERO_ANTCN;
}
