package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class TrTxConsAuditvtZDTO {
	@Getter
	@Setter
	private ArrayList<AfAuditEDTO> AF_AUDIT_E;
	@Getter
	@Setter
	private ArrayList<FtAuditVDTO> FT_AUDIT_V;
	@Getter
	@Setter
	private ArrayList<TpTblAuditEDTO> TP_TBL_AUDIT_E;
	@Getter
	@Setter
	private ArrayList<HlAuditEDTO> HL_AUDIT_E;
}
