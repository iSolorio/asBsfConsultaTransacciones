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
public class ResConsultaDatosSucursalDTO extends ResGralDTO {

    @Getter @Setter
    private SucursalEDTO UO_CENTRO_E;
    @Getter @Setter
    private SucursalVDTO UO_CENTRO_V;
    @Getter @Setter
    private SucursalVVVEDTO PY_PARAM_VVV_E;
    @Getter @Setter
    private SucursalDirPralDTO NUM_DIR_PRAL_V;

}
