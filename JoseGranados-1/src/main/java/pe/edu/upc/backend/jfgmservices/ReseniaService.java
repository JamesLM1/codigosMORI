package pe.edu.upc.backend.jfgmservices;

import pe.edu.upc.backend.jfgmdtos.ReseniaUsuarioCountDTO;
import pe.edu.upc.backend.jfgmdtos.VideoReseniaCountDTO;
import pe.edu.upc.backend.jfgmentities.Resenia;

import java.time.LocalDate;
import java.util.List;

public interface ReseniaService {

    void delete(Integer id);
    public Resenia findById(Integer id);
    List<VideoReseniaCountDTO> countReseniasByPeriod(LocalDate start, LocalDate end);
    List<ReseniaUsuarioCountDTO> countReseniasByUsuario();
}
