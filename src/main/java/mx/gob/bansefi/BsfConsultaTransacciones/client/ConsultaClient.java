package mx.gob.bansefi.BsfConsultaTransacciones.client;

import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria.*;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos.*;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Cheque.ConsultaChequeDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Cheque.ReqConsultaChequeDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Cheque.ResConsultaChequeDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Transaccion.ConsultaMovimientoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Transaccion.CuentaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo.ConsultaDatosAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo.ListaDatosAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo.ReqConsultaDatosAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo.ResConsultaDatosAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosPorAcuerdo.ConsultaDatosPorAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosPorAcuerdo.ReqConsultaDatosPorAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosPorAcuerdo.ResConsultaDatosPorAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones.*;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Nombre.ConsultaNombreDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.ReqConsultaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.RequestConsultaNombreDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.ResConsultaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResConsultaMovimientoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResConsultaNombreDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResErrorDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResGralDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.Util.Util;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;


/*Componente encargado de realizar la consulta de transacciones*/
@SuppressWarnings("unused")
@Component
public class ConsultaClient {
	/* Inyeccion de dependencias */
	@SuppressWarnings("rawtypes")
	public Util util;
	@Autowired
	public ConsultaClient(Util util){

		this.util=util;
	}
	@Value("${url.rootcontext}")
	private String urlRootContext;
	@Value("${url.consultaTransaccion}")
	private String urlConsultaTransaccion;
	@Value("${url.consultaNombre}")
	private String urlConsultaNombre;
	@Value("${url.consultaMasAuditoria}")
	private String urlConsultaMasAuditoria;
	@Value("${url.consultaCheque}")
	private String urlConsultaCheque;
	@Value("${url.consultaDatosAcuerdo}")
	private String urlConsultaDatosAcuerdo;
	@Value("${url.consultaRetenciones}")
	private String urlConsultaRetenciones;
	@Value("${url.consultaBloqueos}")
	private String urlConsultaBloqueos;
	@Value("${url.consultaDatosPorAcuerdo}")
	private String urlDatosPorAcuerdo;

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
	@Value("${status.tcb}")
	private String statusTCB;
	@Value("${status.incorrecto}")
	private String statusIncorrecto;
	@Value("${nodo.EjecutarResponse}")
	private String ejecutarResponse;
	@Value("${nodo.EjecutarResult}")
	private String ejecutarResult;
	@Value("${nodo.Tipo}")
	private String tipo;
	@Value("${nodo.Ceros}")
	private String Ceros;
	
	String cadena = "";

