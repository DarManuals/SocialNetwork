package ua.dp.daragan.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.dp.daragan.entity.User;
import ua.dp.daragan.repository.UserRepository;

/**
 *
 * @author bogdan
 */
@Controller
public class searchController {
    
    @Autowired
    private UserRepository userRepo;
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model m){
        
        List<User> ul = (List<User>) userRepo.findAll();
        
        m.addAttribute("users", ul );
        
        return "search";
    }
}