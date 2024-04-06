package ma.emsi.act_pratique2.repository;

import ma.emsi.act_pratique2.Entities.Consultation;
import ma.emsi.act_pratique2.Entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository <Consultation,Long>{
}
