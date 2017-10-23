package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResGralDTO;

import java.util.ArrayList;


@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaAnotacionesDTO {
	@Getter
	@Setter
	private ResGralDTO cabecera;
	@Getter
	@Setter
	private ArrayList<ListaAnotacionesDTO> anotaciones;
}
