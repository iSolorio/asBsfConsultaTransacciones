package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class AnAntcnEDTO {
	@Getter
	@Setter
	private String COD_NRBE_EN; 
	@Getter
	@Setter
	private String COD_ANTCN; 
	@Getter
	@Setter
	private String SUBCD_ANTCN; 
	@Getter
	@Setter
	private String NUMERO_ANTCN; 
	@Getter
	@Setter
	private String TXT_LARGA_LEN; 
	@Getter
	@Setter
	private String TXT_LARGA; 
	@Getter
	@Setter
	private String TXT_BREVE; 
	@Getter
	@Setter
	private String COD_GRP_ANTCN; 
	@Getter
	@Setter
	private String DSTN_ANTCN; 
	@Getter
	@Setter
	private String FECHA_ULT_MODIF; 
	@Getter
	@Setter
	private String FECHA_INICIO; 
	@Getter
	@Setter
	private String FECHA_CRRE; 
	@Getter
	@Setter
	private String IND_CONF; 
	@Getter
	@Setter
	private String IND_PRDAD; 
	@Getter
	@Setter
	private String IND_RESP_ANTCN; 
	@Getter
	@Setter
	private String IND_CONFIDENCIAL; 
	@Getter
	@Setter
	private String IND_CONTESTADA; 
	@Getter
	@Setter
	private String COD_ECV_ANTCN; 
	@Getter
	@Setter
	private String COD_APLCCN_SUBAPL; 
	@Getter
	@Setter
	private String ID_INTERNO_EMPL_EP; 
}
