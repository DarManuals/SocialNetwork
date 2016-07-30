package ua.dp.daragan.controller;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.dp.daragan.entity.Posts;
import ua.dp.daragan.entity.User;
import ua.dp.daragan.repository.UserRepository;

/**
 *
 * @author bogdan
 */
@Controller
public class newsController {
    
    @Autowired
    private UserRepository userRepo;
    
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String search(Model m, @PageableDefault(page = 0, size = 5, direction = Sort.Direction.DESC, sort = "postId") Pageable p){
        
        List<Posts> posts = new LinkedList<Posts>();
        
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();  
        User me = userRepo.findByUsername(userName);
        
        for(User friend : me.getFriends() ){
            posts.addAll(friend.getPosts());
        }
        
        posts.sort((Posts o1, Posts o2) -> -1 * o1.getPostId().compareTo(o2.getPostId())); //compare by postId, desc       
        
         int pagesNum = (int) Math.ceil( 1.0 * posts.size() / 5 ); //how many pages exists
        
         int startIndex = p.getPageNumber() * p.getPageSize();
         int endIndex = startIndex + p.getPageSize();
            if(startIndex > posts.size() ) return "redirect:/news";
            if(endIndex > posts.size() ) endIndex = posts.size();
   
        m.addAttribute("allposts", posts.subList(startIndex, endIndex) );
        m.addAttribute("pages", pagesNum );
        
        return "news";
    }
}