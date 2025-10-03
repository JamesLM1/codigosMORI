package pe.edu.upc.backend.jfgmserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.jfgmdtos.VideoDTO;
import pe.edu.upc.backend.jfgmentities.Video;
import pe.edu.upc.backend.jfgmrepositories.VideoRepository;
import pe.edu.upc.backend.jfgmservices.VideoSerivce;

@Service
public class VideoServiceImpl implements VideoSerivce {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public VideoDTO add(VideoDTO dto) {

        Video video = new Video(null,dto.getTitulo(),dto.getFechaPublicacion(),dto.getDescripcion(),dto.getLikes(),dto.getMontoMonetizado(), null);
        video = videoRepository.save(video);
        dto.setId(video.getId());
        return dto;
    }

}
