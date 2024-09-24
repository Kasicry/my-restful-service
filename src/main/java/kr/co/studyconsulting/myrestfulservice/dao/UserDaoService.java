package kr.co.studyconsulting.myrestfulservice.dao;

import kr.co.studyconsulting.myrestfulservice.bean.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>(); // 저장소로 사용될 List

    private static int usersCount = 3;

    // 임시저장소
    static {
        users.add(new User(1,"Geon", new Date()));
        users.add(new User(2,"Aliy", new Date()));
        users.add(new User(3,"Den", new Date()));
    }

    // 전체유저들을 반환시켜주기 위한 함수
    public List<User> findAll() {
        return users;
    }

    public User save(User user){
        if(user.getId()==null){
            user.setId(++usersCount);
        }

        if(user.getJoinDate()==null){
            user.setJoinDate(new Date());
        }
        users.add(user);

        return user;
    }

    public User findOne(int id){
        for (User user : users) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()){ // hasNext() 하나씩 이동해가면서 찾는 함수
            User user = iterator.next();

            if(user.getId() == id){
                iterator.remove();
                return user;
            }

        }
        return null;
    }
}
