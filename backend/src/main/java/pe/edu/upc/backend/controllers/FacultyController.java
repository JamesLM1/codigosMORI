package pe.edu.upc.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.entities.Faculty;
import pe.edu.upc.backend.services.FacultyService;

import java.util.List;

@CrossOrigin("*") //Lista de IPs que me pueden hacer peticiones
@RestController
@RequestMapping("/upc")   // http://localhost:8080/upc
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @GetMapping("/faculties") // http://localhost:8080/upc/faculties -> Metodo GET
    public ResponseEntity<List<Faculty>> listAll(){
        return new ResponseEntity<>(facultyService.listAll(),HttpStatus.OK);
    }

    @PostMapping("/faculties") // http://localhost:8080/upc/faculties -> Metodo POST
    public ResponseEntity<Faculty> add(@RequestBody Faculty faculty){
        Faculty newFaculty=facultyService.add(faculty);
        return new ResponseEntity<>(newFaculty, HttpStatus.CREATED);
    }

    @DeleteMapping("/faculties/{id}") // http://localhost:8080/upc/faculties/5 -> Metodo DELETE
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        facultyService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/faculties/{id}") // http://localhost:8080/upc/faculties/5 -> Metodo GET
    public ResponseEntity<Faculty> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Faculty>(facultyService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/faculties")
    public ResponseEntity<Faculty> edit(@RequestBody Faculty faculty){
        Faculty facultyUpdated = facultyService.edit(faculty);
        return new ResponseEntity<Faculty>(facultyUpdated,HttpStatus.OK);
    }


}
