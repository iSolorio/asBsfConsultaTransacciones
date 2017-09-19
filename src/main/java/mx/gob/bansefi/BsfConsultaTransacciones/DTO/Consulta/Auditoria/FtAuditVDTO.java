package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class FtAuditVDTO {
	@Getter
	@Setter
	private String COD_NRBE_EN; 
	@Getter
	@Setter
	private String COD_TBL_REF; 
	@Getter
	@Setter
	private String COD_APLCCN_SUBAPL; 
	@Getter
	@Setter
	private String CLAVE_FILA; 
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
	private String ID_INTERNO_EMPL_EP; 
	@Getter
	@Setter
	private String COD_INTERNO_UO; 
	@Getter
	@Setter
	private String ID_EMPL_AUT;
}
