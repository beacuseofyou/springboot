package com.learning.Controller;

import com.learning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/findAllStudents")
    public Object findAllStudent(){
        return studentService.findAllStudents();
    }

    @RequestMapping("/modify")
    public int modify(){
        return studentService.modify();
    }

    @RequestMapping("/remove/{id}")
    public void remove(@PathVariable("id") int id){
        studentService.remove(id);
    }

    @RequestMapping("/test/{id}/{age}")
    public String test1(@PathVariable("id") int id, @PathVariable("age") int age){
        return id + " "  + age;
    }

    @RequestMapping("/test/{age}/{id}")
    public String test2(@PathVariable("id") int id, @PathVariable("age") int age){
        return id + " "  + age;
    }

}
