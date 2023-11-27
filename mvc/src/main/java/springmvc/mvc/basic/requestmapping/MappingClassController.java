package springmvc.mvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/mapping/users")
@RestController
public class MappingClassController {

    @GetMapping
    public String user() {
        return "get users";
    }

    @PostMapping
    public String addUser() {
        return "get user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable("userId") String userId) {
        return "get userId : " + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable("userId") String userId) {
        return "get userId : " + userId;
    }

    @DeleteMapping ("/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        return "get userId : " + userId;
    }



}
