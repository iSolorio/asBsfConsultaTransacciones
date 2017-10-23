package mx.gob.bansefi.BsfConsultaTransacciones.diario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ivan Solorio
 * @version 1.0 - 2017/10/12
 */
@AllArgsConstructor
@NoArgsConstructor
public class NumSecDTO {
    @Getter
    @Setter
    private String numSec;
    @Getter
    @Setter
    private String numPuesto;
}
