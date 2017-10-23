package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.ConsultaMovimientoDTO;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaMovimientoDTO {
	@Getter
	@Setter
	ResGralDTO cabecera;
	@Getter
	@Setter
	private String cantidad;
	@Getter
	@Setter
	private String fechaOperacion;
	@Getter
	@Setter
	private String horaOperacion;
	@Getter
	@Setter
	private ArrayList<ConsultaMovimientoDTO> lista;
}
