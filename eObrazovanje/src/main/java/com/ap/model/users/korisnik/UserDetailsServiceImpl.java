package com.ap.model.users.korisnik;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ap.model.users.administrator.Administrator;
import com.ap.model.users.korisnik.Korisnik;
import com.ap.model.users.korisnik.KorisnikRepository;
import com.ap.model.users.predavac.Predavac;
import com.ap.model.users.student.Student;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private KorisnikRepository korisnikRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Korisnik Korisnik = korisnikRepository.findByUserName(username);

    if (Korisnik == null) {
      throw new UsernameNotFoundException(String.format("No Korisnik found with username '%s'.", username));
    } else {
    	/*List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
    	for (UserAuthority ua: Korisnik.getUserAuthorities()) {
    		grantedAuthorities.add(new SimpleGrantedAuthority(ua.getAuthority().getName()));
    	}*/
    	List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    	if(Korisnik instanceof Administrator){
    		GrantedAuthority ga = new SimpleGrantedAuthority("ADMIN");
    		
    		grantedAuthorities.add(ga);
    	}else if (Korisnik instanceof Predavac) {
    		GrantedAuthority ga = new SimpleGrantedAuthority("PREDAVAC");
    		grantedAuthorities.add(ga);
		}else if (Korisnik instanceof Student) {
			GrantedAuthority ga = new SimpleGrantedAuthority("STUDENT");
    		grantedAuthorities.add(ga);
		}
    
    	
    	
    	return new org.springframework.security.core.userdetails.User(
    			Korisnik.getUserName(),
    			Korisnik.getPassword(),
      		  grantedAuthorities);
    }
  }

}
