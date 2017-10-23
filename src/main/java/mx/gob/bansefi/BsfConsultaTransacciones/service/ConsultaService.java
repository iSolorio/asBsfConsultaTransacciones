package mx.gob.bansefi.BsfConsultaTransacciones.service;

import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.ConsultaAnotacionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.ListaAnotacionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.ReqConsultaAnotacionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.ResConsultaAnotacionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.consultaTextoAnotacion.ConsultaTextoAnotacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.consultaTextoAnotacion.ReqConsultaTextoAnotacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleAnotacion.ConsultaDetalleAnotacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleAnotacion.ReqConsultaDetalleAnotacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleAnotacion.ResConsultaDetalleAnotacionDTO;
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
    @Value("${url.consultaAnotaciones}")
    private String urlConsultaAnotaciones;
    @Value("${url.consultaDetalleAnotacion}")
    private String urlConsultaDetalleAnotacion;
    @Value("${url.consultaCatalogos}")
    private String urlConsultaCatalogos;
    @Value("${catalogo.anotaciones}")
    private String catalogoAnotaciones;

    @Value("${catalogo.area}")
    private String catalogoArea;
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
    @Value("${nodo.EjecutarResponse}")
    private String ejecutarResponse;
    @Value("${nodo.EjecutarResult}")
    private String ejecutarResult;
    @Value("${nodo.Ceros}")
    private String Ceros;
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

        if (request.getAcuerdo().equals("") || request.getEntidad().equals("") || request.getPassword().equals("")
                || request.getTerminal().equals("") || request.getUsuario().equals("")
                || request.getAntAlerta().equals("") || request.getAntAvisos().equals("") || request.getAntImperativa().equals("") || request.getAntInformativa().equals("")) {
            cabecera.setStatus(statusIncorrecto);
            cabecera.setMensaje(errorGeneral + errornoRequest);
            response.setCabecera(cabecera);
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
                            cabecera.setMensaje(errorGeneral + datos.getMENSAJE());
                            cabecera.setStatus(datos.getCODIGO());
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
                            cabecera.setStatus(datos.getCODIGO());
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
                            cabecera.setMensaje(errorGeneral + datos.getMENSAJE());
                            cabecera.setStatus(datos.getCODIGO());
                            response.setCabecera(cabecera);
                        } else {

                            response.setFechaPlanificacion(util.formatearFechaGeneral(datos.getResponseBansefi().getOTR_CONSUL_AN_PANT_TRN_O().getTR_CONSUL_AN_PANT_EVT_Z().getAN_ANTCN_V().getFECHA_PLANIF()));
                            response.setFechaUltimaModificacion(util.formatearFechaGeneral(datos.getResponseBansefi().getOTR_CONSUL_AN_PANT_TRN_O().getTR_CONSUL_AN_PANT_EVT_Z().getAN_ANTCN_E().getFECHA_ULT_MODIF()));
                            response.setIdEmpleado(datos.getResponseBansefi().getOTR_CONSUL_AN_PANT_TRN_O().getTR_CONSUL_AN_PANT_EVT_Z().getAN_ANTCN_E().getID_INTERNO_EMPL_EP());
                            cabecera.setMensaje(datos.getMENSAJE());
                            cabecera.setStatus(datos.getCODIGO());
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
}
