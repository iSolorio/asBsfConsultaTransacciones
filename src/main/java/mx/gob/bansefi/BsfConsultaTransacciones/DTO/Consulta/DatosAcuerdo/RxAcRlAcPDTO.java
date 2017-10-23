package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class RxAcRlAcPDTO {
	@Getter
	@Setter
	private String COD_NRBE_EN; 
	@Getter
	@Setter
	private String COD_CENT_UO_1; 
	@Getter
	@Setter
	private String NUM_SEC_AC_1; 
	@Getter
	@Setter
	private String COD_RL_AC_AC; 
	@Getter
	@Setter
	private String COD_CENT_UO_2; 
	@Getter
	@Setter
	private String NUM_SEC_AC_2;  
}
