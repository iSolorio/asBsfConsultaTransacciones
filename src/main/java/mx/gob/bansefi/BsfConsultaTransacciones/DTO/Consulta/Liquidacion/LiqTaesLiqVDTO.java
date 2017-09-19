package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class LiqTaesLiqVDTO {
	@Getter
	@Setter
	private String COD_INF_ADIC_HL;
	@Getter
	@Setter
	private String VALOR_INF_ADIC_HL;
	@Getter
	@Setter
	private String TAE;
}