	/* Consulta de transacciones */
	@SuppressWarnings({ "unchecked", "null" })
	public ResConsultaMovimientoDTO consDatosGral(ReqConsultaDTO request) {

		ResConsultaDTO datos = new ResConsultaDTO();
		ArrayList<ConsultaMovimientoDTO> transacciones = new ArrayList<ConsultaMovimientoDTO>();
		ResGralDTO cabecera = new ResGralDTO();
		ResConsultaMovimientoDTO respuesta = new ResConsultaMovimientoDTO();
		CuentaDTO catalogoCliente= new CuentaDTO();
		request.setAcceso(request.getAcceso() == null ? "" : request.getAcceso());
		request.setAcuerdo(request.getAcuerdo() == null ? "" : request.getAcuerdo());
		request.setEntidad(request.getEntidad() == null ? "" : request.getEntidad());
		request.setFechadesde(request.getFechadesde() == null ? "" : request.getFechadesde());
		request.setFechahasta(request.getFechahasta() == null ? "" : request.getFechahasta());
		request.setFormato(request.getFormato() == null ? "" : request.getFormato());
		request.setImpsdo(request.getImpsdo() == null ? "" : request.getImpsdo());
		request.setNumsec(request.getNumsec() == null ? "" : request.getNumsec());
		request.setPassword(request.getPassword() == null ? "" : request.getPassword());
		request.setTerminal(request.getTerminal() == null ? "" : request.getTerminal());
		request.setUsuario(request.getUsuario() == null ? "" : request.getUsuario());
		if (request.getAcceso().equals("") || request.getAcuerdo().equals("") || request.getEntidad().equals("")
				|| request.getFechadesde().equals("") || request.getFechahasta().equals("")
				|| request.getFormato().equals("") || request.getImpsdo().equals("") || request.getNumsec().equals("")
				|| request.getPassword().equals("") || request.getTerminal().equals("")
				|| request.getUsuario().equals("")) {
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral + errornoRequest);
			respuesta.setCabecera(cabecera);
			return respuesta;
		} else {
			try {
				String jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaTransaccion);
				String cadena = jsonRes;
				jsonRes = jsonRes == null ? "" : jsonRes;
				if (!jsonRes.equals("")) {
					ArrayList<String> nodos = new ArrayList<String>();
					nodos.add(ejecutarResponse);
					nodos.add(ejecutarResult);
					datos = (ResConsultaDTO) this.util.jsonToObject(datos, cadena, nodos);
					if (datos.getTRANID().equals(errornoFirmado)) {
						cabecera.setMensaje(errorGeneral + errorUsuario);
						cabecera.setStatus(statusIncorrecto);
						respuesta.setCabecera(cabecera);
					} else {
						if (Integer.valueOf(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
								.getNUMBER_OF_RECORDS()) != 0 || Integer.valueOf(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getRTRN_CD()).compareTo(7)<0) {

							for (int i = 0; i < Integer.valueOf(datos.getResponseBansefi()
									.getOTR_CONSULTA_APNTES_PSV_T().getNUMBER_OF_RECORDS()); i++) {
								ConsultaMovimientoDTO res = new ConsultaMovimientoDTO();
								res.setFechaOperacion(util
										.formatearFechaGeneral(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
												.getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i)
												.getPSV_F_OPERACION_V().getFECHA_OPRCN()));
								res.setSaldo(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
										.getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i)
										.getIMP_SDO());
								res.setImporte(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
										.getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i)
										.getIMP_APNTE());
								res.setConcepto(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
										.getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i)
										.getTXT_TIPO_CLOP_LARG());
								res.setFechaValor(util.formatearFechaGeneral(datos.getResponseBansefi()
										.getOTR_CONSULTA_APNTES_PSV_T().getTR_CONSULTA_APNTES_PSV_EV()
										.getTR_CONSULTA_APNTES_PSV_EV().get(i).getFECHA_VALOR()));
								res.setFechaValor(util.formatearFechaGeneral(datos.getResponseBansefi()
										.getOTR_CONSULTA_APNTES_PSV_T().getTR_CONSULTA_APNTES_PSV_EV()
										.getTR_CONSULTA_APNTES_PSV_EV().get(i).getFECHA_VALOR()));

								System.out.println(res.getFechaValor());
								res.setOfiTerminal(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
										.getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i)
										.getID_INTERNO_TERM_TN());
								res.setSigno(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
										.getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i).getSGN());
								res.setDetalle(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
										.getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i)
										.getNUM_SEC());
								res.setCodcuenta(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
										.getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i)
										.getCOD_CTA());
								res.setCodapunte(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
										.getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i)
										.getCOD_ORGN_APNTE());
								res.setCodorigen(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
										.getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i)
										.getCOD_ORIGEN());
								res.setIdOrigen(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
										.getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV().get(i)
										.getID_ORGN_APNTE() == null
												? ""
												: datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
														.getTR_CONSULTA_APNTES_PSV_EV().getTR_CONSULTA_APNTES_PSV_EV()
														.get(i).getID_ORGN_APNTE());
								transacciones.add(res);
							}
							cabecera.setMensaje(datos.getMENSAJE());
							cabecera.setStatus(statusCorrecto);
							respuesta.setCantidad(
									datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getNUMBER_OF_RECORDS());
							respuesta.setCabecera(cabecera);
							respuesta.setFechaOperacion(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getSTD_TRN_O_PARM_V().getFECHA_OPRCN());
							respuesta.setHoraOperacion(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getSTD_TRN_O_PARM_V().getHORA_OPRCN());
							respuesta.setLista(transacciones);
						} else {

							ArrayList<ResErrorDTO> lista = new ArrayList<ResErrorDTO>();
							for (int i = 0; i < datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
									.getSTD_TRN_MSJ_PARM_V().size(); i++) {
								ResErrorDTO errores = new ResErrorDTO();
								errores.setCodigo(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
								errores.setMensaje(datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
								lista.add(errores);
							}
							cabecera.setErrores(lista);
							cabecera.setMensaje(errorGeneral +":"+datos.getCODIGO()+"-"+ datos.getMENSAJE());
							cabecera.setStatus(statusIncorrecto+"-"+statusTCB+datos.getResponseBansefi().getOTR_CONSULTA_APNTES_PSV_T().getRTRN_CD());
							respuesta.setCabecera(cabecera);
							respuesta.setLista(transacciones);

						}
					}
				} else {
					cabecera.setMensaje(errorParseo);
					cabecera.setStatus(statusIncorrecto);
					respuesta.setCabecera(cabecera);

				}

			} catch (org.json.simple.parser.ParseException e) {
				e.printStackTrace();
				e.printStackTrace();
				cabecera.setMensaje(errorParseo + e.getMessage());
				respuesta.setCabecera(cabecera);
			}

			System.out.println(cadena);
			return respuesta;
		}

	}



	/* Consulta minima para obtener el nombre */
	@SuppressWarnings("unchecked")
	public ResConsultaNombreDTO consultaNombre(RequestConsultaNombreDTO request) {
		@SuppressWarnings("unused")
		ConsultaNombreDTO datos = new ConsultaNombreDTO();
		ResConsultaNombreDTO response = new ResConsultaNombreDTO();
		ResGralDTO cabecera = new ResGralDTO();
		String jsonRes = "";
		request.setEntidad(request.getEntidad() == null ? "" : request.getEntidad());
		request.setIdInternoPe(request.getIdInternoPe() == null ? "" : request.getIdInternoPe());
		request.setPassword(request.getPassword() == null ? "" : request.getPassword());
		request.setTerminal(request.getTerminal() == null ? "" : request.getTerminal());
		request.setUsuario(request.getUsuario() == null ? "" : request.getUsuario());
		if (request.getEntidad().equals("") || request.getIdInternoPe().equals("") || request.getPassword().equals("")
				|| request.getTerminal().equals("") || request.getUsuario().equals("")) {
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral + errornoRequest);
			response.setCabecera(cabecera);
		} else {
			jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaNombre);
			System.out.println(jsonRes);
			if (!jsonRes.equals("")) {
				ArrayList<String> nodos = new ArrayList<String>();
				nodos.add(ejecutarResponse);
				nodos.add(ejecutarResult);
				try {
					datos = (ConsultaNombreDTO) this.util.jsonToObject(datos, jsonRes, nodos);
					if (datos.getTRANID().equals(errornoFirmado)) {
						cabecera.setMensaje(errorGeneral + errorUsuario);
						cabecera.setStatus(statusIncorrecto);
						response.setCabecera(cabecera);
					} else {
						if (Integer.valueOf(datos.getESTATUS())==0) {
							response.setIdExt(datos.getResponseBansefi().getOTR_PE_CL_CB_DA_CNS_TRN_O()
									.getTR_PE_CL_CB_DA_CNS_EVT_Z().getID_EXT_PE());
							response.setIdInternoPe(datos.getResponseBansefi().getOTR_PE_CL_CB_DA_CNS_TRN_O()
									.getTR_PE_CL_CB_DA_CNS_EVT_Z().getID_INTERNO_PE());
							response.setNombre(datos.getResponseBansefi().getOTR_PE_CL_CB_DA_CNS_TRN_O()
									.getTR_PE_CL_CB_DA_CNS_EVT_Z().getNOMB_50());
							cabecera.setStatus(statusCorrecto);
							cabecera.setMensaje(datos.getMENSAJE());
							response.setCabecera(cabecera);
						} else {

							ArrayList<ResErrorDTO> lista = new ArrayList<ResErrorDTO>();
							for (int i = 0; i < datos.getResponseBansefi().getOTR_PE_CL_CB_DA_CNS_TRN_O()
									.getSTD_TRN_MSJ_PARM_V().size(); i++) {
								ResErrorDTO errores = new ResErrorDTO();
								errores.setCodigo(datos.getResponseBansefi().getOTR_PE_CL_CB_DA_CNS_TRN_O()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
								errores.setMensaje(datos.getResponseBansefi().getOTR_PE_CL_CB_DA_CNS_TRN_O()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
								lista.add(errores);
							}
							cabecera.setErrores(lista);
							cabecera.setMensaje(errorGeneral+":"+datos.getCODIGO()+"-" + datos.getMENSAJE());
							cabecera.setStatus(statusIncorrecto+"-"+statusTCB+datos.getResponseBansefi().getOTR_PE_CL_CB_DA_CNS_TRN_O().getRTRN_CD());
							response.setCabecera(cabecera);

						}
					}
				} catch (ParseException e) {
					e.printStackTrace();
					cabecera.setMensaje(errorParseo + e.getMessage());
					response.setCabecera(cabecera);
				}
			} else {
				cabecera.setStatus(statusIncorrecto);
				cabecera.setMensaje(errorGeneral + errornoRequest);
				response.setCabecera(cabecera);
			}
		}
		return response;
	}

	/* Consulta para obtener el nombre a traves del acuerdo */
	@SuppressWarnings("unchecked")
	public ResConsultaDatosAcuerdoDTO consultaDatosAcuerdo(ReqConsultaDatosAcuerdoDTO request) {
		ResConsultaDatosAcuerdoDTO response = new ResConsultaDatosAcuerdoDTO();
		ResGralDTO cabecera = new ResGralDTO();
		ConsultaDatosAcuerdoDTO datos = new ConsultaDatosAcuerdoDTO();
		String jsonRes;
		request.setEntidad(request.getEntidad() == null ? "" : request.getEntidad());
		request.setAcuerdo(request.getAcuerdo() == null ? "" : request.getAcuerdo());
		request.setPassword(request.getPassword() == null ? "" : request.getPassword());
		request.setTerminal(request.getTerminal() == null ? "" : request.getTerminal());
		request.setUsuario(request.getUsuario() == null ? "" : request.getUsuario());

		if (request.getEntidad().equals("") || request.getAcuerdo().equals("") || request.getPassword().equals("")
				|| request.getTerminal().equals("") || request.getUsuario().equals("")) {
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral + errornoRequest);
			response.setCabecera(cabecera);
		} else {
			jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaDatosAcuerdo);
			System.out.println(jsonRes);

			if (!jsonRes.equals("")) {
				ArrayList<String> nodos = new ArrayList<String>();
				nodos.add(ejecutarResponse);
				nodos.add(ejecutarResult);
				try {
					datos = (ConsultaDatosAcuerdoDTO) this.util.jsonToObject(datos, jsonRes, nodos);
					if (datos.getTRANID().equals(errornoFirmado)) {
						cabecera.setMensaje(errorGeneral + errorUsuario);
						cabecera.setStatus(statusIncorrecto);
						response.setCabecera(cabecera);
					}

					else {

						if (Integer.valueOf(datos.getResponseBansefi().getOTR_CONSU_SELECTIV2_AC_TR()
								.getNUMBER_OF_RECORDS()) == 0) {
							ArrayList<ResErrorDTO> lista = new ArrayList<ResErrorDTO>();
							for (int i = 0; i < datos.getResponseBansefi().getOTR_CONSU_SELECTIV2_AC_TR()
									.getSTD_TRN_MSJ_PARM_V().size(); i++) {
								ResErrorDTO errores = new ResErrorDTO();
								errores.setCodigo(datos.getResponseBansefi().getOTR_CONSU_SELECTIV2_AC_TR()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
								errores.setMensaje(datos.getResponseBansefi().getOTR_CONSU_SELECTIV2_AC_TR()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
								lista.add(errores);
							}
							cabecera.setErrores(lista);
							cabecera.setMensaje(errorGeneral+":"+datos.getCODIGO()+"-" + datos.getMENSAJE());
							cabecera.setStatus(statusIncorrecto+"-"+statusTCB+datos.getResponseBansefi().getOTR_CONSU_SELECTIV2_AC_TR().getRTRN_CD());
							response.setCabecera(cabecera);
						} else {
							ArrayList<ListaDatosAcuerdoDTO> lista = new ArrayList<ListaDatosAcuerdoDTO>();
							for (int i = 0; i < Integer.valueOf(datos.getResponseBansefi()
									.getOTR_CONSU_SELECTIV2_AC_TR().getNUMBER_OF_RECORDS()); i++) {
								ListaDatosAcuerdoDTO nodo = new ListaDatosAcuerdoDTO();
								nodo.setNombre(datos.getResponseBansefi().getOTR_CONSU_SELECTIV2_AC_TR()
										.getTR_CONSU_SELECTIV2_AC_EVT().get(i).getDATOS_PER_V().getNOMB_50() == null
												? ""
												: datos.getResponseBansefi().getOTR_CONSU_SELECTIV2_AC_TR()
														.getTR_CONSU_SELECTIV2_AC_EVT().get(i).getDATOS_PER_V()
														.getNOMB_50());
								nodo.setIdInternoPe(datos.getResponseBansefi().getOTR_CONSU_SELECTIV2_AC_TR().getTR_CONSU_SELECTIV2_AC_EVT().get(i).getDATOS_PER_V().getID_INTERNO_PE()==null?"":datos.getResponseBansefi().getOTR_CONSU_SELECTIV2_AC_TR().getTR_CONSU_SELECTIV2_AC_EVT().get(i).getDATOS_PER_V().getID_INTERNO_PE());
								lista.add(nodo);
							}
							cabecera.setMensaje(datos.getMENSAJE());
							cabecera.setStatus(statusCorrecto);
							response.setNombres(lista);
							response.setCabecera(cabecera);

						}
					}

				} catch (ParseException e) {
					e.printStackTrace();
					cabecera.setMensaje(errorParseo + e.getMessage());
					cabecera.setStatus(statusIncorrecto);
					response.setCabecera(cabecera);
				}
			} else {
				cabecera.setStatus(statusIncorrecto);
				cabecera.setMensaje(errorGeneral + errornoRequest);
				response.setCabecera(cabecera);
			}
		}

		return response;
	}

	/* Consulta las retenciones de un acuerdo */
	@SuppressWarnings("unchecked")
	public ResConsultaRetencionesDTO consultaRetenciones(ReqConsultaRetencionDTO request) {
		ResConsultaRetencionesDTO response = new ResConsultaRetencionesDTO();
		ConsultaRetencionDTO datos = new ConsultaRetencionDTO();
		ResGralDTO cabecera = new ResGralDTO();
		String jsonRes;

		request.setEntidad(request.getEntidad() == null ? "" : request.getEntidad());
		request.setAcuerdo(request.getAcuerdo() == null ? "" : request.getAcuerdo());
		request.setPassword(request.getPassword() == null ? "" : request.getPassword());
		request.setTerminal(request.getTerminal() == null ? "" : request.getTerminal());
		request.setUsuario(request.getUsuario() == null ? "" : request.getUsuario());
		request.setEstado(request.getEstado() == null ? "" : request.getEstado());
		if (request.getEntidad().equals("") || request.getAcuerdo().equals("") || request.getPassword().equals("")
				|| request.getTerminal().equals("") || request.getUsuario().equals("")) {
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral + errornoRequest);
			response.setCabecera(cabecera);
		} else {
			jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaRetenciones);
			System.out.println(jsonRes+"nada");

			if (!jsonRes.equals("")) {
				ArrayList<String> nodos = new ArrayList<String>();
				nodos.add(ejecutarResponse);
				nodos.add(ejecutarResult);
				try {

					datos = (ConsultaRetencionDTO) this.util.jsonToObject(datos, jsonRes, nodos);
					if (datos.getTRANID().equals(errornoFirmado)) {
						cabecera.setMensaje(errorGeneral + errorUsuario);
						cabecera.setStatus(statusIncorrecto);
						response.setCabecera(cabecera);
					} else {
						if (Integer.valueOf(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getNUMBER_OF_RECORDS())==0) {
							ArrayList<ResErrorDTO> lista = new ArrayList<ResErrorDTO>();
							for (int i = 0; i < datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR()
									.getSTD_TRN_MSJ_PARM_V().size(); i++) {
								ResErrorDTO errores = new ResErrorDTO();
								errores.setCodigo(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
								errores.setMensaje(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
								lista.add(errores);
							}
							cabecera.setErrores(lista);
							cabecera.setMensaje(errorGeneral +":"+datos.getCODIGO()+"-"+ datos.getMENSAJE());
							cabecera.setStatus(statusIncorrecto+"-"+statusTCB+datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getRTRN_CD());
							response.setCabecera(cabecera);
						} else {

							ArrayList<ListaConsultaRetencionesDTO> retenciones = new ArrayList<ListaConsultaRetencionesDTO>();
							for (int i = 0; i < Integer.valueOf(datos.getResponseBansefi()
									.getOTR_CONSULTA_GLOBAL_RT_TR().getNUMBER_OF_RECORDS()); i++) {
								ListaConsultaRetencionesDTO nodo = new ListaConsultaRetencionesDTO();
								nodo.setTipo(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR()
										.getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getAF_APNTE_E().getCOD_ORIGEN());
								nodo.setConcepto(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR()
										.getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getAF_APNTE_E()
										.getCONCPT_APNTE());
								nodo.setEmpleado(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR()
										.getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getAF_AUDIT_E().getID_INTERNO_EMPL_EP());
								nodo.setEstado(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR()
										.getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getAF_AUDIT_E()
										.getPRPDAD_CTA());
								nodo.setFechaAlta(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR()
										.getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getAF_APNTE_E()
										.getFECHA_VALOR());
								nodo.setFechaVTO(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getTR_CONSULTA_GLOBAL_RT_EVT().getRT_F_VTO_V().get(i).getFECHA_OPRCN());
								nodo.setImporte(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getAF_APNTE_E().getIMP_APNTE());

								nodo.setOrigen(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR().getTR_CONSULTA_GLOBAL_RT_EVT().getID_ORGN_APNTE_V().get(i).getSTD_CHAR_50());
								nodo.setNumSec(datos.getResponseBansefi().getOTR_CONSULTA_GLOBAL_RT_TR()
										.getTR_CONSULTA_GLOBAL_RT_EVT().getTR_AF_CONS_EVT_V().get(i).getAF_APNTE_E()
										.getNUM_SEC());
								retenciones.add(nodo);
							}
							cabecera.setMensaje(datos.getMENSAJE());
							cabecera.setStatus(statusCorrecto);
							response.setCabecera(cabecera);
							response.setRetenciones(retenciones);

						}
					}
				} catch (ParseException e) {
					e.printStackTrace();
					cabecera.setMensaje(errorParseo + e.getMessage());
					cabecera.setStatus(statusIncorrecto);
					response.setCabecera(cabecera);
				}
			} else {
				cabecera.setStatus(statusIncorrecto);
				cabecera.setMensaje(errorGeneral + errornoRequest);
				response.setCabecera(cabecera);
			}

		}
		return response;
	}

	/* Consulta los bloqueos de un acuerdo */
	@SuppressWarnings("unchecked")
	public ResConsultaBloqueosDTO consultaBloqueos(ReqConsultaBloqueoDTO request) {
		ResConsultaBloqueosDTO response = new ResConsultaBloqueosDTO();
		ResGralDTO cabecera = new ResGralDTO();
		ConsultaBloqueoDTO datos = new ConsultaBloqueoDTO();
		String jsonRes;

		request.setEntidad(request.getEntidad() == null ? "" : request.getEntidad());
		request.setAcuerdo(request.getAcuerdo() == null ? "" : request.getAcuerdo());
		request.setPassword(request.getPassword() == null ? "" : request.getPassword());
		request.setTerminal(request.getTerminal() == null ? "" : request.getTerminal());
		request.setUsuario(request.getUsuario() == null ? "" : request.getUsuario());
		if (request.getEntidad().equals("") || request.getAcuerdo().equals("") || request.getPassword().equals("")
				|| request.getTerminal().equals("") || request.getUsuario().equals("")) {
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral + errornoRequest);
			response.setCabecera(cabecera);
		} else {
			jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaBloqueos);
			System.out.println(jsonRes);

			if (!jsonRes.equals("")) {
				ArrayList<String> nodos = new ArrayList<String>();
				nodos.add(ejecutarResponse);
				nodos.add(ejecutarResult);
				try {
					datos = (ConsultaBloqueoDTO) this.util.jsonToObject(datos, jsonRes, nodos);
					if (datos.getTRANID().equals(errornoFirmado)) {
						cabecera.setMensaje(errorGeneral + errorUsuario);
						cabecera.setStatus(statusIncorrecto);
						response.setCabecera(cabecera);
					} else {
						System.out.println(
								datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getTR_PETICION_CONSULTA_BP_E()
										.getBP_LISTA_BLOQUEO_V().get(0).getBP_BLOQUEO_PRTCN_E().getNUM_SEC_AC());
						if (Integer.valueOf(
								datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getNUMBER_OF_RECORDS()) == 0) {
							ArrayList<ResErrorDTO> lista = new ArrayList<ResErrorDTO>();
							for (int i = 0; i < datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP()
									.getSTD_TRN_MSJ_PARM_V().size(); i++) {
								ResErrorDTO errores = new ResErrorDTO();
								errores.setCodigo(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
								errores.setMensaje(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
								lista.add(errores);
							}
							cabecera.setErrores(lista);
							cabecera.setMensaje(errorGeneral + datos.getMENSAJE());
							cabecera.setStatus(statusIncorrecto+"-"+statusTCB+datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP().getRTRN_CD());
							response.setCabecera(cabecera);
						} else {

							ArrayList<ListaConsultaBloqueosDTO> bloqueos = new ArrayList<ListaConsultaBloqueosDTO>();
							for (int i = 0; i < Integer.valueOf(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP()
									.getNUMBER_OF_RECORDS()); i++) {
								ListaConsultaBloqueosDTO nodo = new ListaConsultaBloqueosDTO();
								nodo.setNumeroBloqueo(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP()
										.getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i)
										.getBP_BLOQUEO_PRTCN_E().getNUM_BLQ_PRTCN());
								nodo.setCentro(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP()
										.getTR_PETICION_CONSULTA_BP_E().getCOD_INTERNO_UO_V().getCOD_INTERNO_UO());
								nodo.setMotivo(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP()
										.getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i)
										.getBP_BLOQUEO_PRTCN_E().getMOTIVO_BLQ_PRTCN());
								System.out.println(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP()
										.getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i)
										.getBP_BLOQUEO_PRTCN_E().getMOTIVO_CANC_ANTIC());
								nodo.setCancelacion(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP()
										.getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i)
										.getBP_BLOQUEO_PRTCN_E().getMOTIVO_CANC_ANTIC());
								nodo.setEmpleado(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP()
										.getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i)
										.getID_INTERNO_EMPL_EP());
								nodo.setEstado(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP()
										.getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i)
										.getCOD_ECV_BLQ_PRTCN());
								nodo.setFechaAlta(util.formatearFechaGeneral(datos.getResponseBansefi()
										.getOTR_PETICION_CONSULTA_BP().getTR_PETICION_CONSULTA_BP_E()
										.getBP_LISTA_BLOQUEO_V().get(i).getFECHA_INIC_ECV()));
								nodo.setFechaVTO(util.formatearFechaGeneral(datos.getResponseBansefi()
										.getOTR_PETICION_CONSULTA_BP().getTR_PETICION_CONSULTA_BP_E()
										.getBP_LISTA_BLOQUEO_V().get(i).getFECHA_PLANIF()));
								nodo.setImporte(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP()
										.getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i)
										.getBP_BLOQUEO_PRTCN_E().getCOD_NRBE_EN());
								nodo.setTipo(datos.getResponseBansefi().getOTR_PETICION_CONSULTA_BP()
										.getTR_PETICION_CONSULTA_BP_E().getBP_LISTA_BLOQUEO_V().get(i)
										.getBP_BLOQUEO_PRTCN_E().getCOD_BLOQUEO());
								bloqueos.add(nodo);
							}
							cabecera.setMensaje(datos.getMENSAJE());
							cabecera.setStatus(statusCorrecto);
							response.setCabecera(cabecera);
							response.setBloqueos(bloqueos);

						}
					}

				} catch (ParseException e) {
					e.printStackTrace();
					cabecera.setMensaje(errorParseo + e.getMessage());
					cabecera.setStatus(statusIncorrecto);
					response.setCabecera(cabecera);
				}
			} else {
				cabecera.setStatus(statusIncorrecto);
				cabecera.setMensaje(errorGeneral + errornoRequest);
				response.setCabecera(cabecera);
			}
		}
		return response;
	}


	/* Metodo para obtener el detalle de auditoria */
	@SuppressWarnings("unchecked")
	public ResConsultaMasAuditoriaDTO consultaMasAuditoria(ReqConsultaMasAuditoriaDTO request) {
		ResConsultaMasAuditoriaDTO response = new ResConsultaMasAuditoriaDTO();
		ResGralDTO cabecera = new ResGralDTO();
		ConsultaMasAuditoriaDTO datos = new ConsultaMasAuditoriaDTO();
		String jsonRes = "";
		request.setEntidad(request.getEntidad() == null ? "" : request.getEntidad());
		request.setAcuerdo(request.getAcuerdo() == null ? "" : request.getAcuerdo());
		request.setPassword(request.getPassword() == null ? "" : request.getPassword());
		request.setTerminal(request.getTerminal() == null ? "" : request.getTerminal());
		request.setUsuario(request.getUsuario() == null ? "" : request.getUsuario());
		request.setEmpleado(request.getEmpleado() == null ? "" : request.getEmpleado());
		request.setAutorizador(request.getAutorizador() == null ? "" : request.getAutorizador());
		if (request.getAcuerdo().equals("") || request.getEntidad().equals("") || request.getPassword().equals("")
				|| request.getTerminal().equals("") || request.getUsuario().equals("")
				|| request.getEmpleado().equals("")) {
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral + errornoRequest);
			response.setCabecera(cabecera);
		} else {
			jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaMasAuditoria);
			System.out.println(jsonRes);

			if (!jsonRes.equals("")) {
				ArrayList<String> nodos = new ArrayList<String>();
				nodos.add(ejecutarResponse);
				nodos.add(ejecutarResult);
				try {
					datos = (ConsultaMasAuditoriaDTO) this.util.jsonToObject(datos, jsonRes, nodos);
					if (datos.getTRANID().equals(errornoFirmado)) {
						cabecera.setMensaje(errorGeneral + errorUsuario);
						cabecera.setStatus(statusIncorrecto);
						response.setCabecera(cabecera);
					}

					else {

						if (datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O().getRTRN_CD().equals("0000")
								|| datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O().getRTRN_CD().equals("0007")) {
							ArrayList<ResErrorDTO> lista = new ArrayList<ResErrorDTO>();
							for (int i = 0; i < datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O()
									.getSTD_TRN_MSJ_PARM_V().size(); i++) {
								ResErrorDTO errores = new ResErrorDTO();
								errores.setCodigo(datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
								errores.setMensaje(datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
								lista.add(errores);
							}
							cabecera.setErrores(lista);
							cabecera.setMensaje(errorGeneral +":"+datos.getCODIGO()+"-"+ datos.getMENSAJE());
							cabecera.setStatus(statusIncorrecto+"-"+statusTCB+datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O().getRTRN_CD());
							response.setCabecera(cabecera);
						} else {

							cabecera.setMensaje(datos.getMENSAJE());
							cabecera.setStatus(statusCorrecto);
							response.setCabecera(cabecera);
							response.setNombreAutorizador(datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O()
									.getTR_CARGAR_AUDIT_EVT_Z().getNOMB_EMPL_AUT().getNOMB_50() == null ? ""
											: datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O()
													.getTR_CARGAR_AUDIT_EVT_Z().getNOMB_EMPL_AUT().getNOMB_50());
							response.setCodigoCentro(datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O()
									.getTR_CARGAR_AUDIT_EVT_Z().getCOD_INTERNO_UO_AC_V().getCOD_INTERNO_UO() == null
											? ""
											: datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O()
													.getTR_CARGAR_AUDIT_EVT_Z().getCOD_INTERNO_UO_AC_V()
													.getCOD_INTERNO_UO());
							response.setNombEnt(datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O()
									.getTR_CARGAR_AUDIT_EVT_Z().getNOMB_ENT_EN() == null ? ""
											: datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O()
													.getTR_CARGAR_AUDIT_EVT_Z().getNOMB_ENT_EN());
							response.setNombreEmpleado(datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O()
									.getTR_CARGAR_AUDIT_EVT_Z().getNOMB_EMPL_ORIG().getNOMB_50() == null ? ""
											: datos.getResponseBansefi().getOTR_CARGAR_AUDIT_TRN_O()
													.getTR_CARGAR_AUDIT_EVT_Z().getNOMB_EMPL_ORIG().getNOMB_50());
						}
					}

				} catch (ParseException e) {
					e.printStackTrace();
					cabecera.setMensaje(errorParseo + e.getMessage());
					cabecera.setStatus(statusIncorrecto);
					response.setCabecera(cabecera);
				}
			} else {
				cabecera.setStatus(statusIncorrecto);
				cabecera.setMensaje(errorGeneral + errornoRequest);
				response.setCabecera(cabecera);
			}
		}
		return response;
	}



	@SuppressWarnings("unchecked")
	public ResConsultaChequeDTO consultaCheque(ReqConsultaChequeDTO request) {
		ResConsultaChequeDTO response = new ResConsultaChequeDTO();
		ConsultaChequeDTO datos = new ConsultaChequeDTO();
		ResGralDTO cabecera = new ResGralDTO();
		String jsonRes = "";
		request.setAcuerdo(request.getAcuerdo() == null ? "" : request.getAcuerdo());
		request.setEntidad(request.getEntidad() == null ? "" : request.getEntidad());
		request.setPassword(request.getPassword() == null ? "" : request.getPassword());
		request.setTerminal(request.getTerminal() == null ? "" : request.getTerminal());
		request.setUsuario(request.getUsuario() == null ? "" : request.getUsuario());
		request.setCodigoCaja(request.getCodigoCaja() == null ? "" : request.getCodigoCaja());
		request.setCodSeguridad(request.getCodSeguridad() == null ? "" : request.getCodSeguridad());
		request.setNumCheque(request.getNumCheque() == null ? "" : request.getNumCheque());
		if (request.getAcuerdo().equals("") || request.getEntidad().equals("") || request.getPassword().equals("")
				|| request.getTerminal().equals("") || request.getUsuario().equals("")
				|| request.getCodigoCaja().equals("") || request.getNumCheque().equals("")) {
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral + errornoRequest);
			response.setCabecera(cabecera);
		} else {
			jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaCheque);
			System.out.println(jsonRes + ",");

			if (!jsonRes.equals("")) {
				ArrayList<String> nodos = new ArrayList<String>();
				nodos.add(ejecutarResponse);
				nodos.add(ejecutarResult);
				try {
					datos = (ConsultaChequeDTO) this.util.jsonToObject(datos, jsonRes, nodos);
					if (datos.getTRANID().equals(errornoFirmado)) {
						cabecera.setMensaje(errorGeneral + errorUsuario);
						cabecera.setStatus(statusIncorrecto);
						response.setCabecera(cabecera);
					}

					else {

						if (Integer
								.valueOf(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T().getRTRN_CD()) == 0) {
							ArrayList<ResErrorDTO> lista = new ArrayList<ResErrorDTO>();
							for (int i = 0; i < datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T()
									.getSTD_TRN_MSJ_PARM_V().size(); i++) {
								ResErrorDTO errores = new ResErrorDTO();
								errores.setCodigo(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
								errores.setMensaje(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T()
										.getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
								lista.add(errores);
							}
							cabecera.setErrores(lista);
							cabecera.setMensaje(errorGeneral +":"+datos.getCODIGO()+"-"+ datos.getMENSAJE());
							cabecera.setStatus(statusIncorrecto+"-"+statusTCB+datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T().getRTRN_CD());
							response.setCabecera(cabecera);
						} else {
							response.setFechaVencimiento(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T().getTR_CP_CONSULTA_DETALLE_EV().getFECHA_ACTVCN_PAG());
							response.setAcuerdo(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T()
									.getTR_CP_CONSULTA_DETALLE_EV().getCP_ACUERDO_CARGO_V().getNUM_SEC_AC());
							response.setCentro(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T()
									.getTR_CP_CONSULTA_DETALLE_EV().getCOD_INTERNO_UO_1());
							response.setConforma(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T()
									.getTR_CP_CONSULTA_DETALLE_EV().getIND_CHQ_PAG_CONF());
							response.setDisposicion(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T()
									.getTR_CP_CONSULTA_DETALLE_EV().getCONCEPTO_17());
							response.setEstado("Por determinar");
							response.setNombre(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T()
									.getTR_CP_CONSULTA_DETALLE_EV().getNOMB_50());
							response.setNumeroCheque(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T().getTR_CP_CONSULTA_DETALLE_EV().getNUM_CHQ_PAG());
							response.setCodigoCaja(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T()
									.getTR_CP_CONSULTA_DETALLE_EV().getCOD_CJ_CHQ_PG());
							response.setNumeroTalonario(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T()
									.getTR_CP_CONSULTA_DETALLE_EV().getNUM_CHQ_PAG());
							response.setPagoCheque(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T()
									.getTR_CP_CONSULTA_DETALLE_EV().getIMP_CHQ_PAG());
							response.setPagoPendiente(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T()
									.getTR_CP_CONSULTA_DETALLE_EV().getIMP_PDTE_CP());
							response.setSituacionPago(datos.getResponseBansefi().getOTR_CP_CONSULTA_DETALLE_T()
									.getTR_CP_CONSULTA_DETALLE_EV().getECV_ACTUAL());
							response.setTipoTalonario("por determinar");
							cabecera.setMensaje(datos.getMENSAJE());
							cabecera.setStatus(statusCorrecto);
							response.setCabecera(cabecera);

						}
					}

				} catch (ParseException e) {
					e.printStackTrace();
					cabecera.setMensaje(errorParseo + e.getMessage());
					cabecera.setStatus(statusIncorrecto);
					response.setCabecera(cabecera);
				}
			} else {
				cabecera.setStatus(statusIncorrecto);
				cabecera.setMensaje(errorGeneral + errornoRequest);
				response.setCabecera(cabecera);
			}
		}
		return response;

	}
	public ResConsultaDatosPorAcuerdoDTO consultaDatosPorAcuerdo(ReqConsultaDatosPorAcuerdoDTO request){
		ResConsultaDatosPorAcuerdoDTO response= new ResConsultaDatosPorAcuerdoDTO();
		ConsultaDatosPorAcuerdoDTO datos= new ConsultaDatosPorAcuerdoDTO();
		ResGralDTO cabecera = new ResGralDTO();
		Optional.ofNullable(request.getAcuerdo()).orElse("");
		Optional.ofNullable(request.getEntidad()).orElse("");
		Optional.ofNullable(request.getUsuario()).orElse("");
		Optional.ofNullable(request.getPassword()).orElse("");
		if (request.getAcuerdo().equals("") || request.getEntidad().equals("") || request.getPassword().equals("") || request.getUsuario().equals("")){
			cabecera.setStatus(statusIncorrecto);
			cabecera.setMensaje(errorGeneral + errornoRequest);
			response.setCabecera(cabecera);
		}else{
			String jsonRes = this.util.callRestPost(request, urlRootContext + urlDatosPorAcuerdo);
			System.out.println(jsonRes + ",");
			Optional.ofNullable(jsonRes).orElse("");
			if (!jsonRes.equals("")){
				jsonRes=jsonRes.replaceAll("-","_");
				try {
					ArrayList<String> nodos = new ArrayList<String>();
					nodos.add(ejecutarResponse);
					nodos.add(ejecutarResult);
					datos = (ConsultaDatosPorAcuerdoDTO) this.util.jsonToObject(datos, jsonRes, nodos);
					System.out.println(datos.getResponseBansefi().getResponseBansefi().getID_INTERNO_PE());
					if (datos.getTRANID().equals(errornoFirmado)) {
						cabecera.setMensaje(errorGeneral + errorUsuario);
						cabecera.setStatus(statusIncorrecto);
						response.setCabecera(cabecera);
					}else{
						if (Integer.valueOf(datos.getESTATUS())==1){
							cabecera.setMensaje(errorGeneral);
							cabecera.setStatus(statusIncorrecto);
							response.setCabecera(cabecera);
						}else{
							cabecera.setMensaje(datos.getMENSAJE());
							cabecera.setStatus(statusCorrecto);
							response.setCabecera(cabecera);
							response.setIdInternoPe(datos.getResponseBansefi().getResponseBansefi().getID_INTERNO_PE());
							response.setNombre(datos.getResponseBansefi().getResponseBansefi().getNOMBRE());
						}
					}
				}catch (Exception e){
					e.printStackTrace();
					cabecera.setMensaje(errorParseo + e.getMessage());
					cabecera.setStatus(statusIncorrecto);
					response.setCabecera(cabecera);
				}

			}
		}

		return response;
	}

}
