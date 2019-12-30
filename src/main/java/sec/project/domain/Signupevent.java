package sec.project.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import sec.project.event.Event;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Signupevent extends AbstractPersistable<Long> {

    private String name;
    private String address;
    
    @ManyToOne
    private Event event;

//    public SignupEvent() {
//        super();
//    }
//
//    public SignupEvent(String name, String address, Event event) {
//        this();
//        this.name = name;
//        this.address = address;
//        this.event = event;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    
//    public Event getEvent() {
//        return event;
//    }
//
//    public void setEvent(Event event) {
//        this.event = event;
//    }
//    
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
    

}
