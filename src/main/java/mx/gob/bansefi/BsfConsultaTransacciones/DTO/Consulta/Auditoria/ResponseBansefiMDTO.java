package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseBansefiMDTO {
	@Getter
	@Setter
	private OtrCargarAuditTrnODTO OTR_CARGAR_AUDIT_TRN_O;
}
