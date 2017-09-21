package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ListaLiquidacionDTO {
	@Getter
	@Setter 
	private String importeFacturado;
	@Getter
	@Setter
	private String importePendiente;
	@Getter
	@Setter
	private String importeCondonado;
	@Getter
	@Setter
	private String importeAjustado;
	@Getter
	@Setter
	private String codigoOrigen;
}
