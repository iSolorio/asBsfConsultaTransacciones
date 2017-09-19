package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseBansefiADTO {
	@Getter
	@Setter
	private OtrTxConsAuditTrnODTO OTR_TX_CONS_AUDIT_TRN_O;
}
