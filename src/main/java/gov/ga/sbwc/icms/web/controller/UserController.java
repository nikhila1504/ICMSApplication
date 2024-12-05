package gov.ga.sbwc.icms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import gov.ga.sbwc.icms.common.cfg.TokenProvider;
import gov.ga.sbwc.icms.common.entity.core.AuthToken;
import gov.ga.sbwc.icms.common.entity.core.LoginUser;
import gov.ga.sbwc.icms.common.entity.core.User;
import gov.ga.sbwc.icms.common.entity.core.UserInfo;
import gov.ga.sbwc.icms.core.service.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
	 	
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserServiceImpl userService;
    
    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @PostMapping("/register")
    public User saveUser(@RequestBody UserInfo user){
        return userService.save(user);
    }
    
 
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/adminping")
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/userping")
    public String userPing(){
        return "Any User Can Read This";
    }
    
    
    
    
}
