package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class TrConsultaGlobalRtEvtDTO {
	@Getter
	@Setter
	private  CodInternoUoDTO COD_INTERNO_UO_V;
	@Getter
	@Setter
	private ArrayList<TrAfConsEvtVDTO> TR_AF_CONS_EVT_V;
	@Getter
	@Setter
	private String NOMB_50;
	@Getter
	@Setter
	private ArrayList<FechaOprcnDTO> RT_F_VTO_V; 
	@Getter
	@Setter
	private CodNumrcoMonedaDTO PSV_COD_NUMRCO_MONEDA_V;
	@Getter
	@Setter
	private ArrayList<StdChar50DTO> ID_ORGN_APNTE_V;
}
