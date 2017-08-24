package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.ResponseBansefiDTO;

@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaDTO {
	@Getter @Setter
	private String TRANID;
	@Getter @Setter 
	private String ESTATUS;
	@Getter @Setter 
	private String CODIGO;
	@Getter @Setter
	private String MENSAJE;
	@Getter @Setter 
	private String NUMTASK;
	@Getter @Setter
	private ResponseBansefiDTO ResponseBansefi;
}
