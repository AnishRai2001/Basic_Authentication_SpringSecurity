package Basic_Authentication.demo.ServiceImpl;

import Basic_Authentication.demo.Dto.UserDto;
import Basic_Authentication.demo.Entity.AppUser;


import Basic_Authentication.demo.Exception.UserNotFoundException;
import Basic_Authentication.demo.Repository.UserRepository;
import Basic_Authentication.demo.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AppUser registerUser(UserDto userDto) {
        AppUser user = new AppUser();
        BeanUtils.copyProperties(userDto, user); // ✅ Correct order: source, target
        return userRepository.save(user);
    }


    @Override
    public AppUser findUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }

}
