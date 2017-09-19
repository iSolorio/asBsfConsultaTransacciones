package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class TrLiqConsBasicaEvtZDTO {
	@Getter
	@Setter
	private String RTRN_CD;
	@Getter
	@Setter
	private String OCCURS_NR;
	@Getter
	@Setter
	private HlHcoLiqEDTO HL_HCO_LIQ_E;
	@Getter
	@Setter
	private HlSdoLstDTO HL_SDO_LST;
	@Getter
	@Setter
	private HlInfAdicLtsDTO HL_INF_ADIC_LST;
	@Getter
	@Setter
	private ConsBasicaVDOT CONS_BASICA_V;
	@Getter
	@Setter
	private LiqApunteBasLstDTO LIQ_APUNTE_BAS_LST;
	@Getter
	@Setter
	private LiqConsDemoraVdto LIQ_CONS_DEMORA_V;
	@Getter
	@Setter
	private LiqImposLstDTO LIQ_IMPOS_LST;
}
