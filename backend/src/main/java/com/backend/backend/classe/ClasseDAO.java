package com.backend.backend.classe;
import java.util.List;
public interface ClasseDAO {
    List<Classe> getnomClasse();
    void save (Classe classe);
    void delete (String nomclasse);
    Classe findByNomClasse(String nomClasse, String  niveauClasse);

}