package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class HlSdoEVDTO {
	@Getter
	@Setter
	private String COD_CTA; 
	@Getter
	@Setter
	private String COD_SDO; 
	@Getter
	@Setter
	private String IND_SALDO; 
	@Getter
	@Setter
	private String IMP_SDO_HL;  
}
