package mx.gob.bansefi.BsfConsultaTransacciones.consultaTransaccion;

import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request.ReqConsultaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResConsultaMovimientoDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.client.ConsultaClient;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
@SpringBootTest
public class ConsultaTransaccionTest {
	ConsultaClient consultaClient= new ConsultaClient();
	
	//prueba de correcto funcionamiento
	@Test
	public void happyPath()
	{
		ReqConsultaDTO request= new ReqConsultaDTO();
		//consutruccion de la entrada del metodo
		request.setAcceso("S");
		request.setAcuerdo("61104014");
		request.setEntidad("0166");
		request.setFechadesde("00/00/0000");
		request.setFechahasta("00/00/0000");
		request.setFormato("OFICINA");
		request.setImpsdo("0");
		request.setNumsec("0");
		request.setPassword("PENAS009");
		request.setTerminal("12000165");
		request.setUsuario("DESA0006");
		ResConsultaMovimientoDTO response= consultaClient.consDatosGral(request);
		//Cabecera
		assertEquals("OPERACION REALIZADA CORRECTAMENTE",response.getCabecera().getMensaje().trim());
		assertEquals("0",response.getCabecera().getStatus());
		//Cuerpo
		assertEquals("PRUEBA RETIRO",response.getLista().get(0).getConcepto().trim());
		assertEquals("06/07/2017",response.getLista().get(0).getFechaOperacion());
		assertEquals("AC",response.getLista().get(0).getCodapunte());
		assertEquals("01",response.getLista().get(0).getCodcuenta());
		assertEquals("010001  ",response.getLista().get(0).getCodorigen());
		assertEquals("0770615",response.getLista().get(0).getDetalle());
		assertEquals("22/01/2015",response.getLista().get(0).getFechaValor());
		assertEquals("",response.getLista().get(0).getIdOrigen());
		assertEquals("12000146",response.getLista().get(0).getOfiTerminal());
		assertEquals("0000001001738.58",response.getLista().get(0).getSaldo());
		assertEquals("0000000000002.00",response.getLista().get(0).getImporte());
		assertEquals("D",response.getLista().get(0).getSigno());
		
	}
	
}
