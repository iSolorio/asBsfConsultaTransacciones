package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class ListaConsultaRetencionesDTO {
	//Tipo, Estado, Fecha de alta, Fecha VTO, Concepto, Empleado, Origen, e Importe
	@Getter
	@Setter
	private String tipo;
	@Getter
	@Setter
	private String estado;
	@Getter
	@Setter
	private String fechaAlta;
	@Getter
	@Setter
	private String fechaVTO;
	@Getter
	@Setter
	private String concepto;
	@Getter
	@Setter
	private String empleado;
	@Getter
	@Setter
	private String origen;
	@Getter
	@Setter
	private String importe;
	@Getter
	@Setter
	private String numSec;
	
}
