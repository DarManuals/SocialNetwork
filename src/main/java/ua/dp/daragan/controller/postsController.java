package ua.dp.daragan.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String makePost(@RequestParam(name = "postMsg") String postMsg){
        
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();        
        User u = userRepo.findByUsername(userName);
        
        postRepo.save(new Posts(u, postMsg, new Date()) );
        //TODO send response OK or NOT
        
        return "redirect:/profile";
    }
    
    @RequestMapping(value = "/posts/del/{id}", method = RequestMethod.GET)
    public String delPost(@PathVariable Long id, Model m){
        
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();        
        User me = userRepo.findByUsername(userName);
        
        Posts post =  postRepo.findOne(id);
        
        if(!userName.equalsIgnoreCase(post.getUser().getUsername() )){
            return "redirect:/profile";
        }else{
            postRepo.delete(id);
        }

        //TODO send response OK or NOT
        
        return "redirect:/profile";
    }
}