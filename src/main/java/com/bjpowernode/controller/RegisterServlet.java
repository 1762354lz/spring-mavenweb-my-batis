package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Style;
import java.io.IOException;


public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId =request.getParameter("id");
        String strName =request.getParameter("name");
        String strEmail =request.getParameter("email");
        String strAge =request.getParameter("age");
        WebApplicationContext ctx=null;
        String key=WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
       Object attr=getServletContext().getAttribute(key);
       if (attr!=null){
           ctx=(WebApplicationContext)attr;

       }
        StudentService service=(StudentService) ctx.getBean("studentService");
        Student student=new Student();
        student.setAge(Integer.valueOf(strAge));
        student.setId(Integer.parseInt(strId));
        student.setName(strName);
        student.setEmail(strEmail);
        service.addStudent(student);

        request.getRequestDispatcher("/result.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
