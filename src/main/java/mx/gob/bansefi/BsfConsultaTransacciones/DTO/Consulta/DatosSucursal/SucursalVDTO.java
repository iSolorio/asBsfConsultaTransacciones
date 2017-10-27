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
public class SucursalVDTO {

    @Getter @Setter
    private String COD_PROVINCIA_AG;
    @Getter @Setter
    private String COD_MUNICIPIO_AG;
    @Getter @Setter
    private String COD_ENT_COLEC_AG;
    @Getter @Setter
    private String COD_ENT_SING_AG;

}
