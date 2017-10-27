package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Transaccion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
/*DTO que encapsula toooda la respuesta de  datos*/
public class ResponseBansefiDTO {
	@Getter
	@Setter
	private ConsultaBansefiDTO OTR_CONSULTA_APNTES_PSV_T;
}
