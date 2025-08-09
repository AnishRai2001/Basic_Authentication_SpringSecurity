package Basic_Authentication.demo.Controller;

import Basic_Authentication.demo.Dto.UserDto;
import Basic_Authentication.demo.Entity.User;
import Basic_Authentication.demo.Service.UserService;
import Basic_Authentication.demo.ServiceImpl.ServiceImpl;
import Basic_Authentication.demo.Structure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private ServiceImpl service;

    // POST /api/users/register
    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody UserDto userDto) {
        User savedUser = service.registerUser(userDto);

        ResponseStructure<User> response = new ResponseStructure<>();
        response.setMessage("User registered successfully");
        response.setSuccess(true);
        response.setData(savedUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
