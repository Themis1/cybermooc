package sec.project.event;


import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signupevent;
import sec.project.repository.SignupEventRepository;


@Controller
public class EventController {
 
    @Autowired
    EventRepository eventRepository;
    
    @Autowired
    SignupEventRepository signupEventRepository;
        
    @GetMapping("/events")
    public String list(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "events";
    }

    @PostMapping("/events")
    public String add(@RequestParam String eventname, @RequestParam Date eventdate) {

        Event e = new Event();
        e.setEventname(eventname);
        e.setEventdate(eventdate);
        eventRepository.save(e);
        return "redirect:/events";
    }
    
    @GetMapping("/events/{id}")
    public String getEvent(Model model, @PathVariable Long id) {
        Event event = eventRepository.findOne(id);
        model.addAttribute("event", eventRepository.getOne(id));
        model.addAttribute("participants", signupEventRepository.findByEvent(event));
        return "event";
    }    
    
    @PostMapping("/events/{id}")
    public String signUpForEvent(String name,  String address, @PathVariable Long id) {
        Signupevent s = new Signupevent();
        Event e = eventRepository.findOne(id);
        s.setAddress(address);
        s.setName(name);
        s.setEvent(e);
        List<Signupevent> signups = e.getSignups();
        signups.add(s);
        e.setSignups(signups);
        eventRepository.save(e);
        signupEventRepository.save(s);
        return "redirect:/done";
    }        
    
}
