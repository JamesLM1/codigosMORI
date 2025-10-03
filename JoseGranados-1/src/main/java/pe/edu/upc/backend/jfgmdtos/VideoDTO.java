package pe.edu.upc.backend.jfgmdtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDTO {
    private Long id;
    private String titulo;
    private LocalDate fechaPublicacion;
    private String descripcion;
    private Integer likes;
    private Double montoMonetizado;
}
