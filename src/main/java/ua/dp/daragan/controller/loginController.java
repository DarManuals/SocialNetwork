/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.dp.daragan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.dp.daragan.GlobalConfig;
import ua.dp.daragan.service.MySQLUserDetailsService;

/**
 *
 * @author bogdan
 */
@Controller
public class loginController implements GlobalConfig{

    @Autowired
    private MySQLUserDetailsService uServ;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){        
        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@RequestParam(name = "username") String username,
//                        @RequestParam(name = "password") String password) throws Exception{  
//
//        String uName = username.trim();
//        String uPass = password.trim();
//        
//        if(uName.isEmpty() || uPass.isEmpty() 
//                || !NAME_PATTERN.matcher(uName).matches() 
//                || !PASS_PATTERN.matcher(uPass).matches() ){
//            return "redirect:/login";
//        }
//        
//        try{
//            
//            UserDetails ud = uServ.loadUserByUsername(uName);
//            
//            if(ud == null) {
//                System.out.println("Reg user not found. Try again");            
//                return "redirect:/login";
//            }
//                        
//            if(HashString.strToHash(uPass) == ud.getPassword()  ){
//                System.out.println("All OK!");
//                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(ud.getUsername(), ud.getPassword(), ud.getAuthorities()));
//                return "redirect:/profile";
//            }
//
//        }catch(Exception e){
//            System.out.println("Some error in login ctrl: " + e);
//            return "redirect:/login";
//        }
//        
//        return "redirect:/login";
//    }
}