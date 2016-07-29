package ua.dp.daragan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.dp.daragan.GlobalConfig;
import ua.dp.daragan.entity.User;
import ua.dp.daragan.repository.UserRepository;
import ua.dp.daragan.service.MySQLUserDetailsService;
import ua.dp.daragan.util.HashString;

/**
 *
 * @author bogdan
 */
@Controller
public class authController implements GlobalConfig{

    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private MySQLUserDetailsService uServ;
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(){
        return "registration";
    } 
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestParam(name = "username") String username,
                                 @RequestParam(name = "password") String password) throws Exception{  

        String uName = username.trim();
        String uPass = password.trim();
        
        if(uName.isEmpty() || uPass.isEmpty() 
                || !NAME_PATTERN.matcher(uName).matches() 
                || !PASS_PATTERN.matcher(uPass).matches() ){
            return "redirect:/registration";
        }
                        
        try{
            
            User u = userRepo.findByUsername(uName);
            if(u == null) {
                System.out.println("Not found. Reg new one");            
                userRepo.save(new User(username, HashString.strToHash(uPass) ) );
                UserDetails ud = uServ.loadUserByUsername(username);
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(ud.getUsername(), ud.getPassword(), ud.getAuthorities()));
                return "redirect:/profile";
            }
            
        }catch(Exception e){
            System.out.println("Already exist");
        }

        return "redirect:/registration";
    } 
}