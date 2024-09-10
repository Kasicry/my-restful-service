package kr.co.studyconsulting.myrestfulservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //setter, getter 메소드 세팅된 어노테이션
@AllArgsConstructor // 생성자 메소드 세팅 어노테이션
public class HelloWorldBean {
    private String message;

//    public HelloWorldBean(String message) {
//        this.message = message;
//
//    }
}
