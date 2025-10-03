package pe.edu.upc.backend.jfgmdtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReseniaDTO {
    private Long id;
    private String descripcion;
    private String usuario;
    private LocalDate fechaPublicacion;
    private Long videoId;
}
