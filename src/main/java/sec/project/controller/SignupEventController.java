package sec.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signupevent;
import sec.project.event.Event;
import sec.project.event.EventRepository;
import sec.project.repository.SignupEventRepository;

@Controller
public class SignupEventController {

    @Autowired
    private SignupEventRepository signupEventRepository;

    @Autowired
    private EventRepository eventRepository;    
    
    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/events";
        //return "redirect:/login";
    }
    
    @GetMapping("/done")
    public String done() {
        return "done";
    }    

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "form";
    }

    
    // ei validointia:
//    @PostMapping("/form")
//    public String submitForm(String name,  String address, Event event) {
//        SignupEvent s = new SignupEvent();
//        s.setAddress(address);
//        s.setName(name);
//        s.setEvent(event);
//        event.getSignups().add(s);
//        eventRepository.save(event);
//        signupEventRepository.save(s);
//        return "/done";
//    }   
    
    //validointi:
//    @RequestMapping(value = "/form", method = RequestMethod.POST)
//    public String submitForm(@RequestParam String name, @RequestParam String address) {
//        signupRepository.save(new Signup(name, address));
//        return "done";
//    }
    
    @GetMapping("/list")
    public String listPeople(Model model) {
        //tähän tarkastus onko kirjautuneena
        model.addAttribute("persons", signupEventRepository.findAll());
        return "list";
    }

}
