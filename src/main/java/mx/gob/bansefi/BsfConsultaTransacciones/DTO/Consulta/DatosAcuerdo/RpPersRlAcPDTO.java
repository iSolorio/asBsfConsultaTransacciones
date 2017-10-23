package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class RpPersRlAcPDTO {
	@Getter
	@Setter
	private String COD_NRBE_EN; 
	@Getter
	@Setter
	private String ID_INTERNO_PE; 
	@Getter
	@Setter
	private String COD_RL_PERS_AC; 
	@Getter
	@Setter
	private String COD_CENT_UO; 
	@Getter
	@Setter
	private String NUM_SEC_AC; 
}
