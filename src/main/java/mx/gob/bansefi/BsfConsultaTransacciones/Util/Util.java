package mx.gob.bansefi.BsfConsultaTransacciones.Util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    public String formatearFechaGeneral(String formatoInicial, String fecha) {
       
    	System.out.println(fecha.length());
        String ano=fecha.substring(0,4);
        String mes=fecha.substring(4,6);
        String dia=fecha.substring(6,8);
        String fechaFormateada=dia+"/"+mes+"/"+ano;
        
        return fechaFormateada;
    }
}
