package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class HlClaveAfVDTO {
	@Getter
	@Setter
	private String NUM_SEC;
	@Getter
	@Setter
	private String PRPDAD_CTA;
	@Getter
	@Setter
	private String NUM_SUBAC;
}
