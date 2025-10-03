package pe.edu.upc.backend.jfgmdtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoReseniaCountDTO {
    private String titulo;
    private Long cantidadResenias;
}
