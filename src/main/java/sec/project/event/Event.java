package sec.project.event;

import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;
import sec.project.domain.Signupevent;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event extends AbstractPersistable<Long>  {
    
    private String eventname;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date eventdate;
    
    @OneToMany (mappedBy = "event")
    private List<Signupevent> signups;
    
}
