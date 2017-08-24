package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
/*Es el core del array que arroja la respuesta JSON, basicamente esto es 5/8 de todo el mensaje que responde*/
public class DatosBasicosCompletosDTO {
	
	@Getter @Setter
	private DatosBasicosDTO nada;
}
