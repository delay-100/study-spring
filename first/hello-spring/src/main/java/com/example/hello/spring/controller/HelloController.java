package com.example.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!");

        return "hello"; // templates의 hello.html 실행하라는 것
    }

    @GetMapping("hello-mvc")
    public String hello(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    // 무식하게 "hello 넣는문자" 만 나온느 방식
    @GetMapping("hello-string")
    @ResponseBody /* http 통신 프로토콜의 body에 직접 넣어주겠따. html이 아님*/
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
    }

    // Json 방식
    // Json은 {"key":value} 로 이루어진 데이터 형태
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
