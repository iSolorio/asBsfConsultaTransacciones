package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Cheque;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class TrCpConsultaDetalleEvDTO {
	@Getter
	@Setter
	private AcAcPDTO AC_AC_P;
	@Getter
	@Setter
	private PsvCccVDTO PSV_CCC_V;
	@Getter
	@Setter
	private CpAcuerdoCargoVDTO CP_ACUERDO_CARGO_V;
	@Getter
	@Setter
	private TlCaducidadVDTO TL_CADUCIDAD_V;
	@Getter
	@Setter
	private IdAcInstrumentalVDTO ID_AC_INSTRUMENTAL_V;
	@Getter
	@Setter
	private DescrPdvVDTO DESCR_PDV_V;
	@Getter
	@Setter
	private  CodPlzBancariaDTO COD_PLZ_BANCARIA;
	@Getter
	@Setter
	private IdAcInstrumentalVDTO PSV_PAGO_POSITIVO_V;
	@Getter
	@Setter
	private String DOMIC_50;
	@Getter
	@Setter
	private String NOMB_LOCALIDAD_AG;
	@Getter
	@Setter
	private String NOMB_50;
	@Getter
	@Setter
	private String COD_ID_CHEQ; 
	@Getter
	@Setter
	private String COD_CJ_CHQ_PG; 
	@Getter
	@Setter
	private String IND_DISPOS; 
	@Getter
	@Setter
	private String IMP_CHQ_PAG; 
	@Getter
	@Setter
	private String IMP_PDTE_CP; 
	@Getter
	@Setter
	private String IND_CHQ_PAG_CONF; 
	@Getter
	@Setter
	private String IND_PAGO_PARCIAL; 
	@Getter
	@Setter
	private String FECHA_ACTVCN_PAG;
	@Getter
	@Setter
	private String NUM_CHQ_PAG;
	@Getter
	@Setter
	private String ECV_ACTUAL;
	@Getter
	@Setter
	private String COD_INTERNO_UO_1;
	@Getter
	@Setter
	private String CONCEPTO_17; 
	@Getter
	@Setter
	private String CONCEPTO_18; 
	@Getter
	@Setter
	private String CONCEPTO_19; 
	@Getter
	@Setter
	private String CONCEPTO_2; 
	@Getter
	@Setter
	private String NUM_CHQ_PAG_CP; 
	@Getter
	@Setter
	private String NOMB_50_1;                                       
	@Getter
	@Setter
	private String CODIGO_SEGURIDAD; 
	@Getter
	@Setter
	private String IMP_CONTRAVALOR; 
	@Getter
	@Setter
	private String COD_NUMRCO_MONEDA1;
}
