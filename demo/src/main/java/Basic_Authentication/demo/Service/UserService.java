package Basic_Authentication.demo.Service;

import Basic_Authentication.demo.Dto.UserDto;
import Basic_Authentication.demo.Entity.AppUser;


public interface UserService {
    AppUser registerUser(UserDto userDto);
    AppUser findUserById(int id);
}