package ua.dp.daragan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.dp.daragan.entity.Posts;
import ua.dp.daragan.entity.User;
import ua.dp.daragan.repository.PostsRepository;
import ua.dp.daragan.repository.UserRepository;

import java.security.Principal;
import java.util.Date;

/**
 *
 * @author bogdan
 */
@Controller
public class postsController {
    
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostsRepository postRepo;
    
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public String makePost(@RequestParam(name = "postMsg") String postMsg,
                           Principal principal){
        
        User u = userRepo.findByUsername(principal.getName());
        postRepo.save(new Posts(u, postMsg, new Date()) );
        //TODO send response OK or NOT
        
        return "redirect:/profile";
    }
    
    @RequestMapping(value = "/posts/del/{id}", method = RequestMethod.GET)
    public String delPost(@PathVariable Long id, Model m, Principal principal){
        
        String username = principal.getName();
        Posts post =  postRepo.findOne(id);
        
        if(!username.equalsIgnoreCase(post.getUser().getUsername() )){
            return "redirect:/profile";
        }else{
            postRepo.delete(id);
        }
        //TODO send response OK or NOT
        
        return "redirect:/profile";
    }
}