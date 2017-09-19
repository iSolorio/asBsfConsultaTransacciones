package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class HlTramoVDTO {
	@Getter
	@Setter
	private String ID_PDS; 
	@Getter
	@Setter
	private String ID_PARMCD; 
	@Getter
	@Setter
	private String FECHA_DESDE; 
	@Getter
	@Setter
	private String FECHA_HASTA; 
	@Getter
	@Setter
	private String VALOR_BASE; 
	@Getter
	@Setter
	private String CD_PCT; 
	@Getter
	@Setter
	private String IMP_TRAMO; 
	@Getter
	@Setter
	private String NUM_SUBAC; 
	@Getter
	@Setter
	private String CD_PCT_F; 
	@Getter
	@Setter
	private String VALOR_BASE_F; 
	@Getter
	@Setter
	private String TAE_LIQ; 
	@Getter
	@Setter
	private String NUM_TRAMO; 
	@Getter
	@Setter
	private String IND_COD_TRAMO; 
}
