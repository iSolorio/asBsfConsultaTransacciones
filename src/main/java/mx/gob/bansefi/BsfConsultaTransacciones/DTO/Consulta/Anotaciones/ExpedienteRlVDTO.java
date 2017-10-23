package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class ExpedienteRlVDTO {
	@Getter
	@Setter
	private String NUM_SEC_AC;
	@Getter
	@Setter
	private String COD_CENT_UO;
	@Getter
	@Setter
	private String ID_EXP_RECLAM;
}
