package ua.dp.daragan.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import static ua.dp.daragan.GlobalConfig.SEARCH_NAME_PATTERN;
import static ua.dp.daragan.GlobalConfig.USERS_PER_PAGE;
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
    public String search(Model m, @PageableDefault(page = 0, size = USERS_PER_PAGE, direction = Sort.Direction.ASC, sort = "username") Pageable p){
        
        Page<User> users = userRepo.findAll(p);
        
        int pagesNum = (int) Math.ceil( (double) userRepo.count() / USERS_PER_PAGE ); //how many pages exists
        m.addAttribute("users", users );
        m.addAttribute("pages", pagesNum );
        
        return "search";
    }
    
    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String searchWith(Model m, 
                            @PageableDefault(page = 0, size = USERS_PER_PAGE, direction = Sort.Direction.ASC, sort = "username") Pageable p,
                            @RequestParam(name = "name", required = true) String name){
        
        if(name.isEmpty() || !SEARCH_NAME_PATTERN.matcher(name).matches()  ){
            return "redirect:/search";
        }
        
        List<User> users = userRepo.findByUsernameStartsWith(name, p);
        
        m.addAttribute("users", users );
        m.addAttribute("pages", 1 );
        
        return "search";
    }
}