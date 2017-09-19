package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class HlAuditEDTO {
	@Getter
	@Setter
	private String COD_NRBE_EN; 
	@Getter
	@Setter
	private String COD_CENT_UO; 
	@Getter
	@Setter
	private String NUM_SEC_AC; 
	@Getter
	@Setter
	private String FECHA_LIQ; 
	@Getter
	@Setter
	private String NUM_SEC; 
	@Getter
	@Setter
	private String FECHA_OPRCN; 
	@Getter
	@Setter
	private String HORA_OPRCN; 
	@Getter
	@Setter
	private String ID_INTERNO_TERM_TN; 
	@Getter
	@Setter
	private String COD_TX; 
	@Getter
	@Setter
	private String COD_MODIF_HL; 
	@Getter
	@Setter
	private String ID_EMPL_AUT; 
	@Getter
	@Setter
	private String ID_INTERNO_EMPL_EP; 
	@Getter
	@Setter
	private String COD_INTERNO_UO; 
	@Getter
	@Setter
	private String FECHA_CTBLE; 
}
