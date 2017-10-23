package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosAcuerdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class ListaDatosAcuerdoDTO {
	@Getter
	@Setter
	private String nombre;
	@Getter
	@Setter
	private String idInternoPe;
}
