package pe.edu.upc.backend.jfgmcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.jfgmdtos.VideoDTO;
import pe.edu.upc.backend.jfgmservices.VideoSerivce;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoSerivce videoService;

    // HUB01
    @PostMapping("/insert")
    public ResponseEntity<VideoDTO> add(@RequestBody VideoDTO dto) {
        if (dto.getTitulo() == null || dto.getTitulo().isBlank()
                || dto.getFechaPublicacion() == null
                || dto.getDescripcion() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        VideoDTO saved = videoService.add(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
