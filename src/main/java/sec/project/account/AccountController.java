package sec.project.account;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @GetMapping("/accounts")
    public String list(Model model) {
        model.addAttribute("accounts", accountRepository.findAll());
        return "accounts";
    }

    @PostMapping("/accounts")
    public String add(@RequestParam String username, @RequestParam String password) {
        if (accountRepository.findByUsername(username) != null) {
            return "redirect:/accounts";
        }
        Account a = new Account(username, password);
        //Account a = new Account(username, passwordEncoder.encode(password));
        accountRepository.save(a);
        Long id = a.getId();
        return "redirect:/accounts/{id}";
    }
    
    @GetMapping("/accounts/{id}")
    public String myAccount(Model model, @PathVariable Long id) {
        model.addAttribute("account", accountRepository.getOne(id));
        return "myaccount";
    }

}
