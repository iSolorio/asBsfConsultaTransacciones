package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Cheque;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResGralDTO;

@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaChequeDTO {
	@Getter
	@Setter
	private  ResGralDTO cabecera;
}
