package ma.emsi.act_pratique2.repository;

import ma.emsi.act_pratique2.Entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
