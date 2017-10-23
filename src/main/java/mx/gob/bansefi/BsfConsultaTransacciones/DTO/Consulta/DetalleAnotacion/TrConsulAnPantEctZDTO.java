package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleAnotacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.AnAntcnEDTO;

@AllArgsConstructor
@NoArgsConstructor
public class TrConsulAnPantEctZDTO {
	@Getter
	@Setter
	private AnAntcnEDTO AN_ANTCN_E;
	@Getter
	@Setter
	private AnAntcnVDTO AN_ANTCN_V;
}
