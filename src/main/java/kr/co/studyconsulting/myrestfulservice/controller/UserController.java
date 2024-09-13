package kr.co.studyconsulting.myrestfulservice.controller;

import kr.co.studyconsulting.myrestfulservice.bean.User;
import kr.co.studyconsulting.myrestfulservice.dao.UserDaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController//컨트롤러로 사용할 수 있는 빈 어노테이션
public class UserController {
    private final UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users") //전체 사용자를 가져올 어노테이션
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}") //전체 사용자를 가져올 어노테이션
    public User retrieveAllUsers(@PathVariable int id) {
        return service.findOne(id);
    }

    @PostMapping("/users") // 사용자들 요청값을 변환해주기 위해서 ResponseEntity 활용
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
