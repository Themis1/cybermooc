package sec.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.domain.Signupevent;
import sec.project.event.Event;

public interface SignupEventRepository extends JpaRepository<Signupevent, Long> {
        Event findByEvent(Event event);

}
