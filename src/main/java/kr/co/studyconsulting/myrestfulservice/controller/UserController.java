package kr.co.studyconsulting.myrestfulservice.controller;

import kr.co.studyconsulting.myrestfulservice.bean.User;
import kr.co.studyconsulting.myrestfulservice.dao.UserDaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//컨트롤러로 사용할 수 있는 빈 어노테이션
public class UserController {
    private UserDaoService service;

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
}
