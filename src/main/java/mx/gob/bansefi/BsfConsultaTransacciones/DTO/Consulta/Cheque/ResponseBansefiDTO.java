package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Cheque;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseBansefiDTO {
	@Getter
	@Setter
	private OtrCpConsultaDetalleTDTO OTR_CP_CONSULTA_DETALLE_T;
}
