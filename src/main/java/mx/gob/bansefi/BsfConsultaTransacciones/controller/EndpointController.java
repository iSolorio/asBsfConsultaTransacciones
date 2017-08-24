package mx.gob.bansefi.BsfConsultaTransacciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.bansefi.BsfConsultaTransacciones.DTO.ReqConsultaGeneralDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.ResConsultaGeneralDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.ReqConsultaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.ResConsultaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.client.ConsultaClient;
import mx.gob.bansefi.BsfConsultaTransacciones.Util.Util;


@RequestMapping("")
@RestController
public class EndpointController {

	@Autowired
	public ConsultaClient consultaclient;
	@Autowired
	public Util util;
	/*Endpoint para probar*/
	@RequestMapping(value ="prueba", method = RequestMethod.POST)
	public ResConsultaDTO   pruebal(@RequestBody ReqConsultaDTO request){
		
			
			ResConsultaDTO res=consultaclient.consDatosGral(request);
			return res;
			
	}
}
