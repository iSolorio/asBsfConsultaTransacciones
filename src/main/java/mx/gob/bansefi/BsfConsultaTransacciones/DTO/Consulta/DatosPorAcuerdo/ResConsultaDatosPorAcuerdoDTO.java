package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosPorAcuerdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.bansefi.BsfConsultaTransacciones.DTO.Respuestas.ResGralDTO;

/**
 * @author Ivan Solorio
 * @version 1.0 - 2017/10/23
 */
@AllArgsConstructor
@NoArgsConstructor
public class ResConsultaDatosPorAcuerdoDTO{
    @Getter
    @Setter
    private ResGralDTO cabecera;
    @Getter
    @Setter
    private String idInternoPe;
    @Getter
    @Setter
    private String nombre;
}
