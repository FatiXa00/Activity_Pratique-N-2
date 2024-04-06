package ma.emsi.act_pratique2.repository;

import ma.emsi.act_pratique2.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String nom);
}
