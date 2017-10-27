package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.Catalogo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ivan Solorio
 * @version 1.0 - 2017/10/26
 */
@AllArgsConstructor
@NoArgsConstructor
public class CatalogoDTO {
    @Getter
    @Setter
    private String NUMTASK;
    @Getter
    @Setter
    private String CODIGO;
    @Getter
    @Setter
    private String ESTATUS;
    @Getter
    @Setter
    private String MENSAJE;
    @Getter
    @Setter
    private String TRANID;
    @Getter
    @Setter
    private ResponseBansefiDTO ResponseBansefi;

}
