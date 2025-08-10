package Basic_Authentication.demo.Repository;

import Basic_Authentication.demo.Entity.AppUser;
import Basic_Authentication.demo.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer> {
    Optional<AppUser> findByEmail(String email);

}
