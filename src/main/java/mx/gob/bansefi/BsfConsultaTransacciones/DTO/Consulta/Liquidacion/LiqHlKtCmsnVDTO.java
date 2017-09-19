package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class LiqHlKtCmsnVDTO {
	@Getter
	@Setter
	private String IND_PRECIO_KT; 
	@Getter
	@Setter
	private String COD_COMSN_PRCTL; 
	@Getter
	@Setter
	private String CD_PCT; 
	@Getter
	@Setter
	private String CD_IMP; 
	@Getter
	@Setter
	private String ID_PDS_1; 
	@Getter
	@Setter
	private String ID_PARMCD_1; 
	@Getter
	@Setter
	private String VALOR_BASE; 
	@Getter
	@Setter
	private String FECHA_BASE; 
	@Getter
	@Setter
	private String CMSN_MIN; 
	@Getter
	@Setter
	private String CMSN_MAX; 
	@Getter
	@Setter
	private String CMSN_PCT; 
	@Getter
	@Setter
	private String IMP_CMSN_FIJ; 
	@Getter
	@Setter
	private String ID_TRAMEADO; 
	@Getter
	@Setter
	private String NUM_TRAMO; 
	@Getter
	@Setter
	private String SGN; 
}
