package mx.gob.bansefi.BsfConsultaTransacciones.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.bansefi.BsfConsultaTransacciones.DTO.ReqConsultaGeneralDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.ResConsultaGeneralDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.ConsultaMovimientoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos.ReqConsultaBloqueoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos.ResConsultaBloqueosDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo.ReqConsultaDatosAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo.ResConsultaDatosAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion.ReqConsultaDetalleTransaccionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion.ResConsultaDetalleTransaccionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones.ReqConsultaRetencionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones.ResConsultaRetencionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.ReqConsultaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.RequestConsultaNombreDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.ResConsultaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResConsultaMovimientoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResConsultaNombreDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.client.ConsultaClient;
import mx.gob.bansefi.BsfConsultaTransacciones.Util.Util;


@SuppressWarnings("unused")
@RequestMapping("")
@RestController
public class EndpointController {

	@Autowired
	public ConsultaClient consultaclient;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	public Util util;
	/*Endpoint para probar*/
	@RequestMapping(value ="consultaTransaccion", method = RequestMethod.POST)
	public ResConsultaMovimientoDTO pruebal(@RequestBody ReqConsultaDTO request){
			return consultaclient.consDatosGral(request);	
	}
	@RequestMapping(value="consultaDetalleTransaccion",method=RequestMethod.POST)
	public ResConsultaDetalleTransaccionDTO consultaDetalleTransaccion(@RequestBody ReqConsultaDetalleTransaccionDTO request)
	{
		return consultaclient.consultaDetalletransaccion(request);
	}
	@RequestMapping(value="consultaNombre",method=RequestMethod.POST)
	public ResConsultaNombreDTO consultaNombre(@RequestBody RequestConsultaNombreDTO request)
	{
		
		return consultaclient.consultaNombre(request);	
	}
	@RequestMapping(value="consultaDatosAcuerdo",method= RequestMethod.POST)
	public ResConsultaDatosAcuerdoDTO consultaDatosAcuerdo(@RequestBody ReqConsultaDatosAcuerdoDTO request)
	{
		return consultaclient.consultaDatosAcuerdo(request);
	}
	@RequestMapping(value="consultaRetenciones", method=RequestMethod.POST)
	public ResConsultaRetencionesDTO consultaRetenciones(@RequestBody ReqConsultaRetencionDTO request)
	{
		return consultaclient.consultaRetenciones(request);
	}
	
	@RequestMapping(value="consultaBloqueos",method=RequestMethod.POST)
	public ResConsultaBloqueosDTO consultaBloqueos(@RequestBody ReqConsultaBloqueoDTO request)
	{
		return consultaclient.consultaBloqueos(request);
	}
	
}
