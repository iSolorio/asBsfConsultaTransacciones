package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Transaccion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ConsultaMovimientoDTO {
	@Getter @Setter
	private String concepto;
	@Getter @Setter
	private String fechaOperacion;
	@Getter @Setter
	private String fechaValor;
	@Getter @Setter
	private String ofiTerminal;
	@Getter @Setter
	private String signo;
	@Getter @Setter
	private String importe;
	@Getter @Setter
	private String saldo;
	@Getter @Setter
	private String codigoError;
	@Getter @Setter
	private String descripcionError;
	@Getter @Setter
	private String detalle;//num_sec que sirve para ubicar el detalle
	@Getter @Setter
	private String codcuenta;
	@Getter @Setter
	private String codorigen;
	@Getter @Setter
	private String codapunte;
	@Getter	@Setter
	private String idOrigen;
}
