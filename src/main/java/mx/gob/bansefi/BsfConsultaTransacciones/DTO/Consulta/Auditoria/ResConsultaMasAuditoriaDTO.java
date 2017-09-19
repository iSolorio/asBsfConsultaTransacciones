package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Auditoria;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResGralDTO;
@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaMasAuditoriaDTO {
	@Getter
	@Setter
	private ResGralDTO cabecera;
	@Getter
	@Setter
	private String nombreEmpleado;
	@Getter
	@Setter
	private String nombreAutorizador;
	@Getter
	@Setter
	private String codigoCentro;
	@Getter
	@Setter
	private String nombEnt;
}
