package Basic_Authentication.demo.Controller;

import Basic_Authentication.demo.Dto.UserDto;
import Basic_Authentication.demo.Entity.AppUser;
import Basic_Authentication.demo.Service.UserService;
import Basic_Authentication.demo.ServiceImpl.ServiceImpl;
import Basic_Authentication.demo.Structure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private ServiceImpl service;

    // POST /api/users/register
    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<AppUser>> registerUser(@RequestBody UserDto userDto) {
        AppUser savedUser = service.registerUser(userDto);

        ResponseStructure<AppUser> response = new ResponseStructure<>();
        response.setMessage("User registered successfully");
        response.setSuccess(true);
        response.setData(savedUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
