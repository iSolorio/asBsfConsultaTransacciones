package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Liquidacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class LiqConsDemoraVdto {
	@Getter
	@Setter
	private ArrayList<HlTramoVDTO> HL_TRAMO_V;
	@Getter
	@Setter
	private LiqTaesLiqVDTO LIQ_TAES_LIQ_V;
	@Getter
	@Setter
	private ArrayList<LiqHlKtCmsnVDTO> LIQ_HL_KT_CMSN_V;
}
