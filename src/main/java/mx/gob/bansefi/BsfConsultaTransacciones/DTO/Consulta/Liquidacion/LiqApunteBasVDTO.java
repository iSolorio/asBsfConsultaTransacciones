package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class LiqApunteBasVDTO {
	@Getter
	@Setter
	private ArrayList<HlClaveAfVDTO> HL_CLAVE_AF_V; 
	@Getter
	@Setter
	private ImpSdoDTO IMP_FACTURADO_V;
	@Getter
	@Setter
	private ImpSdoDTO IMP_AJUSTADO_V;
	@Getter
	@Setter
	private ImpSdoDTO IMP_PENDIENTE_V;
	@Getter
	@Setter
	private ImpSdoDTO IMP_CONDONADO_V;
	@Getter
	@Setter
	private String COD_CTA; 
	@Getter
	@Setter
	private String IND_1; 
	@Getter
	@Setter
	private String IND_2; 
	@Getter
	@Setter
	private String IND_3; 
	@Getter
	@Setter
	private String IND_4; 
	@Getter
	@Setter
	private String IND_5; 
	@Getter
	@Setter
	private String IND_6; 
	@Getter
	@Setter
	private String IND_7; 
	@Getter
	@Setter
	private String IND_8; 
	@Getter
	@Setter
	private String IND_9; 
	@Getter
	@Setter
	private String IND_10; 
	@Getter
	@Setter
	private String COD_ORIGEN; 
}
