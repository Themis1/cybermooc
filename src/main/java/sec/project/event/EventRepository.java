package sec.project.event;

import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.account.Account;

public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByEventname(String eventname);    
    
}
