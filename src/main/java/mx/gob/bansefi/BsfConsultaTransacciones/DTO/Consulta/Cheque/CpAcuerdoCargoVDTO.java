package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Cheque;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class CpAcuerdoCargoVDTO {
	@Getter
	@Setter
	private String COD_NRBE_EN;
	@Getter
	@Setter
	private String COD_CENT_UO;
	@Getter
	@Setter
	private String NUM_SEC_AC;
}
