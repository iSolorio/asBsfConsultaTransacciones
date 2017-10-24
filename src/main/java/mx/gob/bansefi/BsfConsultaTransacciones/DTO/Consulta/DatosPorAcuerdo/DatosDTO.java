package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosPorAcuerdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ivan Solorio
 * @version 1.0 - 2017/10/23
 */
@AllArgsConstructor
@NoArgsConstructor
public class DatosDTO {
    @Getter
    @Setter
    private String ID_INTERNO_PE;
    @Getter
    @Setter
    private String NOMBRE;
    @Getter
    @Setter
    private String ID_RFC;
    @Getter
    @Setter
    private String ID_CURP;
    @Getter
    @Setter
    private String NUM_RL_ORDEN;
    @Getter
    @Setter
    private String NIVEL_CUENTA;

}
