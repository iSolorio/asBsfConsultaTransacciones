package mx.gob.bansefi.BsfConsultaTransacciones.DTO.Consulta.DatosSucursal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by AppWIns on 10/07/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
public class ResGralDTO {

    @Getter @Setter
    private String ESTATUS;
    @Getter @Setter
    private String CODIGO;
    @Getter @Setter
    private String MENSAJE;

    public void heredarDatos(ResGralDTO resGralDTO){
        this.ESTATUS = resGralDTO.getESTATUS();
        this.CODIGO = resGralDTO.getCODIGO();
        this.MENSAJE = resGralDTO.getMENSAJE();
    }

}
