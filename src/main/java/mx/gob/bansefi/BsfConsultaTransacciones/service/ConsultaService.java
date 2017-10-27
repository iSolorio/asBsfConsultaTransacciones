package mx.gob.bansefi.BsfConsultaTransacciones.service;

import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.ConsultaAnotacionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.ListaAnotacionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.ReqConsultaAnotacionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.ResConsultaAnotacionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.consultaTextoAnotacion.ConsultaTextoAnotacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.consultaTextoAnotacion.ReqConsultaTextoAnotacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria.ConsultaAuditoriaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria.ReqConsultaAuditoriaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria.ResConsultaAuditoriaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos.ListaConsutaAuditoriaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Catalogo.CatalogoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Catalogo.ReqConsultaCatalogoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosEmpleado.PeConsIndvObjDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosEmpleado.ReqConsultaDatosEmpleadoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosSucursal.ReqConsultaDatosSucursalDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosSucursal.ResConsultaDatosSucursalDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Transaccion.CuentaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleAnotacion.ConsultaDetalleAnotacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleAnotacion.ReqConsultaDetalleAnotacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleAnotacion.ResConsultaDetalleAnotacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion.ConsultaDetalleApunteDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion.ReqConsultaDetalleTransaccionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion.ResConsultaDetalleTransaccionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion.ConsultaLiquidacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion.ListaLiquidacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion.ReqConsultaLiquidacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion.ResConsultaLiquidacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Transaccion.ReqCatalogoClienteDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResErrorDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResGralDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.Util.Util;
import mx.gob.bansefi.BsfConsultaTransacciones.diario.DiarioClient;
import mx.gob.bansefi.BsfConsultaTransacciones.diario.NumSecDTO;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


/**
 * @author Ivan Solorio
 * @version 1.0 - 2017/10/10
 */
@Service
public class ConsultaService {
    /*Inyecciond e dependencias*/
    private DiarioClient diario;
    private Util util;

    @Value("${url.rootcontext}")
    private String urlRootContext;
    @Value("${url.consultaAuditoria}")
    private String urlConsultaAuditoria;
    @Value("${url.consultaAnotaciones}")
    private String urlConsultaAnotaciones;
    @Value("${url.consultaDetalleAnotacion}")
    private String urlConsultaDetalleAnotacion;
    @Value("${url.consultaDetalleTransaccion}")
    private String urlConsultaDetalleTransaccion;
    @Value("${url.consultaDatosEmpleado}")
    private String urlConsultaDatosEmpleado;
    @Value("${url.consultaDatosSucursal}")
    private String urlConsultaDatosSucursal;
    @Value("${url.consultaCuenta}")
    private String urlcatalogoCuenta;
    @Value("${url.consultaCatalogos}")
    private String urlConsultaCatalogos;
    @Value("${catalogo.anotaciones}")
    private String catalogoAnotaciones;
    @Value("${url.consultaLiquidacion}")
    private String urlConsultaLiquidacion;
    @Value("${url.consultaCatalogos}")
    private String urlconsultaCatalogos;
    @Value("${catalogo.area}")
    private String catalogoArea;
    @Value("${catalogo.liquidacion}")
    private String catalogoLiquidacion;
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
    @Value("${nodo.Ceros}")
    private String Ceros;
    @Value("${nodo.Tipo}")
    private String tipo;
    @Autowired
    public ConsultaService(Util util,DiarioClient diario){
        this.util=util;
        this.diario=diario;
    }

