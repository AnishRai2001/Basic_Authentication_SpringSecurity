package Basic_Authentication.demo.ServiceImpl;

import Basic_Authentication.demo.Dto.LoginDto;
import Basic_Authentication.demo.Dto.UserDto;
import Basic_Authentication.demo.Entity.AppUser;
import Basic_Authentication.demo.Exception.UserNotFoundException;
import Basic_Authentication.demo.Repository.UserRepository;
import Basic_Authentication.demo.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements UserService {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AppUser registerUser(UserDto userDto) {
        AppUser user = new AppUser();
        BeanUtils.copyProperties(userDto, user); // Copy properties from DTO to entity
        user.setPassword(passwordEncoder.encode(userDto.getPassword())); // Encode password
        return userRepository.save(user);
    }

    @Override
    public LoginDto authenticate(String email, String password) {
        System.out.println("Authenticate called with email: " + email);

        if (email == null || email.isEmpty()) {
            throw new UserNotFoundException("Email cannot be null or empty");
        }

        // Find user by email
        AppUser user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Invalid email or password"));

        // Check password with bcrypt
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UserNotFoundException("Invalid email or password");
        }

        // Create and return LoginDto (or your response object)
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(user.getEmail());
        loginDto.setPassword(null); // Don't return password!

        // add any other fields you want to send back

        return loginDto;
    }






    @Override
    public AppUser findUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }
}
