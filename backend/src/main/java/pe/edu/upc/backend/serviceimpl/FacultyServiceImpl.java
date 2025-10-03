package pe.edu.upc.backend.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Faculty;
import pe.edu.upc.backend.repositories.FacultyRepository;
import pe.edu.upc.backend.services.FacultyService;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public Faculty add(Faculty faculty) {

        /*
        Pasos:
        1. Validar que los campos cumplan los requisitos
        2. Interactuar con la BD para insertar el nuevo Faculty
         */

        if(faculty.getName()==null || faculty.getName().isBlank()) {
            return null;
        }
        if(faculty.getDirector()==null || faculty.getDirector().isBlank()) {
            return null;
        }

        Faculty foundFaculty = facultyRepository.findByName(faculty.getName());
        if(foundFaculty!=null) {
            return null;
        }

        return facultyRepository.save(faculty);
    }

    @Override
    public void delete(Long id) {
        Faculty foundFaculty = findById(id);
        if (foundFaculty==null){
            return;
        }
        facultyRepository.deleteById(id);
    }

    @Override
    public Faculty findById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Faculty> listAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty edit(Faculty faculty) {

        Faculty facultyFound = findById(faculty.getId());
        if (facultyFound==null){
            return null;
        }
        if(faculty.getName()!=null && !faculty.getName().isBlank()) {
            if(facultyRepository.findByName(faculty.getName())==null) {
                facultyFound.setName(faculty.getName());
            }
        }
        if(faculty.getDirector()!=null && !faculty.getDirector().isBlank()) {
            facultyFound.setDirector(faculty.getDirector());
        }
        if(faculty.getFoundationDate()!=null) {
            facultyFound.setFoundationDate(faculty.getFoundationDate());
        }


        return facultyRepository.save(facultyFound);
    }
}
