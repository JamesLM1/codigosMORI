package pe.edu.upc.backend.jfgmrepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.backend.jfgmentities.Video;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
