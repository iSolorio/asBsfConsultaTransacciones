package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
/*Todos los marcados con una S en comentario son beans de un dato generados por que asi los regresa el json de respuesta,
 *  es decir, para futuras revisiones se pueden omitir esos dto*/
public class ConsultaApuntesDTO {
	@Getter @Setter
	private String NOMB_50;
	@Getter @Setter
	private String COD_NUMRCO_MONEDA;
	@Getter @Setter
	private NomPdvDTO DESCR_PDV_V;/*S*/
	@Getter @Setter
	private CodCsbOfDTO COD_CSB_OF_V;/*S*/
	@Getter @Setter
	private ArrayList<DatosBasicosDTO> TR_CONSULTA_APNTES_PSV_EV;
	@Getter @Setter
	private CodInternoUoDTO COD_INTERNO_UO_V;/*S*/
	@Getter @Setter
	private String IMP_CMSN;
	@Getter @Setter
	private ImpAutDTO PSV_IMP_AUT_V;/*S*/
	@Getter @Setter
	private ImpSdoDTO PSV_SDO_DISP_V;
	@Getter @Setter
	private ArrayList<PsvErrorVDTO> PSV_ERROR_V;/*Aqui vienen los errores*/
	@Getter @Setter
	private String VALOR_BASE;
	@Getter @Setter
	private String ID_INTERNO_PE;
}
