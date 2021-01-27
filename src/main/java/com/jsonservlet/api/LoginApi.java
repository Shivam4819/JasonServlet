package com.jsonservlet.api;

import com.google.gson.Gson;
import com.jsonservlet.component.LoginComponent;
import com.jsonservlet.dao.LoginDao;
import com.jsonservlet.dto.LoginDto;
import com.jsonservlet.request.LoginRequest;
import com.jsonservlet.response.LoginResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginApi", urlPatterns = {"/loginApi"})
public class LoginApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        System.out.println("in login");
        StringBuffer buffer=new StringBuffer();
        String line="";
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                buffer.append(line);

            System.out.println(buffer.toString());

            Gson gson=new Gson();

            LoginRequest loginRequest = gson.fromJson(buffer.toString(), LoginRequest.class);

            LoginComponent loginComponent=new LoginComponent();
            LoginResponse res= loginComponent.loginUser(loginRequest);

            out.println(gson.toJson(res));


        }catch (Exception e){
            System.out.println("problem at login api --"+e);
        }
    }
}
