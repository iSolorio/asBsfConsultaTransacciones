package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosSucursal;

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
public class ReqConsultaDatosSucursalDTO {
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
    private String centro;
    @Getter
    @Setter
    private String terminal;

}
