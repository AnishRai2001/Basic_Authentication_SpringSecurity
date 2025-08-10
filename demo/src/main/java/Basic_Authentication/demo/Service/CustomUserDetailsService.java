package Basic_Authentication.demo.Service;

import Basic_Authentication.demo.Config.CustomUserDetail;
import Basic_Authentication.demo.Entity.AppUser;
import Basic_Authentication.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return new CustomUserDetail(user.get());
        }
        else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

    }
}
