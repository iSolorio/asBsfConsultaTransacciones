package mx.gob.bansefi.BsfConsultaTransacciones.Util;


import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Autor: Jose Angel Hernandez Gonzalez
 * Fecha: 29/03/2017
 */
@Component
public final class Util<T> {

    /*
     * Definicion de variables de clase
     */
    @SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(Util.class);
    private SimpleDateFormat formatoGeneralFecha = new SimpleDateFormat("dd/MM/yyyy");

    /*
    * Metodo utilitario para convertir un json a un objeto.
    */
    public Object jsonToObject(T objectRes, String json, ArrayList<String> nodos) throws ParseException {
        Gson gson = new Gson();
        JSONParser parser = new JSONParser();
        Object objRes = parser.parse(json);
        JSONObject jsonObject  = (JSONObject) objRes;
        for (String nodo : nodos){
            jsonObject = (JSONObject) jsonObject.get(nodo);
        }
        String jsonResponse = jsonObject.toJSONString();
        System.out.println(jsonResponse);
        try {
            return gson.fromJson(jsonResponse, ((T)objectRes).getClass());
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }
    @SuppressWarnings("unused")
	public String jsonToString(T objectRes, String json, ArrayList<String> nodos) throws ParseException {
        Gson gson = new Gson();
        JSONParser parser = new JSONParser();
        Object objRes = parser.parse(json);
        JSONObject jsonObject  = (JSONObject) objRes;
        for (String nodo : nodos){
            jsonObject = (JSONObject) jsonObject.get(nodo);
        }
        String jsonResponse = jsonObject.toJSONString();
       return jsonResponse;
       
    }
    /*
     * Metodo utilitario para convertir un objeto a un json.
     */
    public String objectToJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    /*
     * Metodo utilitario para realizar llamada REST por el metodo POST
     */
    public String callRestPost(Object obj, String uri) {
        String output = "";
        try {
            String input = objectToJson(obj);
            URL restServiceURL = new URL(uri);
            HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            OutputStream outputStream = httpConnection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + httpConnection.getResponseCode());
            }
            BufferedReader responseBuffer = new BufferedReader(
                    new InputStreamReader((httpConnection.getInputStream()), "UTF8"));
            String outputline;
            while ((outputline = responseBuffer.readLine()) != null) {
                output += outputline;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }
 
    /*
     * Metodo utilitario para limpiar mensajes de error
     */
    public ArrayList<mx.gob.bansefi.BsfConsultaTransacciones.DTO.ErrorDTO> limpiaMesajesErrores(ArrayList<mx.gob.bansefi.BsfConsultaTransacciones.DTO.ErrorDTO> errores){
		for (int i=0; i<errores.size();i++) {
			if(errores.get(i).getTEXT_CODE().equals("0000")){
				errores.remove(i);
				i--;
			}
		}
		return errores;
	}

    /*
     * Se agrega funcionalidad para formatear fecha desde un formato inicial al formato general de migracion.
     */
    public String formatearFechaGeneral( String fecha) {
       
    	System.out.println(fecha.length());
        String ano=fecha.substring(0,4);
        String mes=fecha.substring(4,6);
        String dia=fecha.substring(6,8);
        return dia + "/" + mes + "/" + ano;
        

    }
    public String formatearFechaBase( String fecha) {

        System.out.println(fecha.length());
        String ano=fecha.substring(0,4);
        String mes=fecha.substring(4,6);
        String dia=fecha.substring(6,8);
        return ano+"-"+mes+"-"+dia;


    }
    /*
     *  Se agrga funcionalidad para formatear hora
     */
    public String formatearHoraGeneral (String tiempo) {

        System.out.println(tiempo.length());
        String hora = tiempo.substring(0, 2);
        String minuto = tiempo.substring(2, 4);
        String segundo = tiempo.substring(4, 6);
        return hora + ":" + minuto + ":" + segundo;

    }


    public String SalidaResponse(String vista,String StrUrl,String action,String StrRep)
    {
        String salida="";
        String outputString="";
        try
        {
            String responseString="";
            URL url = new URL(StrUrl);
            URLConnection connection = url.openConnection();
            //System.out.println(connection);
            HttpURLConnection httpConn = (HttpURLConnection)connection;
            //System.out.println(httpConn);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] buffer = new byte[vista.length()];
            buffer = vista.getBytes();
            bout.write(buffer);
            byte[] b = bout.toByteArray();
            httpConn.setRequestProperty("Content-Length",
                    String.valueOf(b.length));
            httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            httpConn.setRequestProperty("SOAPAction", action);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            OutputStream out = httpConn.getOutputStream();
            out.write(b);
            out.close();

            InputStreamReader isr =
                    new InputStreamReader(httpConn.getInputStream());
            BufferedReader in = new BufferedReader(isr);

            //Write the SOAP message response to a String.
            while ((responseString = in.readLine()) != null)
            {
                outputString = outputString + responseString;
            }
            outputString = outputString.replace("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">", "");
            outputString = outputString.replace("<soapenv:Body>", "");
            if(StrRep.length()>0)
            {
                outputString = outputString.replace("<"+StrRep+" xmlns=\"http://ws.wso2.org/dataservice\">", "");
                outputString = outputString.replace("</"+StrRep+">", "");
            }
            outputString = outputString.replace("</soapenv:Body>", "");
            outputString = outputString.replace("</soapenv:Envelope>", "");
            outputString = outputString.trim();
            salida =outputString;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return salida;
    }
    public Document xmlToDocumentXML(String xml) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        if (dBuilder != null) {
            try {
                doc = dBuilder.parse(new ByteArrayInputStream(xml.getBytes("utf-8")));
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return doc;
    }
}

