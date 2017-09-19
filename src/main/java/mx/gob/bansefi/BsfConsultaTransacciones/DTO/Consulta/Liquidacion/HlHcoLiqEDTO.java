package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class HlHcoLiqEDTO {
	@Getter
	@Setter
	private String COD_NRBE_EN; 
	@Getter
	@Setter
	private String COD_CENT_UO; 
	@Getter
	@Setter
	private String NUM_SEC_AC; 
	@Getter
	@Setter
	private String FECHA_LIQ; 
	@Getter
	@Setter
	private String NUM_SEC; 
	@Getter
	@Setter
	private String FECHA_DESDE; 
	@Getter
	@Setter
	private String FECHA_HASTA; 
	@Getter
	@Setter
	private String IMP_PEND_LIQ; 
	@Getter
	@Setter
	private String IMP_TOTAL_LIQ; 
	@Getter
	@Setter
	private String SITUACION_HL; 
	@Getter
	@Setter
	private String FECHA_ULT_COBRO; 
	@Getter
	@Setter
	private String FEC_ULT_CALC_DMRA; 
	@Getter
	@Setter
	private String SGN; 
	@Getter
	@Setter
	private String IND_COB_PAR; 
	@Getter
	@Setter
	private String IND_DEVENGO; 
	@Getter
	@Setter
	private String IND_COMP_DIAS; 
	@Getter
	@Setter
	private String IND_BASE_CALC; 
	@Getter
	@Setter
	private String IND_SIT_COM; 
	@Getter
	@Setter
	private String COD_LINEA; 
	@Getter
	@Setter
	private String ID_GRP_PD; 
	@Getter
	@Setter
	private String COD_OPER_LIQ; 
	@Getter
	@Setter
	private String COD_DOC_FNCRO; 
	@Getter
	@Setter
	private String NUM_SEC_DF; 
	@Getter
	@Setter
	private String COD_BLOQUEO; 
	@Getter
	@Setter
	private String COD_NUMRCO_MONEDA;
}
