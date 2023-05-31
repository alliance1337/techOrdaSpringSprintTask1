package kz.bitlab.springboot.techboot.controller;

import kz.bitlab.springboot.techboot.db.DBManager;
import kz.bitlab.springboot.techboot.db.Music;
import kz.bitlab.springboot.techboot.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/") //@WebServlet(value = "/") + doGet()
    public String indexPage(Model model){
        ArrayList<Student> studentArray = DBManager.getStudents();
        model.addAttribute("studentter", studentArray); // request.setAttribute("muzikalar", musicArray);
        return "index"; //request.getRequestDispatcher("/index.html").forward(request,response)
    }

    @PostMapping(value = "/add-student")
    public String addStudent(Student student){
        DBManager.addStudent(student);
        return "redirect:/"; //response.sendRedirect("/");
    }

    @GetMapping(value = "/student-details")
    public String getStudent(@RequestParam(name = "studentId") int id, Model model){
        Student student = DBManager.getStudent(id);
        model.addAttribute("student", student);
        return "details";
    }

    @GetMapping(value = "/add-student")
    public String addStudentPage(Model model){
        return "addstudent";
    }


    @GetMapping(value = "/details/{studentId}")
    public String studentDetails(@PathVariable(name = "studentId") int id, Model model){
        Student student = DBManager.getStudent(id);
        model.addAttribute("student", student);
        return "details";
    }
}



























