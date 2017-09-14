package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Retenciones;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class ResponseBansefiDTO {
	@Getter
	@Setter
	private OtrConsultaGlobalRtrDTO OTR_CONSULTA_GLOBAL_RT_TR;
}
