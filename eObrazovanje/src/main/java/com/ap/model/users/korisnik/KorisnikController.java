package com.ap.model.users.korisnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ap.model.users.security.TokenUtils;
import com.ap.web.dto.LoginDTO;
import com.ap.web.dto.TokenDTO;



@RestController
public class KorisnikController {

	
	@Autowired
	KorisnikService korisnikService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	TokenUtils tokenUtils;
	
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
        try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					loginDTO.getUsername(), loginDTO.getPassword());
			Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());
            TokenDTO tokenDto= new TokenDTO();
            tokenDto.setPayload(tokenUtils.generateToken(details));
            return new ResponseEntity<TokenDTO>(tokenDto, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<TokenDTO>( HttpStatus.BAD_REQUEST);
        }
	}
	
	
	@RequestMapping(value = "/api/getUser", method = RequestMethod.GET)
	public ResponseEntity<Korisnik> getUser(@RequestParam("username") String username) {
        try {
		    Korisnik korisnik =korisnikService.findByUsername(username);
            return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Korisnik>( HttpStatus.BAD_REQUEST);
        }
	}
}
