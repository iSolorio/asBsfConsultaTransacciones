package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosEmpleado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ivan Solorio
 * @version 1.0 - 2017/10/27
 */
@AllArgsConstructor
@NoArgsConstructor
public class ReqConsultaDatosEmpleadoDTO {
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
    private String terminal;
    @Getter
    @Setter
    private String idInternoEmp;


}
