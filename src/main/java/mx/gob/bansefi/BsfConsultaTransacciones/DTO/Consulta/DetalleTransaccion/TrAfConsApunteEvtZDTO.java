package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
public class TrAfConsApunteEvtZDTO {
	@Getter
	@Setter
	private String NOMB_50;
	@Getter
	@Setter
	private AfApnteEDTO AF_APNTE_E;
	@Getter
	@Setter
	private DescrPdvVDTO DESCR_PDV_V;
	@Getter
	@Setter
	private IdfrAcLVDTO IDFR_AC_L_V;
	
}
