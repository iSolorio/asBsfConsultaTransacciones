package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.ConsultaMovimientoDTO;

@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaMovimientoDTO {
	@Getter
	@Setter
	ResGralDTO cabecera;
	@Getter
	@Setter
	private String cantidad;
	@Getter @Setter 
	private ArrayList<ConsultaMovimientoDTO> lista;
}
