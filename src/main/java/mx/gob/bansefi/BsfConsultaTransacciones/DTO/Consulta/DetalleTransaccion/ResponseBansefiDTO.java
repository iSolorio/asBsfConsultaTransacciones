package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DetalleTransaccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
public class ResponseBansefiDTO {
	@Getter
	@Setter
	private OtrAfConsApunteTrnODTO OTR_AF_CONS_APUNTE_TRN_O;
}
