package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class BpListaBloqueoVDTO {
	@Getter
	@Setter
	private BpBloqueoPrtcnEDTO BP_BLOQUEO_PRTCN_E;
	@Getter
	@Setter
	private String  FECHA_INIC_ECV; 
    @Getter
    @Setter
	private String FECHA_PLANIF; 
    @Getter
    @Setter
    private String ID_INTERNO_EMPL_EP; 
    @Getter
    @Setter
    private String COD_INTERNO_UO; 
    @Getter
    @Setter
    private String COD_ECV_BLQ_PRTCN;  
}
