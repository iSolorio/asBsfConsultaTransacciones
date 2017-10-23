package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class BpBloqueoPrtcnEDTO {
	@Getter
	@Setter
	private String 	COD_NRBE_EN;
	@Getter
	@Setter
    private String COD_CENT_UO; 
	@Getter
	@Setter
	private String NUM_SEC_AC; 
    @Getter
    @Setter
	private String  COD_BLOQUEO; 
    @Getter
    @Setter
    private String NUM_BLQ_PRTCN; 
    @Getter
    @Setter
    private String MOTIVO_BLQ_PRTCN; 
    @Getter
    @Setter
    private String MOTIVO_CANC_ANTIC;
}
