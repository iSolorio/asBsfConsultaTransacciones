package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Bloqueos.ListaConsutaAuditoriaDTO;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResGralDTO;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaAuditoriaDTO {
	@Getter
	@Setter
	private ResGralDTO cabecera;
	@Getter
	@Setter
	private ArrayList<ListaConsutaAuditoriaDTO> auditorias;
}
