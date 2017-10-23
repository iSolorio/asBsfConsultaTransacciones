package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;



@AllArgsConstructor
@NoArgsConstructor
public class TrConsulAnAnotPantEvDTO {
	@Getter
	@Setter
	private ArrayList<AnAntcnEDTO> AN_ANTCN_E;
	@Getter
	@Setter
	private ArrayList<IndVisadaAlVDTO> IND_VISADA_AL_V;
	@Getter
	@Setter
	private ArrayList<AnClavePadreVDTO> AN_CLAVE_PADRE_V;
	@Getter
	@Setter
	private ArrayList<ExpedienteRlVDTO> EXPEDIENTE_RL_V;
	
}
