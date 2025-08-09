package Basic_Authentication.demo.Repository;

import Basic_Authentication.demo.Entity.AppUser;
import Basic_Authentication.demo.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByEmail(String email);

}
