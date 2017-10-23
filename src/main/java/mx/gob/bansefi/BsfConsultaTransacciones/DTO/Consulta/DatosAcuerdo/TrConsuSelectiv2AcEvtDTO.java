package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class TrConsuSelectiv2AcEvtDTO {
	@Getter
	@Setter
	private AcAcEDTO AC_AC_E;
	@Getter
	@Setter
	private NumSubacVDTO NUM_SUBAC_V;
	@Getter
	@Setter
	private DatosPerVDTO DATOS_PER_V; 
	@Getter
	@Setter
	private RxAcRlAcPDTO RX_AC_RL_AC_P;
	@Getter
	@Setter
	private RpPersRlAcPDTO RP_PERS_RL_AC_P;
	@Getter
	@Setter
	private NombPdvVDTO NOMB_PDV_V;
	@Getter
	@Setter
	private NombTrfaPvdVDTO NOMB_TRFA_PDV_V;
}