    public ResConsultaAnotacionesDTO consultaAnotaciones(ReqConsultaAnotacionesDTO request) {
        ResConsultaAnotacionesDTO response = new ResConsultaAnotacionesDTO();
        ConsultaAnotacionesDTO datos = new ConsultaAnotacionesDTO();
        ResGralDTO cabecera = new ResGralDTO();
        NumSecDTO numSec= new NumSecDTO();
        String jsonRes = "";
        String catalogos="";
        request.setAcuerdo(request.getAcuerdo() == null ? "" : request.getAcuerdo());
        request.setEntidad(request.getEntidad() == null ? "" : request.getEntidad());
        request.setPassword(request.getPassword() == null ? "" : request.getPassword());
        request.setTerminal(request.getTerminal() == null ? "" : request.getTerminal());
        request.setUsuario(request.getUsuario() == null ? "" : request.getUsuario());
        request.setAntAlerta(request.getAntAlerta()==null?"":request.getAntAlerta());
        request.setAntAvisos(request.getAntAvisos()==null?"":request.getAntAvisos());
        request.setAntImperativa(request.getAntInformativa()==null?"":request.getAntImperativa());
        request.setAntInformativa(request.getAntInformativa()==null?"":request.getAntInformativa());
        request.setFechaDesde(request.getFechaDesde()==null?"":request.getFechaDesde());
        request.setFechaHasta(request.getFechaHasta()==null?"":request.getFechaHasta());
         System.out.println(request.getAcuerdo());
        if (request.getAcuerdo().equals("") || request.getEntidad().equals("") || request.getPassword().equals("")
                || request.getTerminal().equals("") || request.getUsuario().equals("")
                || request.getAntAlerta().equals("") || request.getAntAvisos().equals("") || request.getAntImperativa().equals("") || request.getAntInformativa().equals("")) {
            cabecera.setStatus(statusIncorrecto);
            cabecera.setMensaje(errorGeneral + errornoRequest);
            response.setCabecera(cabecera);
            System.out.println(request.getAcuerdo());
        } else {
            jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaAnotaciones);
            System.out.println(jsonRes + ",");

            if (!jsonRes.equals("")) {
                ArrayList<String> nodos = new ArrayList<String>();
                nodos.add(ejecutarResponse);
                nodos.add(ejecutarResult);
                try {
                    datos = (ConsultaAnotacionesDTO) this.util.jsonToObject(datos, jsonRes, nodos);
                    if (datos.getTRANID().equals(errornoFirmado)) {
                        cabecera.setMensaje(errorGeneral + errorUsuario);
                        cabecera.setStatus(statusIncorrecto);
                        response.setCabecera(cabecera);
                    }

                    else {

                        if (Integer
                                .valueOf(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getRTRN_CD()) == 0) {
                            ArrayList<ResErrorDTO> lista = new ArrayList<ResErrorDTO>();
                            for (int i = 0; i < datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T()
                                    .getSTD_TRN_MSJ_PARM_V().size(); i++) {
                                ResErrorDTO errores = new ResErrorDTO();
                                errores.setCodigo(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T()
                                        .getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
                                errores.setMensaje(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T()
                                        .getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
                                lista.add(errores);
                            }
                            cabecera.setErrores(lista);
                            cabecera.setMensaje(errorGeneral +":"+datos.getCODIGO()+"-"+ datos.getMENSAJE());
                            cabecera.setStatus(statusIncorrecto+"-"+statusTCB+datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getRTRN_CD());
                            response.setCabecera(cabecera);
                        } else {
                            ArrayList<ListaAnotacionesDTO> anotaciones= new ArrayList<ListaAnotacionesDTO>();
                            for(int i=0;i<Integer.valueOf(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getNUMBER_OF_RECORDS());i++)
                            {
                                ListaAnotacionesDTO nodo = new ListaAnotacionesDTO();
                                nodo.setDescripcion(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getTR_CONSUL_AN_ANOT_PANT_EV().getAN_ANTCN_E().get(i).getTXT_LARGA());
                                nodo.setFechaActivacion(util.formatearFechaGeneral(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getTR_CONSUL_AN_ANOT_PANT_EV().getAN_ANTCN_E().get(i).getFECHA_INICIO()));
                                nodo.setAnotacion(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getTR_CONSUL_AN_ANOT_PANT_EV().getAN_ANTCN_E().get(i).getNUMERO_ANTCN());
                                nodo.setPrioridad(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getTR_CONSUL_AN_ANOT_PANT_EV().getAN_ANTCN_E().get(i).getIND_PRDAD());
                                nodo.setCodAnt(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getTR_CONSUL_AN_ANOT_PANT_EV().getAN_ANTCN_E().get(i).getCOD_ANTCN());
                                nodo.setCodSubAnt(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getTR_CONSUL_AN_ANOT_PANT_EV().getAN_ANTCN_E().get(i).getSUBCD_ANTCN());
                               nodo.setEmpleado(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getTR_CONSUL_AN_ANOT_PANT_EV().getAN_ANTCN_E().get(i).getID_INTERNO_EMPL_EP());
                                ReqConsultaTextoAnotacionDTO peticion= new ReqConsultaTextoAnotacionDTO(request.getUsuario(),request.getPassword(),catalogoAnotaciones,String.valueOf((Integer.valueOf(nodo.getCodAnt())*100)+Integer.valueOf(nodo.getCodSubAnt())));
                                ArrayList<String> nodles = new ArrayList<String>();
                                nodles.add(ejecutarResponse);
                                nodles.add(ejecutarResult);
                                catalogos= this.util.callRestPost(peticion, urlConsultaCatalogos);
                                ConsultaTextoAnotacionDTO texto= new ConsultaTextoAnotacionDTO();
                                texto= (ConsultaTextoAnotacionDTO) this.util.jsonToObject(texto, catalogos, nodles);
                                nodo.setTextSubAnt(texto.getResponseBansefi().getResponseBansefi().getDESCRIPCION_LARGA_FL());
                                peticion.setCatalogo(catalogoArea);
                                peticion.setCodigo(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getTR_CONSUL_AN_ANOT_PANT_EV().getAN_ANTCN_E().get(i).getDSTN_ANTCN());
                                catalogos= this.util.callRestPost(peticion, urlConsultaCatalogos);
                                texto= (ConsultaTextoAnotacionDTO) this.util.jsonToObject(texto, catalogos, nodles);
                                nodo.setArea(texto.getResponseBansefi().getResponseBansefi().getDESCRIPCION_LARGA_FL());


                                anotaciones.add(nodo);
                            }
                            numSec=diario.obtenerNumSec(request);
                            diario.InsertaDiario(request,datos,numSec);
                            response.setAnotaciones(anotaciones);
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

    public ResConsultaDetalleAnotacionDTO consultaDetalleAnotacion(ReqConsultaDetalleAnotacionDTO request)
    {
        ResConsultaDetalleAnotacionDTO response= new ResConsultaDetalleAnotacionDTO();
        ConsultaDetalleAnotacionDTO datos= new ConsultaDetalleAnotacionDTO();
        ResGralDTO cabecera = new ResGralDTO();
        String jsonRes = "";
        request.setEntidad(request.getEntidad() == null ? "" : request.getEntidad());
        request.setPassword(request.getPassword() == null ? "" : request.getPassword());
        request.setTerminal(request.getTerminal() == null ? "" : request.getTerminal());
        request.setUsuario(request.getUsuario() == null ? "" : request.getUsuario());
        request.setCodSubAnt(request.getCodAnt()==null?"":request.getCodSubAnt());
        request.setCodAnt(request.getCodAnt()==null?"":request.getCodAnt());
        request.setAnotacion(request.getAnotacion()==null?"":request.getAnotacion());
        if ( request.getEntidad().equals("") || request.getPassword().equals("")
                || request.getTerminal().equals("") || request.getUsuario().equals("")
                || request.getCodAnt().equals("") || request.getCodSubAnt().equals("") || request.getAnotacion().equals("") ) {
            cabecera.setStatus(statusIncorrecto);
            cabecera.setMensaje(errorGeneral + errornoRequest);
            response.setCabecera(cabecera);
        } else {
            jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaDetalleAnotacion);
            System.out.println(jsonRes + ",");

            if (!jsonRes.equals("")) {
                ArrayList<String> nodos = new ArrayList<String>();
                nodos.add(ejecutarResponse);
                nodos.add(ejecutarResult);
                try {
                    datos = (ConsultaDetalleAnotacionDTO) this.util.jsonToObject(datos, jsonRes, nodos);
                    if (datos.getTRANID().equals(errornoFirmado)) {
                        cabecera.setMensaje(errorGeneral + errorUsuario);
                        cabecera.setStatus(statusIncorrecto);
                        response.setCabecera(cabecera);
                    }

                    else {

                        if (Integer
                                .valueOf(datos.getResponseBansefi().getOTR_CONSUL_AN_PANT_TRN_O().getRTRN_CD()) == 0) {
                            ArrayList<ResErrorDTO> lista = new ArrayList<ResErrorDTO>();
                            for (int i = 0; i < datos.getResponseBansefi().getOTR_CONSUL_AN_PANT_TRN_O()
                                    .getSTD_TRN_MSJ_PARM_V().size(); i++) {
                                ResErrorDTO errores = new ResErrorDTO();
                                errores.setCodigo(datos.getResponseBansefi().getOTR_CONSUL_AN_PANT_TRN_O()
                                        .getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
                                errores.setMensaje(datos.getResponseBansefi().getOTR_CONSUL_AN_PANT_TRN_O()
                                        .getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
                                lista.add(errores);
                            }
                            cabecera.setErrores(lista);
                            cabecera.setMensaje(errorGeneral +":"+datos.getCODIGO()+"-"+ datos.getMENSAJE());
                            cabecera.setStatus(statusIncorrecto+"-"+statusTCB+datos.getResponseBansefi().getOTR_CONSUL_AN_PANT_TRN_O().getRTRN_CD());
                            response.setCabecera(cabecera);
                        } else {
                            nodos.add("ResponseBansefi");
                            nodos.add("OTR_CONS_EMPL_TRN_O");
                            nodos.add("TR_CONS_EMPL_EVT_Z");
                            nodos.add("PE_CONS_INDV_OBJ_TRD_V");
                            PeConsIndvObjDTO empleado= new PeConsIndvObjDTO();
                            ReqConsultaDatosEmpleadoDTO peticion= new ReqConsultaDatosEmpleadoDTO();
                            peticion.setEntidad(request.getEntidad());
                            peticion.setUsuario(request.getUsuario());
                            peticion.setTerminal(request.getTerminal());
                            peticion.setPassword(request.getPassword());
                            response.setFechaPlanificacion(util.formatearFechaGeneral(datos.getResponseBansefi().getOTR_CONSUL_AN_PANT_TRN_O().getTR_CONSUL_AN_PANT_EVT_Z().getAN_ANTCN_V().getFECHA_PLANIF()));
                            response.setFechaUltimaModificacion(util.formatearFechaGeneral(datos.getResponseBansefi().getOTR_CONSUL_AN_PANT_TRN_O().getTR_CONSUL_AN_PANT_EVT_Z().getAN_ANTCN_E().getFECHA_ULT_MODIF()));
                            response.setIdEmpleado(datos.getResponseBansefi().getOTR_CONSUL_AN_PANT_TRN_O().getTR_CONSUL_AN_PANT_EVT_Z().getAN_ANTCN_E().getID_INTERNO_EMPL_EP());
                            try{

                                peticion.setIdInternoEmp(response.getIdEmpleado());
                                jsonRes = this.util.callRestPost(peticion, urlConsultaDatosEmpleado);
                                empleado = (PeConsIndvObjDTO) this.util.jsonToObject(empleado, jsonRes, nodos);
                                if (empleado.getNOMB_50().equals("")){
                                    response.setNombreEmpleado("");
                                }else{
                                    response.setNombreEmpleado(empleado.getNOMB_50());
                                }


                            }catch (Exception e){
                                response.setNombreEmpleado("no hay");

                            }
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
    /* Consulta liquidaciones de un movimiento */
    @SuppressWarnings("unchecked")
    public ResConsultaLiquidacionDTO consultaLiquidacion(ReqConsultaLiquidacionDTO request) {
        ResConsultaLiquidacionDTO response = new ResConsultaLiquidacionDTO();
        ResGralDTO cabecera = new ResGralDTO();
        ConsultaLiquidacionDTO datos = new ConsultaLiquidacionDTO();
        String jsonRes = "";
        request.setAcuerdo(request.getAcuerdo() == null ? "" : request.getAcuerdo());
        request.setDetalle(request.getDetalle() == null ? "" : request.getDetalle());
        request.setEntidad(request.getEntidad() == null ? "" : request.getEntidad());
        request.setFechaLiquidacion(request.getFechaLiquidacion() == null ? "" : request.getFechaLiquidacion());
        request.setLiqOpcion(request.getLiqOpcion() == null ? "" : request.getLiqOpcion());
        request.setPassword(request.getPassword() == null ? "" : request.getPassword());
        request.setTerminal(request.getTerminal() == null ? "" : request.getTerminal());
        request.setUsuario(request.getUsuario() == null ? "" : request.getUsuario());
        if (request.getAcuerdo().equals("") || request.getEntidad().equals("") || request.getPassword().equals("")
                || request.getTerminal().equals("") || request.getUsuario().equals("")
                || request.getDetalle().equals("") || request.getLiqOpcion().equals("")
                || request.getFechaLiquidacion().equals("")) {
            cabecera.setStatus(statusIncorrecto);
            cabecera.setMensaje(errorGeneral + errornoRequest);
            response.setCabecera(cabecera);
        } else {
            jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaLiquidacion);
            System.out.println(jsonRes + ",");

            if (!jsonRes.equals("")) {
                ArrayList<String> nodos = new ArrayList<String>();
                nodos.add(ejecutarResponse);
                nodos.add(ejecutarResult);
                try {
                    datos = (ConsultaLiquidacionDTO) this.util.jsonToObject(datos, jsonRes, nodos);
                    if (datos.getTRANID().equals(errornoFirmado)) {
                        cabecera.setMensaje(errorGeneral + errorUsuario);
                        cabecera.setStatus(statusIncorrecto);
                        response.setCabecera(cabecera);
                    }

                    else {

                        if (Integer.valueOf(
                                datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O().getOCCURS_NR()) == 0) {
                            ArrayList<ResErrorDTO> lista = new ArrayList<ResErrorDTO>();
                            for (int i = 0; i < datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                    .getSTD_TRN_MSJ_PARM_V().size(); i++) {
                                ResErrorDTO errores = new ResErrorDTO();
                                errores.setCodigo(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                        .getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
                                errores.setMensaje(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                        .getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
                                lista.add(errores);
                            }
                            cabecera.setErrores(lista);
                            cabecera.setMensaje(errorGeneral +":"+datos.getCODIGO()+"-"+ datos.getMENSAJE());
                            cabecera.setStatus(statusIncorrecto+"-"+statusTCB+datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O().getRTRN_CD());
                            response.setCabecera(cabecera);
                        } else {
                            ArrayList<ListaLiquidacionDTO> liquidaciones = new ArrayList<ListaLiquidacionDTO>();

                            response.setAcuerdo(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                    .getTR_LIQ_CONS_BASICA_EVT_Z().getHL_HCO_LIQ_E().getNUM_SEC_AC());
                            ;
                            response.setFechaDesde(
                                    util.formatearFechaGeneral(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                            .getTR_LIQ_CONS_BASICA_EVT_Z().getHL_HCO_LIQ_E().getFECHA_DESDE()));
                            response.setFechaHasta(
                                    util.formatearFechaGeneral(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                            .getTR_LIQ_CONS_BASICA_EVT_Z().getHL_HCO_LIQ_E().getFECHA_HASTA()));
                            response.setFechaLiquidacion(
                                    util.formatearFechaGeneral(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                            .getTR_LIQ_CONS_BASICA_EVT_Z().getHL_HCO_LIQ_E().getFECHA_LIQ()));
                            response.setFechaUltimoCobro(
                                    util.formatearFechaGeneral(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                            .getTR_LIQ_CONS_BASICA_EVT_Z().getHL_HCO_LIQ_E().getFECHA_ULT_COBRO()));
                            response.setSituacion(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                    .getTR_LIQ_CONS_BASICA_EVT_Z().getHL_HCO_LIQ_E().getSITUACION_HL());
                            response.setCodigoOperacionLiquidacion(
                                    datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                            .getTR_LIQ_CONS_BASICA_EVT_Z().getHL_HCO_LIQ_E().getCOD_OPER_LIQ());
                            response.setMoneda(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                    .getTR_LIQ_CONS_BASICA_EVT_Z().getHL_HCO_LIQ_E().getCOD_NUMRCO_MONEDA());
                            response.setImporteTotal(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                    .getTR_LIQ_CONS_BASICA_EVT_Z().getHL_HCO_LIQ_E().getIMP_TOTAL_LIQ());
                            response.setImportePendiente(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                    .getTR_LIQ_CONS_BASICA_EVT_Z().getHL_HCO_LIQ_E().getIMP_PEND_LIQ());
                            for (int i = 0; i < Integer.valueOf(datos.getResponseBansefi()
                                    .getOTR_LIQ_CONS_BASICA_TRN_O().getTR_LIQ_CONS_BASICA_EVT_Z()
                                    .getLIQ_APUNTE_BAS_LST().getNUMBER_OF_RECORDS()); i++) {
                                ListaLiquidacionDTO nodo = new ListaLiquidacionDTO();
                                nodo.setCodigoOrigen(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                        .getTR_LIQ_CONS_BASICA_EVT_Z().getLIQ_APUNTE_BAS_LST().getLIQ_APUNTE_BAS_V()
                                        .get(i).getCOD_CTA());
                                nodo.setImporteAjustado(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                        .getTR_LIQ_CONS_BASICA_EVT_Z().getLIQ_APUNTE_BAS_LST().getLIQ_APUNTE_BAS_V()
                                        .get(i).getIMP_AJUSTADO_V().getIMP_SDO());
                                nodo.setImporteCondonado(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                        .getTR_LIQ_CONS_BASICA_EVT_Z().getLIQ_APUNTE_BAS_LST().getLIQ_APUNTE_BAS_V()
                                        .get(i).getIMP_CONDONADO_V().getIMP_SDO());
                                nodo.setImporteFacturado(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                        .getTR_LIQ_CONS_BASICA_EVT_Z().getLIQ_APUNTE_BAS_LST().getLIQ_APUNTE_BAS_V()
                                        .get(i).getIMP_FACTURADO_V().getIMP_SDO());
                                nodo.setImportePendiente(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                        .getTR_LIQ_CONS_BASICA_EVT_Z().getLIQ_APUNTE_BAS_LST().getLIQ_APUNTE_BAS_V()
                                        .get(i).getIMP_PENDIENTE_V().getIMP_SDO());
                                liquidaciones.add(nodo);
                            }
                            response.setLiquidaciones(liquidaciones);
                            System.out.print(datos.getResponseBansefi().getOTR_LIQ_CONS_BASICA_TRN_O()
                                    .getTR_LIQ_CONS_BASICA_EVT_Z().getLIQ_APUNTE_BAS_LST().getLIQ_APUNTE_BAS_V().get(0)
                                    .getIMP_FACTURADO_V().getIMP_SDO());
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
    /* Consulta detalles de una transaccion */
    @SuppressWarnings("unchecked")
    public ResConsultaDetalleTransaccionDTO consultaDetalletransaccion(ReqConsultaDetalleTransaccionDTO request) {
        ResConsultaDetalleTransaccionDTO response = new ResConsultaDetalleTransaccionDTO();
        ReqConsultaCatalogoDTO liq= new ReqConsultaCatalogoDTO();

        ResGralDTO cabecera = new ResGralDTO();
        ConsultaDetalleApunteDTO datos = new ConsultaDetalleApunteDTO();
        request.setAcuerdo(request.getAcuerdo() == null ? "" : request.getAcuerdo());
        request.setCodapunte(request.getCodapunte() == null ? "" : request.getCodapunte());
        request.setCodcuenta(request.getCodcuenta() == null ? "" : request.getCodcuenta());
        request.setCodorigen(request.getCodorigen() == null ? "" : request.getCodorigen());
        request.setDetalle(request.getDetalle() == null ? "" : request.getDetalle());
        request.setEntidad(request.getEntidad() == null ? "" : request.getEntidad());
        request.setFecha(request.getFecha() == null ? "" : request.getFecha());
        request.setImporte(request.getImporte() == null ? "" : request.getImporte());
        request.setSigno(request.getSigno() == null ? "" : request.getSigno());
        request.setPassword(request.getPassword() == null ? "" : request.getPassword());
        request.setTerminal(request.getTerminal() == null ? "" : request.getTerminal());
        request.setUsuario(request.getUsuario() == null ? "" : request.getUsuario());
        if (request.getAcuerdo().equals("") || request.getCodapunte().equals("") || request.getCodcuenta().equals("")
                || request.getCodorigen().equals("") || request.getDetalle().equals("")
                || request.getEntidad().equals("") || request.getFecha().equals("") || request.getImporte().equals("")
                || request.getPassword().equals("") || request.getSigno().equals("") || request.getTerminal().equals("")
                || request.getUsuario().equals("")) {
            cabecera.setStatus(statusIncorrecto);
            cabecera.setMensaje(errorGeneral + errornoRequest);
            response.setCabecera(cabecera);
            return response;
        } else {
            try {
                System.out.println(urlRootContext + urlConsultaDetalleTransaccion);
                String jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaDetalleTransaccion);
                System.out.println(jsonRes);
                if (!jsonRes.equals("")) {
                    ArrayList<String> nodos = new ArrayList<String>();
                    nodos.add(ejecutarResponse);
                    nodos.add(ejecutarResult);
                    datos = (ConsultaDetalleApunteDTO) this.util.jsonToObject(datos, jsonRes, nodos);
                    if (datos.getTRANID().equals(errornoFirmado)) {
                        cabecera.setMensaje(errorGeneral + errorUsuario);
                        cabecera.setStatus(statusIncorrecto);
                        response.setCabecera(cabecera);
                    } else {
                        if (Integer.valueOf(datos.getESTATUS())==0) {
                            try {
                                liq.setCatalogo(catalogoLiquidacion);
                                liq.setCodigo(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getCOD_ORIGEN());
                                liq.setUsuario(request.getUsuario());
                                liq.setPassword(request.getPassword());
                                String informacion = this.util.callRestPost(liq,urlconsultaCatalogos);
                                CatalogoDTO texto= new CatalogoDTO();
                                texto=(CatalogoDTO) util.jsonToObject(texto,informacion,nodos);
                                response.setTexto(texto.getResponseBansefi().getResponseBansefi().getDESCRIPCION_LARGA_FL());
                            }catch(Exception e){
                                response.setTexto("");
                            }
                            response.setConcepto(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getCONCPT_APNTE());
                            response.setEstado(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getPRPDAD_CTA());
                            response.setFechaContable(
                                    util.formatearFechaGeneral(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                            .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getFECHA_CTBLE()));
                            response.setFechaValor(
                                    util.formatearFechaGeneral(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                            .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getFECHA_VALOR()));
                            response.setImporte(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIMP_APNTE());
                            response.setIndicador1(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1() == null ? ""
                                    : datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1());
                            response.setIndicador2(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1() == null ? ""
                                    : datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_2());
                            response.setIndicador3(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1() == null ? ""
                                    : datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_3());
                            response.setIndicador4(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1() == null ? ""
                                    : datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_4());
                            response.setIndicador5(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1() == null ? ""
                                    : datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_5());
                            response.setIndicador6(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1() == null ? ""
                                    : datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_6());
                            response.setIndicador7(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1() == null ? ""
                                    : datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_7());
                            response.setIndicador8(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1() == null ? ""
                                    : datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_8());
                            response.setIndicador9(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1() == null ? ""
                                    : datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_9());
                            response.setIndicador10(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_1() == null ? ""
                                    : datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getIND_10());
                            response.setMoneda(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getCOD_NUMRCO_MONEDA());
                            response.setNombre(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getNOMB_50());
                            response.setNumero(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getNUM_SEC());
                            response.setProducto(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getDESCR_PDV_V().getNOMB_PDV());
                            response.setTipoOperacion(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getCOD_ORIGEN());
                            response.setTipoCuenta(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getTR_AF_CONS_APUNTE_EVT_Z().getAF_APNTE_E().getCOD_CTA());
                            ReqCatalogoClienteDTO nada= new ReqCatalogoClienteDTO();
                            nada.setCodigo(response.getTipoCuenta());
                            System.out.println(urlRootContext+urlcatalogoCuenta);
                            String catalogo= util.callRestPost(nada,urlRootContext+urlcatalogoCuenta);
                            System.out.println(catalogo);
                            CuentaDTO cuenta= new CuentaDTO();
                            ArrayList<String> nodelist= new ArrayList<>();
                            nodelist.add(tipo);
                            cuenta=(CuentaDTO)util.jsonToObject(cuenta,catalogo,nodelist);
                            response.setTipoDescripcion(cuenta.getDescripcion().getDESCR_CTA());
                            cabecera.setMensaje(datos.getMENSAJE());
                            cabecera.setStatus(statusCorrecto);
                            response.setCabecera(cabecera);
                        } else {

                            ArrayList<ResErrorDTO> lista = new ArrayList<ResErrorDTO>();
                            for (int i = 0; i < datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                    .getSTD_TRN_MSJ_PARM_V().size(); i++) {
                                ResErrorDTO errores = new ResErrorDTO();
                                errores.setCodigo(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                        .getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
                                errores.setMensaje(datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O()
                                        .getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
                                lista.add(errores);
                            }
                            cabecera.setErrores(lista);
                            cabecera.setMensaje(errorGeneral+":"+datos.getCODIGO()+"-"+datos.getMENSAJE());
                            cabecera.setStatus(statusIncorrecto+"-"+statusTCB+datos.getResponseBansefi().getOTR_AF_CONS_APUNTE_TRN_O().getRTRN_CD());
                            response.setCabecera(cabecera);
                        }
                    }
                } else {
                    cabecera.setStatus(statusIncorrecto);
                    cabecera.setMensaje(errorGeneral + errornoRequest);
                    response.setCabecera(cabecera);
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.printStackTrace();
                cabecera.setMensaje(errorParseo + e.getMessage());
                response.setCabecera(cabecera);
            }
        }

        return response;
    }
    /* Consulta la auditoria de un movimiento */
    @SuppressWarnings("unchecked")
    public ResConsultaAuditoriaDTO consultaAuditoria(ReqConsultaAuditoriaDTO request) {
        ResConsultaAuditoriaDTO response = new ResConsultaAuditoriaDTO();
        ConsultaAuditoriaDTO datos = new ConsultaAuditoriaDTO();
        ResGralDTO cabecera = new ResGralDTO();
        String jsonRes = "";
        request.setEntidad(request.getEntidad() == null ? "" : request.getEntidad());
        request.setAcuerdo(request.getAcuerdo() == null ? "" : request.getAcuerdo());
        request.setPassword(request.getPassword() == null ? "" : request.getPassword());
        request.setTerminal(request.getTerminal() == null ? "" : request.getTerminal());
        request.setUsuario(request.getUsuario() == null ? "" : request.getUsuario());
        request.setCodcuenta(request.getCodcuenta() == null ? "" : request.getCodcuenta());
        request.setDetalle(request.getDetalle() == null ? "" : request.getDetalle());
        if (request.getAcuerdo().equals("") || request.getCodcuenta().equals("") || request.getDetalle().equals("")
                || request.getEntidad().equals("") || request.getPassword().equals("")
                || request.getTerminal().equals("") || request.getUsuario().equals("")) {
            cabecera.setStatus(statusIncorrecto);
            cabecera.setMensaje(errorGeneral + errornoRequest);
            response.setCabecera(cabecera);
        } else {
            jsonRes = this.util.callRestPost(request, urlRootContext + urlConsultaAuditoria);
            System.out.println(jsonRes);

            if (!jsonRes.equals("")) {
                ArrayList<String> nodos = new ArrayList<String>();
                nodos.add(ejecutarResponse);
                nodos.add(ejecutarResult);
                try {
                    datos = (ConsultaAuditoriaDTO) this.util.jsonToObject(datos, jsonRes, nodos);
                    if (datos.getTRANID().equals(errornoFirmado)) {
                        cabecera.setMensaje(errorGeneral + errorUsuario);
                        cabecera.setStatus(statusIncorrecto);
                        response.setCabecera(cabecera);
                    }

                    else {

                        if (Integer.valueOf(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O().getNUMBER_OF_RECORDS())==0 || Integer.valueOf(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O().getRTRN_CD())==7) {
                            ArrayList<ResErrorDTO> lista = new ArrayList<ResErrorDTO>();
                            for (int i = 0; i < datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                    .getSTD_TRN_MSJ_PARM_V().size(); i++) {
                                ResErrorDTO errores = new ResErrorDTO();
                                errores.setCodigo(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                        .getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_CODE());
                                errores.setMensaje(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                        .getSTD_TRN_MSJ_PARM_V().get(i).getTEXT_ARG1());
                                lista.add(errores);
                            }
                            cabecera.setErrores(lista);
                            cabecera.setMensaje(errorGeneral +":"+datos.getCODIGO()+"-"+ datos.getMENSAJE());
                            cabecera.setStatus(statusIncorrecto+"-"+statusTCB+datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O().getRTRN_CD());
                            response.setCabecera(cabecera);
                        } else {
                            ArrayList<String> nodelist= new ArrayList<>();
                            nodelist.add(ejecutarResponse);
                            nodelist.add(ejecutarResult);
                            nodelist.add("ResponseBansefi");
                            nodelist.add("OTR_CONS_CENTRO_TRN_O");
                            nodelist.add("TR_CONS_CENTRO_EVT_Z");
                            ResConsultaDatosSucursalDTO sucursal= new ResConsultaDatosSucursalDTO();
                            ReqConsultaDatosSucursalDTO requestSucursal= new ReqConsultaDatosSucursalDTO();
                            requestSucursal.setEntidad(request.getEntidad());
                            requestSucursal.setPassword(request.getPassword());
                            requestSucursal.setTerminal(request.getTerminal());
                            requestSucursal.setUsuario(request.getUsuario());
                            nodos.add("ResponseBansefi");
                            nodos.add("OTR_CONS_EMPL_TRN_O");
                            nodos.add("TR_CONS_EMPL_EVT_Z");
                            nodos.add("PE_CONS_INDV_OBJ_TRD_V");
                            PeConsIndvObjDTO empleado= new PeConsIndvObjDTO();
                            ReqConsultaDatosEmpleadoDTO peticion= new ReqConsultaDatosEmpleadoDTO();
                            peticion.setEntidad(request.getEntidad());
                            peticion.setUsuario(request.getUsuario());
                            peticion.setTerminal(request.getTerminal());
                            peticion.setPassword(request.getPassword());
                            ArrayList<ListaConsutaAuditoriaDTO> auditorias = new ArrayList<ListaConsutaAuditoriaDTO>();
                            for (int i = 0; i < Integer.valueOf(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                    .getNUMBER_OF_RECORDS()); i++) {
                                ListaConsutaAuditoriaDTO nodo = new ListaConsutaAuditoriaDTO();
                                nodo.setCentro(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                        .getTR_TX_CONS_AUDIT_EVT_Z().getAF_AUDIT_E().get(i).getCOD_INTERNO_UO());
                                nodo.setCodigo(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                        .getTR_TX_CONS_AUDIT_EVT_Z().getAF_AUDIT_E().get(i).getCOD_TX());
                                nodo.setTerminal(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                        .getTR_TX_CONS_AUDIT_EVT_Z().getAF_AUDIT_E().get(i).getID_INTERNO_TERM_TN());

                                nodo.setFechaContable(util
                                        .formatearFechaGeneral(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                                .getTR_TX_CONS_AUDIT_EVT_Z().getAF_AUDIT_E().get(i).getFECHA_CTBLE()));
                                nodo.setAutorizador(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                        .getTR_TX_CONS_AUDIT_EVT_Z().getAF_AUDIT_E().get(i).getID_EMPL_AUT() == null
                                        ? ""
                                        : datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                        .getTR_TX_CONS_AUDIT_EVT_Z().getAF_AUDIT_E().get(i)
                                        .getID_EMPL_AUT());
                                nodo.setEmpleado(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                        .getTR_TX_CONS_AUDIT_EVT_Z().getAF_AUDIT_E().get(i).getID_INTERNO_EMPL_EP());
                                nodo.setEstado(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                        .getTR_TX_CONS_AUDIT_EVT_Z().getAF_AUDIT_E().get(i).getPRPDAD_CTA());
                                nodo.setHoraOperacion(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                        .getTR_TX_CONS_AUDIT_EVT_Z().getAF_AUDIT_E().get(i).getHORA_OPRCN());
                                nodo.setFechaOperacion(util
                                        .formatearFechaGeneral(datos.getResponseBansefi().getOTR_TX_CONS_AUDIT_TRN_O()
                                                .getTR_TX_CONS_AUDIT_EVT_Z().getAF_AUDIT_E().get(i).getFECHA_OPRCN()));
                                try{

                                    peticion.setIdInternoEmp(nodo.getEmpleado());
                                    jsonRes = this.util.callRestPost(peticion, urlConsultaDatosEmpleado);
                                    System.out.println("empleado:"+jsonRes);
                                    empleado = (PeConsIndvObjDTO) this.util.jsonToObject(empleado, jsonRes, nodos);
                                    System.out.println(empleado.getID_INTERNO_PE()+":"+empleado.getNOMB_IN_NOMB_PILA()+":"+empleado.getID_EXT_PE());
                                    Optional.ofNullable(empleado.getNOMB_50()).orElse("");
                                    if (empleado.getNOMB_50().equals("")){
                                        nodo.setNombreEmpleado("");
                                    }else{
                                        nodo.setNombreEmpleado(empleado.getNOMB_50());
                                    }


                                }catch (Exception e){
                                    nodo.setNombreEmpleado("no hay");

                                }
                                try{
                                    requestSucursal.setCentro(nodo.getCentro());
                                    jsonRes=util.callRestPost(requestSucursal,urlConsultaDatosSucursal);
                                    System.out.println("sucursal:"+jsonRes);
                                    sucursal=(ResConsultaDatosSucursalDTO) util.jsonToObject(sucursal,jsonRes,nodelist);
                                    nodo.setNombreCentro(sucursal.getUO_CENTRO_E().getNOMB_CENT_UO());
                                    requestSucursal.setCentro(request.getSucursal());
                                    jsonRes=util.callRestPost(requestSucursal,urlConsultaDatosSucursal);
                                    sucursal=(ResConsultaDatosSucursalDTO) util.jsonToObject(sucursal,jsonRes,nodelist);
                                    nodo.setNombreSucursal(sucursal.getUO_CENTRO_E().getNOMB_CENT_UO());

                                }catch (Exception e){
                                    nodo.setNombreCentro("No hay");
                                    nodo.setNombreSucursal("No hay");
                                }
                                auditorias.add(nodo);
                            }
                            cabecera.setMensaje(datos.getMENSAJE());
                            cabecera.setStatus(statusCorrecto);
                            response.setCabecera(cabecera);
                            response.setAuditorias(auditorias);

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

}
