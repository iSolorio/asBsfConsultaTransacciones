package mx.gob.bansefi.BsfConsultaTransacciones.client;

import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.ConsultaMovimientoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.ResponseBansefiDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos.ConsultaBloqueoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos.ListaConsultaBloqueosDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos.ReqConsultaBloqueoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos.ResConsultaBloqueosDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo.ConsultaDatosAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo.ReqConsultaDatosAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo.ResConsultaDatosAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo.TrConsuSelectiv2AcEvtDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion.ConsultaDetalleApunteDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion.ReqConsultaDetalleTransaccionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion.ResConsultaDetalleTransaccionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones.ConsultaRetencionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones.ListaConsultaRetencionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones.ReqConsultaRetencionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones.ResConsultaRetencionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.ConsultaNombre.ConsultaNombreDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.ReqConsultaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.RequestConsultaNombreDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.ResConsultaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResConsultaMovimientoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResConsultaNombreDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResErrorDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResGralDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.Util.Util;


/*Componente encargado de realizar la consulta de transacciones*/
@SuppressWarnings("unused")
@Component
public class ConsultaClient {
	/*Inyeccion de dependencias*/
	@SuppressWarnings("rawtypes")
	@Autowired
	private Util util;
	@Value("${url.rootcontext}")
	private String urlRootContext;
	@Value("${url.consultaTransaccion}")
	private String urlConsultaTransaccion;
	@Value("${url.consultaDetalleTransaccion}")
	private String urlConsultaDetalleTransaccion;
	@Value("${url.consultaNombre}")
	private String urlConsultaNombre;
	@Value("${url.consultaDatosAcuerdo}")
	private String urlConsultaDatosAcuerdo;
	@Value("${url.consultaRetenciones}")
	private String urlConsultaRetenciones;
	@Value("${url.consultaBloqueos}")
	private String urlConsultaBloqueos;
	@Value("${error.parseo}")
	private String errorParseo;
	@Value("${error.usuario}")
	private String errorUsuario;
	@Value("${error.general}")
	private String errorGeneral;
	@Value("${error.noRequest}")
	private String errornoRequest;
	@Value("${error.noFirmado}")
	private String errornoFirmado;
	@Value("${status.correcto}")
	private String statusCorrecto;
	@Value("${status.incorrecto}")
	private String statusIncorrecto;
	
	
	String cadena="";
	/*Consulta de transacciones*/
	@SuppressWarnings({ "unchecked", "null" })
	public ResConsultaMovimientoDTO consDatosGral(ReqConsultaDTO request) {
		ResConsultaDTO datos = new ResConsultaDTO();
		ArrayList<ConsultaMovimientoDTO> transacciones= new ArrayList<ConsultaMovimientoDTO>();
		ResGralDTO cabecera= new ResGralDTO();
		ResConsultaMovimientoDTO respuesta= new ResConsultaMovimientoDTO();
		request.setAcceso(request.getAcceso()==null?"":request.getAcceso());
		request.setAcuerdo(request.getAcuerdo()==null?"":request.getAcuerdo());
		request.setEntidad(request.getEntidad()==null?"":request.getEntidad());
		request.setFechadesde(request.getFechadesde()==null?"":request.getFechadesde());
		request.setFechahasta(request.getFechahasta()==null?"":request.getFechahasta());
		request.setFormato(request.getFormato()==null?"":request.getFormato());
		request.setImpsdo(request.getImpsdo()==null?"":request.getImpsdo());
		request.setNumsec(request.getNumsec()==null?"":request.getNumsec());
		request.setPassword(request.getPassword()==null?"":request.getPassword());
		request.setTerminal(request.getTerminal()==null?"":request.getTerminal());
		request.setUsuario(request.getUsuario()==null?"":request.getUsuario());
		if(request.getAcceso().equals("") || request.getAcuerdo().equals("") || request.getEntidad().equals("") || request.getFechadesde().equals("") || request.getFechahasta().equals("") || request.getFormato().equals("") || request.getImpsdo().equals("") || request.getNumsec().equals("") || request.getPassword().equals("") || request.getTerminal().equals("") || request.getUsuario().equals(""))
		{
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral+errornoRequest);
		    respuesta.setCabecera(cabecera);
		    return respuesta;
		}
		else
		{
			try {
				String jsonRes = this.util.callRestPost(request, urlRootContext +urlConsultaTransaccion);
				String cadena = jsonRes;
				if (!jsonRes.equals(""))
				{
					ArrayList<String> nodos = new ArrayList<String>();
					nodos.add("EjecutarResponse");
					nodos.add("EjecutarResult");
					datos = (ResConsultaDTO) this.util.jsonToObject(datos, cadena, nodos);
					if(datos.getTRANID().equals(errornoFirmado))
					{
						cabecera.setMensaje(errorGeneral+errorUsuario);
						cabecera.setStatus(statusIncorrecto);
						respuesta.setCabecera(cabecera);
					}
					else
					{
						if(Integer.valueOf(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getNUMBER_OF_RECORDS())!=0)
						{
							System.out.println(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getNUMBER_OF_RECORDS());
							for(int i=0;i<Integer.valueOf(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getNUMBER_OF_RECORDS());i++)
							{
								ConsultaMovimientoDTO res= new ConsultaMovimientoDTO();
								res.setFechaOperacion(util.formatearFechaGeneral("dd-MM-yyyy",datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i).getPSV_F_OPERACION_V().getFECHA_OPRCN()));
								res.setSaldo(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i).getIMP_SDO());
								res.setImporte(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i).getIMP_APNTE());
								res.setConcepto(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i).getTXT_TIPO_CLOP_LARG());
								res.setFechaValor(util.formatearFechaGeneral("MM-dd-yyyy",datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i).getFECHA_VALOR()));
								System.out.println(res.getFechaValor());
								res.setOfiTerminal(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i).getID_INTERNO_TERM_TN());
								res.setSigno(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i).getSGN());
								res.setCodigoError(String.valueOf(i));
								res.setDescripcionError(statusCorrecto);
								res.setDetalle(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i).getNUM_SEC());
								res.setCodcuenta(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i).getCOD_CTA());
								res.setCodapunte(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i).getCOD_ORGN_APNTE());
								res.setCodorigen(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i).getCOD_ORIGEN());
								transacciones.add(res);
							}
							cabecera.setMensaje(datos.getMENSAJE());
							cabecera.setStatus(datos.getESTATUS());
							respuesta.setCantidad(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getNUMBER_OF_RECORDS());
							respuesta.setCabecera(cabecera);
							respuesta.setLista(transacciones);
						}
						else
						{
	
							
								
						
								ArrayList<ResErrorDTO> lista= new ArrayList<ResErrorDTO>();
									for(int i=0;i<datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getSTD_TRN_MSJ_PARM_V().size();i++)
									{
										ResErrorDTO errores=new ResErrorDTO();
										errores.setCodigo(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
										errores.setMensaje(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
										lista.add(errores);
									}
									cabecera.setErrores(lista);
									cabecera.setMensaje(errorGeneral+datos.getMENSAJE());
									cabecera.setStatus(datos.getCODIGO());
							
									respuesta.setLista(transacciones);
							
						}
					} 
				}
				else {
					cabecera.setMensaje(errorParseo);
					cabecera.setStatus(statusIncorrecto);
					respuesta.setCabecera(cabecera);
					
					
				}
				
				
			
		
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
			e.printStackTrace();
			cabecera.setMensaje(errorParseo+e.getMessage());
			respuesta.setCabecera(cabecera);
		}
			
		System.out.println(cadena);
		return respuesta;
		}
		
	}
	
	/*Consulta detalles de una transaccion*/
	@SuppressWarnings("unchecked")
	public ResConsultaDetalleTransaccionDTO consultaDetalletransaccion(ReqConsultaDetalleTransaccionDTO request)
	{
		ResConsultaDetalleTransaccionDTO response= new ResConsultaDetalleTransaccionDTO();
		ResGralDTO cabecera= new ResGralDTO();
		ConsultaDetalleApunteDTO datos= new ConsultaDetalleApunteDTO();
		request.setAcuerdo(request.getAcuerdo()==null?"":request.getAcuerdo());
	    request.setCodapunte(request.getCodapunte()==null?"":request.getCodapunte());
	    request.setCodcuenta(request.getCodcuenta()==null?"":request.getCodcuenta());
	    request.setCodorigen(request.getCodorigen()==null?"":request.getCodorigen());
	    request.setDetalle(request.getDetalle()==null?"":request.getDetalle());
		request.setEntidad(request.getEntidad()==null?"":request.getEntidad());
		request.setFecha(request.getFecha()==null?"":request.getFecha());
		request.setImporte(request.getImporte()==null?"":request.getImporte());
		request.setSigno(request.getSigno()==null?"":request.getSigno());
		request.setPassword(request.getPassword()==null?"":request.getPassword());
		request.setTerminal(request.getTerminal()==null?"":request.getTerminal());
		request.setUsuario(request.getUsuario()==null?"":request.getUsuario());
		if(request.getAcuerdo().equals("") || request.getCodapunte().equals("") || request.getCodcuenta().equals("") || request.getCodorigen().equals("") || request.getDetalle().equals("") || request.getEntidad().equals("") || request.getFecha().equals("") || request.getImporte().equals("") || request.getPassword().equals("") || request.getSigno().equals("") || request.getTerminal().equals("") || request.getUsuario().equals(""))
		{
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral+errornoRequest);
		    response.setCabecera(cabecera);
		    return response;
		}
		else
		{
			try {
				System.out.println(urlRootContext +urlConsultaDetalleTransaccion);
				String jsonRes = this.util.callRestPost(request, urlRootContext +urlConsultaDetalleTransaccion);
				System.out.println(jsonRes);
				if (!jsonRes.equals("")) {
					ArrayList<String> nodos = new ArrayList<String>();
					nodos.add("EjecutarResponse");
					nodos.add("EjecutarResult");
					datos = (ConsultaDetalleApunteDTO) this.util.jsonToObject(datos, jsonRes, nodos);
					if(datos.getTRANID().equals(errornoFirmado))
					{
						cabecera.setMensaje(errorGeneral+errorUsuario);
						cabecera.setStatus(statusIncorrecto);
						response.setCabecera(cabecera);
					}
					else
					{
						if(datos.getESTATUS().equals(statusCorrecto))
						{
							response.setConcepto(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getCONCPT_APNTE());
							response.setEstado(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getPRPDAD_CTA());
							response.setFechaContable(util.formatearFechaGeneral("dd-MM-yyyy",datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getFECHA_CTBLE()));
							response.setFechaValor(util.formatearFechaGeneral("dd-MM-yyyy",datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getFECHA_VALOR()));
							response.setImporte(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIMP_APNTE());
							response.setIndicador1(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1()==null?"":datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1());
							response.setIndicador2(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1()==null?"":datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_2());
							response.setIndicador3(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1()==null?"":datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_3());
							response.setIndicador4(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1()==null?"":datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_4());
							response.setIndicador5(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1()==null?"":datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_5());
							response.setIndicador6(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1()==null?"":datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_6());
							response.setIndicador7(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1()==null?"":datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_7());
							response.setIndicador8(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1()==null?"":datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_8());
							response.setIndicador9(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1()==null?"":datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_9());
							response.setIndicador10(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1()==null?"":datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_10());
							response.setMoneda(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getCOD_NUMRCO_MONEDA());
							response.setNombre(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getNOMB_50());
							response.setNumero(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getNUM_SEC());
							response.setProducto(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getDESCR_PDV_V().getNOMB_PDV());
							response.setTipoOperacion(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getCOD_ORIGEN());
							response.setTipoDescripcion("");
						}
						else
						{
							
								ArrayList<ResErrorDTO> lista= new ArrayList<ResErrorDTO>();
								for(int i=0;i<datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getSTD_TRN_MSJ_PARM_V().size();i++)
								{
									ResErrorDTO errores=new ResErrorDTO();
									errores.setCodigo(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
									errores.setMensaje(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
									lista.add(errores);
								}
								cabecera.setErrores(lista);
								cabecera.setMensaje(errorGeneral+datos.getMENSAJE());
								cabecera.setStatus(datos.getCODIGO());
								response.setCabecera(cabecera);
							}
						}
					}
					else
					{
						cabecera.setStatus(statusIncorrecto);
						cabecera.setMensaje(errorGeneral+errornoRequest);
						response.setCabecera(cabecera);
					}
				} catch (Exception e) {
					e.printStackTrace();
					e.printStackTrace();
					cabecera.setMensaje(errorParseo+e.getMessage());
					response.setCabecera(cabecera);
				}
		}
		
		return response;
	}
	/*Consulta minima para obtener el nombre*/
	@SuppressWarnings("unchecked")
	public ResConsultaNombreDTO consultaNombre(RequestConsultaNombreDTO request)
	{
		@SuppressWarnings("unused")
		ConsultaNombreDTO datos= new ConsultaNombreDTO();
		ResConsultaNombreDTO response= new ResConsultaNombreDTO();
		ResGralDTO cabecera=new ResGralDTO();
		String jsonRes="";
		request.setEntidad(request.getEntidad()==null?"":request.getEntidad());
		request.setIdInternoPe(request.getIdInternoPe()==null?"":request.getIdInternoPe());
		request.setPassword(request.getPassword()==null?"":request.getPassword());
		request.setTerminal(request.getTerminal()==null?"":request.getTerminal());
		request.setUsuario(request.getUsuario()==null?"":request.getUsuario());
		if(request.getEntidad().equals("") || request.getIdInternoPe().equals("") || request.getPassword().equals("") || request.getTerminal().equals("") || request.getUsuario().equals(""))
		{
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral+errornoRequest);
		    response.setCabecera(cabecera);
		}else
		{
			jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaNombre);
			System.out.println(jsonRes);
			if(!jsonRes.equals(""))
				{
						ArrayList<String> nodos = new ArrayList<String>();
						nodos.add("EjecutarResponse");
						nodos.add("EjecutarResult");	
						try {
							datos = (ConsultaNombreDTO) this.util.jsonToObject(datos, jsonRes, nodos);
							if(datos.getTRANID().equals(errornoFirmado))
							{
								cabecera.setMensaje(errorGeneral+errorUsuario);
								cabecera.setStatus(statusIncorrecto);
								response.setCabecera(cabecera);
							}
							else
							{
								if(datos.getESTATUS().equals(statusCorrecto))
								{
									response.setIdExt(datos.getResponseBansefi().getOTR_PE_CL_CB_DA_CNS_TRN_O().getTR_PE_CL_CB_DA_CNS_EVT_Z().getID_EXT_PE());
									response.setIdInternoPe(datos.getResponseBansefi().getOTR_PE_CL_CB_DA_CNS_TRN_O().getTR_PE_CL_CB_DA_CNS_EVT_Z().getID_INTERNO_PE());
									response.setNombre(datos.getResponseBansefi().getOTR_PE_CL_CB_DA_CNS_TRN_O().getTR_PE_CL_CB_DA_CNS_EVT_Z().getNOMB_50());
									cabecera.setStatus(datos.getESTATUS());
									cabecera.setMensaje(datos.getMENSAJE());
									response.setCabecera(cabecera);
								}
								else
								{
									
									
	
										ArrayList<ResErrorDTO> lista= new ArrayList<ResErrorDTO>();
										for(int i=0;i<datos.getResponseBansefi().getOTR_PE_CL_CB_DA_CNS_TRN_O().getSTD_TRN_MSJ_PARM_V().size();i++)
										{
											ResErrorDTO errores=new ResErrorDTO();
											errores.setCodigo(datos.getResponseBansefi().getOTR_PE_CL_CB_DA_CNS_TRN_O().getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
											errores.setMensaje(datos.getResponseBansefi().getOTR_PE_CL_CB_DA_CNS_TRN_O().getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
											lista.add(errores);
										}
										cabecera.setErrores(lista);
										cabecera.setMensaje(errorGeneral+datos.getMENSAJE());
										cabecera.setStatus(datos.getCODIGO());
										response.setCabecera(cabecera);
									
								}
							}
						} catch (ParseException e) {
							e.printStackTrace();
							cabecera.setMensaje(errorParseo+e.getMessage());
							response.setCabecera(cabecera);
						}
				}
			else
			{
				cabecera.setStatus(statusIncorrecto);
				cabecera.setMensaje(errorGeneral+errornoRequest);
				response.setCabecera(cabecera);
			}
		}
		return response;
	}
	/*Consulta para obtener el nombre a traves del acuerdo*/
	@SuppressWarnings("unchecked")
	public ResConsultaDatosAcuerdoDTO consultaDatosAcuerdo(ReqConsultaDatosAcuerdoDTO request)
	{
		ResConsultaDatosAcuerdoDTO response= new ResConsultaDatosAcuerdoDTO();
		ResGralDTO cabecera= new ResGralDTO();
		ConsultaDatosAcuerdoDTO DATOS_PER_V= new ConsultaDatosAcuerdoDTO();
		String jsonRes;
		request.setEntidad(request.getEntidad()==null?"":request.getEntidad());
		request.setAcuerdo(request.getAcuerdo()==null?"":request.getAcuerdo());
		request.setPassword(request.getPassword()==null?"":request.getPassword());
		request.setTerminal(request.getTerminal()==null?"":request.getTerminal());
		request.setUsuario(request.getUsuario()==null?"":request.getUsuario());
		
		if(request.getEntidad().equals("") || request.getAcuerdo().equals("") || request.getPassword().equals("") || request.getTerminal().equals("") || request.getUsuario().equals(""))
		{
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral+errornoRequest);
		    response.setCabecera(cabecera);
		}else
		{
			jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaDatosAcuerdo);
			System.out.println(jsonRes);
			
			if(!jsonRes.equals(""))
			{
					ArrayList<String> nodos = new ArrayList<String>();
					nodos.add("EjecutarResponse");
					nodos.add("EjecutarResult");
					nodos.add("ResponseBansefi");
					nodos.add("OTR_CONSU_SELECTIV2_AC_TR");
					try {
						String res=null;
						String estado="";
						String estado2="";
						estado= jsonRes.substring(65,66);
						estado2=jsonRes.substring(69,70);
						System.out.println("ESte es el res:"+estado+"otro estado"+estado2);
						if(estado.equals(statusIncorrecto) || estado2.equals(statusIncorrecto))
						{
							System.out.println("ESte es el res:"+estado);
							cabecera.setMensaje(errorGeneral+errornoRequest);
							cabecera.setStatus(statusIncorrecto);
							response.setCabecera(cabecera);
						}
						else
						{
							res = (String) this.util.jsonToString(res, jsonRes, nodos); 
							System.out.println("ESte es el res:"+estado);
							String nombre= res.substring(144, 194);
							System.out.println("Este es el nombre:"+nombre);
							cabecera.setStatus(statusCorrecto);
							response.setCabecera(cabecera);
							response.setNombre(nombre);
						}
					}
					 catch (ParseException e) {
						e.printStackTrace();
						cabecera.setMensaje(errorParseo+e.getMessage());
						cabecera.setStatus(statusIncorrecto);
						response.setCabecera(cabecera);
					}
			}
			else
			{
				cabecera.setStatus(statusIncorrecto);
				cabecera.setMensaje(errorGeneral+errornoRequest);
				response.setCabecera(cabecera);
			}
		}
		
		return response;
	}	
	/*Consulta las retenciones de un acuerdo*/
	@SuppressWarnings("unchecked")
	public ResConsultaRetencionesDTO consultaRetenciones(ReqConsultaRetencionDTO request)
	{
		ResConsultaRetencionesDTO response= new ResConsultaRetencionesDTO();
		ConsultaRetencionDTO datos= new ConsultaRetencionDTO();
		ResGralDTO cabecera= new ResGralDTO();
		String jsonRes;
		
		request.setEntidad(request.getEntidad()==null?"":request.getEntidad());
		request.setAcuerdo(request.getAcuerdo()==null?"":request.getAcuerdo());
		request.setPassword(request.getPassword()==null?"":request.getPassword());
		request.setTerminal(request.getTerminal()==null?"":request.getTerminal());
		request.setUsuario(request.getUsuario()==null?"":request.getUsuario());
		request.setEstado(request.getEstado()==null?"":request.getEstado());
		if(request.getEntidad().equals("") || request.getAcuerdo().equals("") || request.getPassword().equals("") || request.getTerminal().equals("") || request.getUsuario().equals(""))
		{
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral+errornoRequest);
		    response.setCabecera(cabecera);
		}else
		{
			jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaRetenciones);
			System.out.println(jsonRes);
			
			if(!jsonRes.equals(""))
			{
				ArrayList<String> nodos = new ArrayList<String>();
				nodos.add("EjecutarResponse");
				nodos.add("EjecutarResult");
				try {
					
					datos = (ConsultaRetencionDTO) this.util.jsonToObject(datos, jsonRes, nodos);
					if(datos.getTRANID().equals(errornoFirmado))
					{
						cabecera.setMensaje(errorGeneral+errorUsuario);
						cabecera.setStatus(statusIncorrecto);
						response.setCabecera(cabecera);
					}
					else
					{
						if(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getNUMBER_OF_RECORDS().equals("0000"))
						{
							ArrayList<ResErrorDTO> lista= new ArrayList<ResErrorDTO>();
							for(int i=0;i<datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getSTD_TRN_MSJ_PARM_V().size();i++)
							{
								ResErrorDTO errores=new ResErrorDTO();
								errores.setCodigo(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
								errores.setMensaje(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
								lista.add(errores);
							}
							cabecera.setErrores(lista);
							cabecera.setMensaje(errorGeneral+datos.getMENSAJE());
							cabecera.setStatus(datos.getCODIGO());
							response.setCabecera(cabecera);
						}
						else
						{
							
	
								ArrayList<ListaConsultaRetencionesDTO> retenciones= new ArrayList<ListaConsultaRetencionesDTO>();
								for(int i=0;i<Integer.valueOf(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getNUMBER_OF_RECORDS());i++)
								{
									ListaConsultaRetencionesDTO nodo = new ListaConsultaRetencionesDTO();
									nodo.setTipo(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getAF_APNTE_E().getCOD_LINEA());	
									nodo.setConcepto(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getAF_APNTE_E().getCONCPT_APNTE());
									nodo.setEmpleado(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getAF_AUDIT_E().getID_EMPL_AUT());
									nodo.setEstado(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getAF_AUDIT_E().getPRPDAD_CTA());
									nodo.setFechaAlta(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getAF_APNTE_E().getFECHA_VALOR());
									nodo.setFechaVTO("");
									nodo.setImporte(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getIMP_SDO());;
									nodo.setOrigen(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getAF_APNTE_E().getID_ORGN_APNTE());
									retenciones.add(nodo);
								}
								cabecera.setMensaje(datos.getMENSAJE());
								cabecera.setStatus(datos.getCODIGO());
								response.setCabecera(cabecera);
								response.setRetenciones(retenciones);
							
						}
					}
				}
				catch (ParseException e) {
					e.printStackTrace();
					cabecera.setMensaje(errorParseo+e.getMessage());
					cabecera.setStatus(statusIncorrecto);
					response.setCabecera(cabecera);
				}
		}
		else
		{
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral+errornoRequest);
			response.setCabecera(cabecera);
		}
			
		}
		return response;
	}
	/*Consulta los bloqueos de un acuerdo*/
	@SuppressWarnings("unchecked")
	public ResConsultaBloqueosDTO consultaBloqueos(ReqConsultaBloqueoDTO request)
	{
		ResConsultaBloqueosDTO response= new ResConsultaBloqueosDTO();
		ResGralDTO cabecera= new ResGralDTO();
		ConsultaBloqueoDTO datos= new ConsultaBloqueoDTO();
		String jsonRes;
		
		request.setEntidad(request.getEntidad()==null?"":request.getEntidad());
		request.setAcuerdo(request.getAcuerdo()==null?"":request.getAcuerdo());
		request.setPassword(request.getPassword()==null?"":request.getPassword());
		request.setTerminal(request.getTerminal()==null?"":request.getTerminal());
		request.setUsuario(request.getUsuario()==null?"":request.getUsuario());
		if(request.getEntidad().equals("") || request.getAcuerdo().equals("") || request.getPassword().equals("") || request.getTerminal().equals("") || request.getUsuario().equals(""))
		{
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral+errornoRequest);
		    response.setCabecera(cabecera);
		}else
		{
			jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaBloqueos);
			System.out.println(jsonRes);
			
			if(!jsonRes.equals(""))
			{
				ArrayList<String> nodos = new ArrayList<String>();
				nodos.add("EjecutarResponse");
				nodos.add("EjecutarResult");
				try {
					datos = (ConsultaBloqueoDTO) this.util.jsonToObject(datos, jsonRes, nodos);
					if(datos.getTRANID().equals(errornoFirmado))
					{
						cabecera.setMensaje(errorGeneral+errorUsuario);
						cabecera.setStatus(statusIncorrecto);
						response.setCabecera(cabecera);
					}
					else
					{
						System.out.println(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(0).getBP_BLOQUEO_PRTCN_E().getNUM_SEC_AC());
						if(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getNUMBER_OF_RECORDS().equals("0000"))
						{
							ArrayList<ResErrorDTO> lista= new ArrayList<ResErrorDTO>();
							for(int i=0;i<datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getSTD_TRN_MSJ_PARM_V().size();i++)
							{
								ResErrorDTO errores=new ResErrorDTO();
								errores.setCodigo(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
								errores.setMensaje(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
								lista.add(errores);
							}
							cabecera.setErrores(lista);
							cabecera.setMensaje(errorGeneral+datos.getMENSAJE());
							cabecera.setStatus(datos.getCODIGO());
							response.setCabecera(cabecera);
						}
						else
						{
							
								ArrayList<ListaConsultaBloqueosDTO> bloqueos= new ArrayList<ListaConsultaBloqueosDTO>();
								for(int i=0;i<Integer.valueOf(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getNUMBER_OF_RECORDS());i++)
								{
									ListaConsultaBloqueosDTO nodo = new ListaConsultaBloqueosDTO();
									nodo.setCentro(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i).getBP_BLOQUEO_PRTCN_E().getCOD_CENT_UO());
									nodo.setConcepto(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i).getBP_BLOQUEO_PRTCN_E().getMOTIVO_BLQ_PRTCN());
									nodo.setEmpleado(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i).getID_INTERNO_EMPL_EP());
									nodo.setEstado(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i).getCOD_ECV_BLQ_PRTCN());
									nodo.setFechaAlta(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i).getFECHA_INIC_ECV());
									nodo.setFechaVTO(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i).getFECHA_PLANIF());
									nodo.setImporte(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i).getBP_BLOQUEO_PRTCN_E().getMOTIVO_BLQ_PRTCN());
									nodo.setTipo(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i).getBP_BLOQUEO_PRTCN_E().getCOD_BLOQUEO());
									bloqueos.add(nodo);
								}
								cabecera.setMensaje(datos.getMENSAJE());
								cabecera.setStatus(datos.getCODIGO());
								response.setCabecera(cabecera);
								response.setBloqueos(bloqueos);
							
						}
					}
					
				}
				catch (ParseException e) {
					e.printStackTrace();
					cabecera.setMensaje(errorParseo+e.getMessage());
					cabecera.setStatus(statusIncorrecto);
					response.setCabecera(cabecera);
				}
			}
			else
			{
				cabecera.setStatus(statusIncorrecto);
				cabecera.setMensaje(errorGeneral+errornoRequest);
				response.setCabecera(cabecera);
			}
		}
		return response;
	}
}
