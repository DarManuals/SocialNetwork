package ua.dp.daragan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.dp.daragan.entity.User;
import ua.dp.daragan.pojo.UserMainInfo;
import ua.dp.daragan.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

import static ua.dp.daragan.GlobalConfig.USERS_PER_PAGE;

/**
 *
 * @author bogdan
 */
@RestController
public class searchController {
    
    @Autowired
    private UserRepository userRepo;
    
    @RequestMapping(value = "/searchu", method = RequestMethod.GET)
    public List<UserMainInfo> search(){ //@PageableDefault(page = 0, size = USERS_PER_PAGE, direction = Sort.Direction.ASC, sort = "username") Pageable p
        
        //Page<User> users = userRepo.findAll(p);
        List<User> users = userRepo.findAll();
        List<UserMainInfo> uInfo = users.stream().map(user -> {
            return new UserMainInfo(user.getUserId(), user.getUsername() );
        }).collect(Collectors.toList());
        
        int pagesNum = (int) Math.ceil( (double) userRepo.count() / USERS_PER_PAGE ); //how many pages exists
        //m.addAttribute("users", users );
        //m.addAttribute("pages", pagesNum );
        
        return uInfo;
    }
    
/*    @RequestMapping(path = "/search", method = RequestMethod.POST)
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
    }*/
}