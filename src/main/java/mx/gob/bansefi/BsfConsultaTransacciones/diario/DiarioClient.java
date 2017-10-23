package mx.gob.bansefi.BsfConsultaTransacciones.diario;

import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.ConsultaAnotacionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.ReqConsultaAnotacionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author Ivan Solorio
 * @version 1.0 - 2017/10/12
 */
@Component
public class DiarioClient {
    public Util util;
    @Value("${diario}")
    private String diario;
    @Value("${codtx.anotacion}")
    private String codTxAnotacion;
    @Value("${situacion.norm}")
    private String situacion;
    @Autowired
    public DiarioClient(Util util){
        this.util=util;
    }
    public ResponseService InsertaDiario(ReqConsultaAnotacionesDTO request, ConsultaAnotacionesDTO datos,NumSecDTO numSec) {
        ResponseService response = new ResponseService();

        String outputString = "";
        String xml ="";
        Date date = new Date();
        String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
        try
        {
            String action = "urn:InsertaDiarioElectronico";
            xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:dat=\"http://ws.wso2.org/dataservice\">"
                    +"<soapenv:Header/>"
                    +"<soapenv:Body>"
                    +"<dat:InsertaDiarioElectronico>"
                    +"<dat:idInternoTermTn>" +request.getTerminal()+ "</dat:idInternoTermTn>"
                    +"<dat:numSec>"+numSec.getNumSec()+ "</dat:numSec>"
                    +"<dat:codTx>"+codTxAnotacion+ "</dat:codTx>"
                    +"<dat:codTxDi>" +""+ "</dat:codTxDi>"
                    +"<dat:idInternoEmplEp>"+request.getUsuario()+"</dat:idInternoEmplEp>"
                    +"<dat:contrida>" +""+ "</dat:contrida>"
                    +"<dat:sgnCtbleDi>" +""+ "</dat:sgnCtbleDi>"
                    +"<dat:masMenosDi>" +String.valueOf(BigDecimal.ZERO)+ "</dat:masMenosDi>"
                    +"<dat:numSecAc>" +Integer.valueOf(request.getAcuerdo())+ "</dat:numSecAc>"
                    +"<dat:impNominal>" +String.valueOf(BigDecimal.ZERO)+ "</dat:impNominal>"
                    +"<dat:codNumrcoMoneda>" +"MXN"+ "</dat:codNumrcoMoneda>"
                    +"<dat:impSdo>" +String.valueOf(BigDecimal.ZERO)+ "</dat:impSdo>"
                    +"<dat:codNumrcoMoneda1>" +""+ "</dat:codNumrcoMoneda1>"
                    +"<dat:codErr1>" +datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(0).getTEXT_CODE()+ "</dat:codErr1>"
                    +"<dat:codErr2>" +datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(1).getTEXT_CODE()+ "</dat:codErr2>"
                    +"<dat:codErr3>" +datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(2).getTEXT_CODE()+ "</dat:codErr3>"
                    +"<dat:codErr4>" +datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(3).getTEXT_CODE()+ "</dat:codErr4>"
                    +"<dat:codErr5>" +datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(4).getTEXT_CODE()+ "</dat:codErr5>"
                    +"<dat:modoTx>" + "0"+ "</dat:modoTx>"
                    +"<dat:situTx>" +"00"+ "</dat:situTx>"
                    +"<dat:valorDtllTx>" +"OFICINA"+ "</dat:valorDtllTx>"
                    +"<dat:idEmplAut>" +request.getUsuario()+ "</dat:idEmplAut>"
                    +"<dat:fechaAnul>"+"1111-11-11"+"</dat:fechaAnul>"
                    +"<dat:idTermAnul>" +""+ "</dat:idTermAnul>"
                    +"<dat:idEmplAnul>" +""+ "</dat:idEmplAnul>"
                    +"<dat:numSecAnul>" + String.valueOf(BigDecimal.ZERO) + "</dat:numSecAnul>"
                    +"<dat:codRespuesta>" +datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getRTRN_CD()+ "</dat:codRespuesta>"
                    +"<dat:codNrbeEn>" +request.getEntidad()+ "</dat:codNrbeEn>"
                    +"<dat:codInternoUo>" +request.getSucursal()+ "</dat:codInternoUo>"
                    +"<dat:codNrbeEnFsc>" +request.getEntidad()+ "</dat:codNrbeEnFsc>"
                    +"<dat:codInternoUoFsc>" +request.getSucursal()+ "</dat:codInternoUoFsc>"
                    +"<dat:fechaOprcn>" +util.formatearFechaBase(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_O_PARM_V().getFECHA_OPRCN())+ "</dat:fechaOprcn>"
                    +"<dat:horaOprcn>" +util.formatearHoraGeneral(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_O_PARM_V().getHORA_OPRCN())+ "</dat:horaOprcn>"
                    +"<dat:fechaCtble>" +util.formatearFechaBase(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getTR_CONSUL_AN_ANOT_PANT_EV().getAN_ANTCN_E().get(0).getFECHA_ULT_MODIF())+ "</dat:fechaCtble>"
                    +"<dat:fechaValor>"+"1111-11-11"+"</dat:fechaValor>"
                    +"<dat:codClopSist>" +""+ "</dat:codClopSist>"
                    +"<dat:tipoSbclop>" + "" + "</dat:tipoSbclop>"
                    +"<dat:numPuesto>" +numSec.getNumPuesto()+ "</dat:numPuesto>"
                    +"<dat:fechaOff>"+"1111-11-11"+"</dat:fechaOff>"
                    +"<dat:idTermOff/>"
                    +"<dat:idEmplOff/>"
                    +"<dat:numSecOff>" +String.valueOf(BigDecimal.ZERO)+ "</dat:numSecOff>"
                    +"<dat:impNominalX>" +String.valueOf(BigDecimal.ZERO)+ "</dat:impNominalX>"
                    +"<dat:claveAnulDi>" +"     "+ "</dat:claveAnulDi>"
                    +"<dat:diTextArg1>" + new String(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(0).getTEXT_ARG1()==null?"":datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(0).getTEXT_ARG1())+ "</dat:diTextArg1>"
                    +"<dat:diTextArg2>" + new String(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(0).getTEXT_ARG1()==null?"":datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(1).getTEXT_ARG1()) + "</dat:diTextArg2>"
                    +"<dat:diTextArg3>" + new String(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(0).getTEXT_ARG1()==null?"":datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(2).getTEXT_ARG1())+ "</dat:diTextArg3>"
                    +"<dat:diTextArg4>" + new String(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(0).getTEXT_ARG1()==null?"":datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(3).getTEXT_ARG1())+ "</dat:diTextArg4>"
                    +"<dat:diTextArg5>" + new String(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(0).getTEXT_ARG1()==null?"":datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_MSJ_PARM_V().get(4).getTEXT_ARG1())+ "</dat:diTextArg5>"
                    +"<dat:fechaPc>" +modifiedDate+ "</dat:fechaPc>"
                    +"<dat:horaPc>" +util.formatearHoraGeneral(datos.getResponseBansefi().getOTR_CONSUL_AN_ANOT_PANT_T().getSTD_TRN_O_PARM_V().getHORA_OPRCN())+"</dat:horaPc>"
                    +"</dat:InsertaDiarioElectronico>"
                    +"</soapenv:Body>"
                    +"</soapenv:Envelope>";
            outputString=util.SalidaResponse(xml,diario,action,"");
            System.out.println(outputString);
            if(outputString.contains("SUCCESSFUL"))
            {
                response.setStatus(1);
                response.setDescripcion("EXITO");
            } else {

                response.setStatus(0);
                response.setDescripcion(outputString);
            }
        }
        catch (Exception e)
        {
            response.setStatus(-1);
            response.setDescripcion(e.getMessage());

        }
        return response;
    }
    public NumSecDTO obtenerNumSec(ReqConsultaAnotacionesDTO request){
        NumSecDTO datos= new NumSecDTO();
        String outputString = "";
        String action="urn:GetNumSec";
        String xml ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:dat=\"http://ws.wso2.org/dataservice\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <dat:GetNumSec>\n" +
                "         <dat:ENTIDAD>"+request.getEntidad()+"</dat:ENTIDAD>\n" +
                "         <dat:CENTRO>"+request.getSucursal()+"</dat:CENTRO>\n" +
                "         <dat:TERMINAL>"+request.getTerminal()+"</dat:TERMINAL>\n" +
                "      </dat:GetNumSec>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        outputString=util.SalidaResponse(xml,diario,action,"");
        Document doc = util.xmlToDocumentXML(outputString);
        xml="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:dat=\"http://ws.wso2.org/dataservice\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <dat:UpdateNumSec>\n" +
                "         <dat:ENTIDAD>"+request.getEntidad()+"</dat:ENTIDAD>\n" +
                "         <dat:CENTRO>"+request.getSucursal()+"</dat:CENTRO>\n" +
                "         <dat:TERMINAL>"+request.getTerminal()+"</dat:TERMINAL>\n" +
                "      </dat:UpdateNumSec>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        action="urn:UpdateNumSec";
        outputString=util.SalidaResponse(xml,diario,action,"");
        System.out.println("actualiza"+outputString);
        if(Objects.nonNull(doc) && outputString.contains("SUCCESSFUL")){
            NodeList nodes = doc.getElementsByTagName("NumSecM");
            Node item = nodes.item(0);
            Element eElement = (Element) item;
            datos.setNumSec(eElement.getElementsByTagName("num_sec").item(0).getTextContent());
            datos.setNumPuesto(eElement.getElementsByTagName("num_puesto").item(0).getTextContent());
        }
        else
        {
            datos.setNumPuesto("0");
            datos.setNumSec("-1");
        }
        return datos;
    }
}
