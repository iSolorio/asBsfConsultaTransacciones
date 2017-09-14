package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResGralDTO;


@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaRetencionesDTO {
	@Getter
	@Setter
	private ResGralDTO cabecera;
	@Getter
	@Setter
	private ArrayList<ListaConsultaRetencionesDTO> retenciones;
}
