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
public class SucursalEDTO {

    @Getter @Setter
    private String NOMB_CENT_UO;
    @Getter @Setter
    private String NUM_AR_GEO;
    @Getter @Setter
    private String FECHA_ALTA_UO;
    @Getter @Setter
    private String COD_ECV_CENT;
    @Getter @Setter
    private String COD_DESIG_CTBL;
    @Getter @Setter
    private String COD_MDLDAD_CENT;
    @Getter @Setter
    private String FECHA_INIC_ECV;
    @Getter @Setter
    private String FECHA_INI_CBIO_CSB;
    @Getter @Setter
    private String IND_DEPEN_CTBLE_UO;
    @Getter @Setter
    private String NIV_JERAR_UO;
    @Getter @Setter
    private String IND_CENT_FICTIC_UO;
    @Getter @Setter
    private String IND_CENT_CTRL_UO;
    @Getter @Setter
    private String IND_APERTURA_UO;
    @Getter @Setter
    private String IND_CSB_UO;
    @Getter @Setter
    private String COD_CSB_OF;
    @Getter @Setter
    private String ID_INTERNO_PE;
    @Getter @Setter
    private String COD_PROV_AEAT_AG;
    @Getter @Setter
    private String COD_PLZ_BANCARIA;

}
