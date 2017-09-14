package mx.gob.bansefi.BsfConsultaTransacciones.DTO.ConsultaNombre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseBansefiDTO {
	@Getter
	@Setter
	private OtrPeClCbDaCnsTrnODTO OTR_PE_CL_CB_DA_CNS_TRN_O;
}
