package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseBansefiDTO {
	@Getter
	@Setter
	private OtrLiqConsBasicaTrnODTO OTR_LIQ_CONS_BASICA_TRN_O;
}
