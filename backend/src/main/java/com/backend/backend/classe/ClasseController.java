package com.backend.backend.classe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/classe")
public class ClasseController {

    @Autowired
    private ClasseDAO classeDAO;

    @GetMapping("/all")
    public List<Classe> getAllClasses() {
        return classeDAO.getnomClasse();
    }

    @PostMapping("/save")
    public String saveClass(@RequestBody Classe classe) {
        classeDAO.save(classe);
        return "Classe saved successfully!";
    }

    @DeleteMapping("/delete/{nomClasse}")
    public String deleteClass(@PathVariable String nomClasse) {
        classeDAO.delete(nomClasse);
        return "Classe deleted successfully!";
    }

    @GetMapping("/find")
    public Classe findClassByNomClasse(@RequestParam String nomClasse, @RequestParam(required = false) String niveauClasse) {
        return classeDAO.findByNomClasse(nomClasse, niveauClasse);
    }
}
