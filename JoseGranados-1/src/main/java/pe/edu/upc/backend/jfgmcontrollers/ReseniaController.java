package pe.edu.upc.backend.jfgmcontrollers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.jfgmdtos.ReseniaUsuarioCountDTO;
import pe.edu.upc.backend.jfgmdtos.VideoReseniaCountDTO;
import pe.edu.upc.backend.jfgmservices.ReseniaService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/resenias")
public class ReseniaController {

    @Autowired
    private ReseniaService reseniaService;

    // HUB02
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        reseniaService.delete(id);
        return ResponseEntity.ok().build();
    }

    // HUB03
    @GetMapping("/count/period/{start}/{end}")
    public ResponseEntity<List<VideoReseniaCountDTO>> countReseniasByPeriod(
            @PathVariable String start,
            @PathVariable String end) {
        LocalDate s = LocalDate.parse(start);
        LocalDate e = LocalDate.parse(end);
        return ResponseEntity.ok(reseniaService.countReseniasByPeriod(s, e));
    }

    // HUB04
    @GetMapping("/count/byUsuario")
    public ResponseEntity<List<ReseniaUsuarioCountDTO>> countReseniasByUsuario() {
        return ResponseEntity.ok(reseniaService.countReseniasByUsuario());
    }
}
