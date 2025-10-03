package pe.edu.upc.backend.jfgmserviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.jfgmdtos.ReseniaUsuarioCountDTO;
import pe.edu.upc.backend.jfgmdtos.VideoReseniaCountDTO;
import pe.edu.upc.backend.jfgmentities.Resenia;
import pe.edu.upc.backend.jfgmrepositories.ReseniaRepository;
import pe.edu.upc.backend.jfgmservices.ReseniaService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReseniaServiceImpl implements ReseniaService {
    @Autowired
    private ReseniaRepository reseniaRepository;

    @Override
    public void delete(Integer id) {
        Resenia foundResenia = findById(id);
        if (foundResenia != null) {
            return;
        }
        reseniaRepository.deleteById(id);
    }


    @Override
    public Resenia findById(Integer id) {
        return reseniaRepository.findById(id).orElse(null);
    }

    @Override
    public List<VideoReseniaCountDTO> countReseniasByPeriod(LocalDate start, LocalDate end) {
        return reseniaRepository.countReseniasByVideoAndPeriod(start, end)
                .stream()
                .map(r -> new VideoReseniaCountDTO((String) r[0], ((Number) r[1]).longValue()))
                .toList();
    }

    @Override
    public List<ReseniaUsuarioCountDTO> countReseniasByUsuario() {
        return reseniaRepository.countReseniasByUsuario()
                .stream()
                .map(r -> new ReseniaUsuarioCountDTO((String) r[0], ((Number) r[1]).longValue()))
                .toList();
    }




}
