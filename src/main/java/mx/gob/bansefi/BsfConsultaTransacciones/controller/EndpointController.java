package mx.gob.bansefi.BsfConsultaTransacciones.controller;

import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria.ReqConsultaAuditoriaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria.ReqConsultaMasAuditoriaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria.ResConsultaAuditoriaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria.ResConsultaMasAuditoriaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos.ReqConsultaBloqueoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos.ResConsultaBloqueosDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Cheque.ReqConsultaChequeDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Cheque.ResConsultaChequeDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo.ReqConsultaDatosAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo.ResConsultaDatosAcuerdoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion.ReqConsultaDetalleTransaccionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion.ResConsultaDetalleTransaccionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion.ReqConsultaLiquidacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion.ResConsultaLiquidacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones.ReqConsultaRetencionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones.ResConsultaRetencionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.ReqConsultaAnotacionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.ResConsultaAnotacionesDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleAnotacion.ReqConsultaDetalleAnotacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleAnotacion.ResConsultaDetalleAnotacionDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.ReqConsultaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.RequestConsultaNombreDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResConsultaMovimientoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResConsultaNombreDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.Util.Util;
import mx.gob.bansefi.BsfConsultaTransacciones.client.ConsultaClient;
import mx.gob.bansefi.BsfConsultaTransacciones.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


@SuppressWarnings("unused")
@RequestMapping("")
@RestController
public class EndpointController {

	@Autowired
	public ConsultaClient consultaclient;
	@Autowired
	public ConsultaService consultaService;
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
		System.out.println("nada");
		return consultaclient.consultaRetenciones(request);
	}
	
	@RequestMapping(value="consultaBloqueos",method=RequestMethod.POST)
	public ResConsultaBloqueosDTO consultaBloqueos(@RequestBody ReqConsultaBloqueoDTO request)
	{
		return consultaclient.consultaBloqueos(request);
	}
	@RequestMapping(value="consultaAuditoria",method=RequestMethod.POST)
	public ResConsultaAuditoriaDTO consultaAuditoria(@RequestBody ReqConsultaAuditoriaDTO request) 
	{
		return consultaclient.consultaAuditoria(request);
	}
	@RequestMapping(value="consultaMasAuditoria", method=RequestMethod.POST)
	public ResConsultaMasAuditoriaDTO  consultaMasAuditoria(@RequestBody ReqConsultaMasAuditoriaDTO request)
	{
		return consultaclient.consultaMasAuditoria(request);
	}
	@RequestMapping(value="consultaLiquidacion", method=RequestMethod.POST)
	public ResConsultaLiquidacionDTO consultaLiquidacion(@RequestBody ReqConsultaLiquidacionDTO request )
	{
		return consultaclient.consultaLiquidacion(request);
	}
	@RequestMapping(value="consultaCheque", method=RequestMethod.POST)
	public ResConsultaChequeDTO consultaCheque(@RequestBody ReqConsultaChequeDTO request)
	{
		return consultaclient.consultaCheque(request);
	}
	@RequestMapping(value="consultaAnotaciones",method=RequestMethod.POST)
	public ResConsultaAnotacionesDTO consultaAnotaciones(@RequestBody ReqConsultaAnotacionesDTO request) {
		return consultaService.consultaAnotaciones(request);
	}
	@RequestMapping(value="consultaDetalleAnotacion",method=RequestMethod.POST)
	public ResConsultaDetalleAnotacionDTO consultaDetalleAnotacion(@RequestBody ReqConsultaDetalleAnotacionDTO request)
	{
		return consultaService.consultaDetalleAnotacion(request);
	}
	
		
}
