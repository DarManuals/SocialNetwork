package ua.dp.daragan.sn.mvc;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bogdan on 17.09.16.
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/index"})
    public String index(){
        if(!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser") ) return "redirect:/profile";
        return "index";
    }
}
