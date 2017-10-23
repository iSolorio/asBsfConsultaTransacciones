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
public class ResponseBansefiDTO {
    @Getter
    @Setter
    private String CLAVE_DE_FILA_NOMBRE;
    @Getter
    @Setter
    private String DESCRIPCION_CORTA_FL;
    @Getter
    @Setter
    private String DESCRIPCION_LARGA_FL;
    @Getter
    @Setter
    private String CONTENIDO_DE_DATOS_1;
    @Getter
    @Setter
    private String CLAVE_DE_PAGINACION1;

}
