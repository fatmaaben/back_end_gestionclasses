package com.backend.backend.classe;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClasseDAOImpl implements ClasseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Classe> getnomClasse() {

        return entityManager.createQuery("from Classe", Classe.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Classe classe) {
        // Save or update a class
        entityManager.merge(classe);
    }

    @Override
    @Transactional
    public void delete(String nomClasse) {

        Classe classe = findByNomClasse(nomClasse, null);
        if (classe != null) {
            entityManager.remove(classe);
        }
    }

    @Override
    public Classe findByNomClasse(String nomClasse, String niveauClasse) {

        try {
            return entityManager.createQuery(
                            "from Classe where nomClasse = :nomClasse and (:niveauClasse is null or niveauClasse = :niveauClasse)",
                            Classe.class
                    )
                    .setParameter("nomClasse", nomClasse)
                    .setParameter("niveauClasse", niveauClasse)
                    .getSingleResult();
        } catch (Exception e) {
            return null; // No result found
        }
    }
}
