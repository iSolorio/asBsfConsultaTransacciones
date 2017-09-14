package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class TrAfConsEvtVDTO {
	@Getter
	@Setter
	private String IMP_SDO;
	@Getter
	@Setter
	private AfApnteEDTO AF_APNTE_E;
	@Getter
	@Setter
	private AfAuditEDTO AF_AUDIT_E;
}
