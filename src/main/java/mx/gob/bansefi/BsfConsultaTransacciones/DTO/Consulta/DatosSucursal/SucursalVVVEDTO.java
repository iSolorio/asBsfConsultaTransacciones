package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosSucursal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by AppWIns on 23/07/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
public class SucursalVVVEDTO {

    @Getter @Setter
    private String COD_NRBE_EN;
    @Getter @Setter
    private String COD_INTERNO_UO;
    @Getter @Setter
    private String NUM_DIAS_BAK_DI;
    @Getter @Setter
    private String NUM_DIAS_BORR_DI;

}
