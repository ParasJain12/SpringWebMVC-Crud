package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.bean.Student;
import com.spring.dao.StudentDAO;

@Controller
public class StudentController {
   @Autowired
   StudentDAO dao;
   
   @RequestMapping("/stdform")
   public String showForm(Model m)
   {
	   m.addAttribute("command",new Student());
	   return "stdform";
   }
   
   // Insert/Create
   @RequestMapping(value="/save",method = RequestMethod.POST)  
   public String save(@ModelAttribute("std") Student std){  
       int result = dao.insert(std); 
       System.out.println("Data is inserted is: "+result);
       return "redirect:/viewstd";
   } 
   
   //Get All Student
   @RequestMapping("/viewstd")  
   public String viewstd(Model m){  
       List<Student> list = dao.getAllStudents();  
       m.addAttribute("list",list);
       return "viewstd";  
   } 
   
   //Get Single Student
   @RequestMapping(value="/editstd/{id}")  
   public String edit(@PathVariable int id, Model m){  
       Student s = dao.getStudent(id);
       m.addAttribute("command",s);
       return "stdeditform";  
   }  
   
   //Update
   @RequestMapping(value="/editsave",method = RequestMethod.POST)  
   public String editsave(@ModelAttribute("std") Student std){  
       dao.updateStudent(std); 
       return "redirect:/viewstd";  
   }  
   
   //Delete 
   @RequestMapping(value="/deletestd/{id}",method = RequestMethod.GET)  
   public String delete(@PathVariable int id){  
       dao.deleteStudent(id);  
       return "redirect:/viewstd";  
   }   
}
