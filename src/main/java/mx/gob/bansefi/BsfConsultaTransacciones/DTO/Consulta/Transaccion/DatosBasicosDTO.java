package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Transaccion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
/*DTO de los datos que vienen  en arreglo de datos*/
public class DatosBasicosDTO {
	@Getter @Setter
	private FechaDatosBasicosDTO PSV_F_OPERACION_V;
	@Getter @Setter
	private String COD_ORIGEN;
	@Getter @Setter
	private String FECHA_VALOR;
	@Getter @Setter
	private String IMP_APNTE;
	@Getter @Setter
	private String SGN;
	@Getter @Setter
	private String IND_1;
	@Getter @Setter
	private String IND_2;
	@Getter @Setter
	private String IND_3;
	@Getter @Setter
	private String NUM_SEC;
	@Getter @Setter
	private String NUM_SUBAC;
	@Getter @Setter
	private String IMP_SDO;
	@Getter @Setter
	private String ID_INTERNO_TERM_TN;
	@Getter @Setter
	private String TXT_TIPO_CLOP_BREV_LEN;
	@Getter @Setter
	private String TXT_TIPO_CLOP_BREV;
	@Getter @Setter
	private String TXT_TIPO_CLOP_LARG_LEN;
	@Getter @Setter
	private String TXT_TIPO_CLOP_LARG;
	@Getter @Setter
	private String COD_INTERNO_UO;
	@Getter @Setter
	private String COD_CTA;
	@Getter @Setter
	private String PRPDAD_CTA;
	@Getter @Setter
	private String ID_EXP_RECLAM;
	@Getter @Setter
	private String COD_ORGN_APNTE;
	@Getter @Setter
	private String ID_ORGN_APNTE;
	@Getter @Setter
	private String FECHA_CTBLE;
	@Getter @Setter
	private String COD_NUMRCO_MONEDA1;
}
