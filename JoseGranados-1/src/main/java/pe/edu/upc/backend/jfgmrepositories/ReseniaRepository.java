package pe.edu.upc.backend.jfgmrepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.backend.jfgmentities.Resenia;
import pe.edu.upc.backend.jfgmentities.Video;

import java.time.LocalDate;
import java.util.List;

public interface ReseniaRepository extends JpaRepository<Resenia, Integer> {

    List<Video> findByVideo_Id(Long videoId);


    @Query("SELECT v.Titulo, COUNT(r) " +
            "FROM Resenia r JOIN r.video v " +
            "WHERE r.FechaPublicacion BETWEEN :start AND :end " +
            "GROUP BY v.Titulo")
    List<Object[]> countReseniasByVideoAndPeriod(LocalDate start, LocalDate end);

    @Query("SELECT r.Usuario, COUNT(r) FROM Resenia r GROUP BY r.Usuario")
    List<Object[]> countReseniasByUsuario();

}
