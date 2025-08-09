package Basic_Authentication.demo.Service;

import Basic_Authentication.demo.Dto.UserDto;
import Basic_Authentication.demo.Entity.User;

public interface UserService {
    User registerUser(UserDto userDto);
    User findUserById(int id);
}