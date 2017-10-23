package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResGralDTO;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaDatosAcuerdoDTO {

	@Getter
	@Setter
	private ResGralDTO cabecera;
	@Getter
	@Setter
	private ArrayList<ListaDatosAcuerdoDTO> nombres;
}
