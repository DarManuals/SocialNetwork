package ua.dp.daragan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.dp.daragan.entity.Posts;
import ua.dp.daragan.entity.User;
import ua.dp.daragan.entity.UserDetails;
import ua.dp.daragan.repository.PostsRepository;
import ua.dp.daragan.repository.UserDetailsRepository;
import ua.dp.daragan.repository.UserRepository;
import ua.dp.daragan.util.DateTimeUtil;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import static ua.dp.daragan.GlobalConfig.POSTS_PER_PAGE;

/**
 *
 * @author bogdan
 */
@Controller
public class profileController{
    
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostsRepository postRepo;
    @Autowired
    private UserDetailsRepository userDetailsRepo;
    
    @RequestMapping("/profile")
    public String profileOwn(Model m,
                             @PageableDefault(page = 0, size = POSTS_PER_PAGE, direction = Sort.Direction.DESC, sort = "postId") Pageable p,
                             Principal principal) throws ParseException{
        
        User u = userRepo.findByUsername(principal.getName());
        
        int pagesNum = (int) Math.ceil( 1.0 * postRepo.findByUser(u).size() / POSTS_PER_PAGE ); //how many pages exists
        List<Posts> posts = postRepo.findByUser(u, p);
        
        m.addAttribute("user", u);
        m.addAttribute("posts_data", posts );
        m.addAttribute("user_details", u.getUserDetails() );
        m.addAttribute("posting_enable", 1 );
        m.addAttribute("b_date", DateTimeUtil.DateToStr(u.getUserDetails().getBirthDate()) );
        m.addAttribute("pages", pagesNum );
        m.addAttribute("pageUrl", "/profile" );
               
        return "profile";
    }    
    
    @RequestMapping("/profile/{id}")
    public String profileOther(@PathVariable Long id,
                               Model m,
                               @PageableDefault(page = 0, size = POSTS_PER_PAGE, direction = Sort.Direction.DESC, sort = "postId") Pageable p,
                               Principal principal){

        String username = principal.getName();
        User me = userRepo.findByUsername(username);
        
        try{
            User u = userRepo.findOne(id);
            if(username.equalsIgnoreCase(u.getUsername())){
                    return "redirect:/profile";
                }
                
            Set<User> myFriends = me.getFriends();
            boolean isFriend = false;
            for(User us : myFriends){
                if(us.getUserId() == id){
                    isFriend = true;
                    break;
                }
            }
            
            int pagesNum = (int) Math.ceil( 1.0 *  postRepo.findByUser(u).size() / POSTS_PER_PAGE ); //how many pages exists
            List<Posts> posts = postRepo.findByUser(u, p);
                
            m.addAttribute("user", u);
            m.addAttribute("posts_data", posts);
            m.addAttribute("user_details", u.getUserDetails() );
            m.addAttribute("posting_enable", 0 );
            m.addAttribute("isFriend", isFriend );
            m.addAttribute("b_date", DateTimeUtil.DateToStr(u.getUserDetails().getBirthDate()) );
            m.addAttribute("pages", pagesNum );
            m.addAttribute("pageUrl", "/profile/" + id );
        
        }catch(Exception e){
            return "error";
        }
                   
        return "profile";
    }
    
    @RequestMapping("/profile/edit")
    public String profileEditGet(Model m, Principal principal){
        
        String userName = principal.getName();
        UserDetails ud = userRepo.findByUsername(userName).getUserDetails();
        m.addAttribute("user_details", ud);
        
        return "profile_edit";
    }
    
    @RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
    public String profileEditPost(  @RequestParam(value = "city") String city,
                                    @RequestParam(value = "birthdate") String birthdate,
                                    @RequestParam(value = "job") String job,
                                    @RequestParam(value = "about") String about,
                                    Principal principal) throws ParseException{
        
        final User u = userRepo.findByUsername(principal.getName());
        UserDetails ud = u.getUserDetails();
        ud.setUser(null); //magic starts :)

        userDetailsRepo.delete(ud);
        
        ud.setUser(u); //magic ends :)
        ud.setCity(city);   
        ud.setBirthDate( new SimpleDateFormat("yyyy-MM-dd").parse(birthdate) );
        ud.setJob(job);
        ud.setAbout(about);
        userDetailsRepo.save(ud);

        return "redirect:/profile";
    }
    
    @RequestMapping(value = "/profile/follow/{id}")
    public String profileFollow(@PathVariable Long id, Principal principal){
        
        String username = principal.getName();
        
        try{
            User newFriend = userRepo.findOne(id); 
            User currentUser = userRepo.findByUsername(username);
           
                if(username.equalsIgnoreCase(newFriend.getUsername())){
                    return "redirect:/profile";
                }

            Set<User> userFriends = currentUser.getFriends();
            userFriends.add(newFriend);
            currentUser.setFriends(userFriends);
            userRepo.save(currentUser);
      
        }catch(Exception e){
            return "error";
        }
                   
        return "redirect:/profile/" + id;
    }
    
    @RequestMapping(value = "/profile/unfollow/{id}")
    public String profileUnfollow(@PathVariable Long id, Principal principal){
        
        String username = principal.getName();
        
        try{
            User newFriend = userRepo.findOne(id); 
            User currentUser = userRepo.findByUsername(username);
           
                if(username.equalsIgnoreCase(newFriend.getUsername())){
                    return "redirect:/profile";
                }

            Set<User> userFriends = currentUser.getFriends();
            userFriends.remove(newFriend);
            currentUser.setFriends(userFriends);
            userRepo.save(currentUser);
      
        }catch(Exception e){
            return "error";
        }
                   
        return "redirect:/profile/" + id;
    }
}