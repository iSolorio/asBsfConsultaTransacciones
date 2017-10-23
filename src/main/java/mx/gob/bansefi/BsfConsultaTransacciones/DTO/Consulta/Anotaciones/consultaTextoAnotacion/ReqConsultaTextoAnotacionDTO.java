package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Anotaciones.consultaTextoAnotacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ivan Solorio
 * @version 1.0 - 2017/10/10
 */
@AllArgsConstructor
@NoArgsConstructor
public class ReqConsultaTextoAnotacionDTO {
    @Getter
    @Setter
    private String usuario;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String catalogo;
    @Getter
    @Setter
    private String codigo;
}
