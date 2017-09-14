package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
public class IdfrAcLVDTO {

	@Getter
	@Setter
	private String COD_NRBE_EN; 
	@Getter
	@Setter
	private String COD_CSB_OF; 
	@Getter
	@Setter
	private String COD_INTERNO_UO; 
	@Getter
	@Setter
	private String COD_DIG_CR_UO;  
	@Getter
	@Setter
	private String NUM_SEC_AC; 
	@Getter
	@Setter
	private String COD_PLZ_BANCARIA; 
}
