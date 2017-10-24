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
public class ReqConsultaDatosPorAcuerdoDTO {
    @Getter
    @Setter
    private String usuario;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String entidad;
    @Getter
    @Setter
    private String acuerdo;

}
