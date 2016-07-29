package ua.dp.daragan.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bogdan
 */
@Controller
public class indexController {
    
    @RequestMapping(value = {"/", "/index"})
    public String index(){
            if(!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser") ) return "redirect:/profile";        
        return "index";
    }    
}