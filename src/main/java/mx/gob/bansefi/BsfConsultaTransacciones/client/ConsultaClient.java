package mx.gob.bansefi.BsfConsultaTransacciones.client;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.ResponseBansefiDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.ReqConsultaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.ResConsultaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.Util.Util;


/*Componente encargado de realizar la consulta de transacciones*/
@Component
public class ConsultaClient {
	/*Inyeccion de dependencias*/
	@SuppressWarnings("rawtypes")
	@Autowired
	private Util util;
	@Value("${url.rootcontext}")
	private String urlRootContext;
	@Value("${url.consultaDatos}")
	private String urlConsultaDatos;
	
	String cadena="";
	public ResConsultaDTO consDatosGral(ReqConsultaDTO request) {
		ResConsultaDTO response = new ResConsultaDTO();
		try {
			String jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaDatos);
			String cadena = jsonRes;
			if (!jsonRes.equals("")) {
				ArrayList<String> nodos = new ArrayList<String>();
				nodos.add("EjecutarResponse");
				nodos.add("EjecutarResult");
				response = (ResConsultaDTO) this.util.jsonToObject(response, cadena, nodos);
				} else {
					response.setESTATUS("0");
					response.setMENSAJE("Ocurrio un error durante el parseo de la informacion.");
				}
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		System.out.println(cadena);
		
		//System.out.println(response.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getSTD_AUTORIZA_V().getAR_TRN_MSJ_PARM_V().get(0).get);
		return response;
		
	}
}
