package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResGralDTO;

@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaLiquidacionDTO {
	@Getter
	@Setter
	private ResGralDTO cabecera;
	@Getter
	@Setter
	private String fechaLiquidacion;
	@Getter
	@Setter
	private String acuerdo;
	@Getter
	@Setter
	private String fechaDesde;
	@Getter
	@Setter
	private String fechaHasta;
	@Getter
	@Setter
	private String situacion;
	@Getter
	@Setter
	private String fechaUltimoCobro;
	@Getter
	@Setter
	private String codigoOperacionLiquidacion;
	@Getter
	@Setter
	private String moneda;
	@Getter
	@Setter
	private String importeTotal;
	@Getter
	@Setter
	private String importePendiente;
	@Getter
	@Setter
	private ArrayList<ListaLiquidacionDTO> liquidaciones;
	
}
