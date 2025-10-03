package pe.edu.upc.backend.jfgmentities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Titulo;
    private LocalDate FechaPublicacion;
    private String Descripcion;
    private Integer Likes;
    private Double MontoMonetizado;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "video", fetch = FetchType.EAGER)
    private List<Resenia> resenias;
}
