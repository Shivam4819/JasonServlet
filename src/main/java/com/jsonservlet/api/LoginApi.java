package com.jsonservlet.api;

import com.google.gson.Gson;
import com.jsonservlet.dao.LoginDatabase;
import com.jsonservlet.dto.LoginDto;
import com.jsonservlet.request.LoginReq;
import com.jsonservlet.response.LoginRes;

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

            LoginReq loginReq = gson.fromJson(buffer.toString(), LoginReq.class);
            String user=loginReq.getUsername();
            String pass=loginReq.getPassword();

            System.out.println("user-"+user);
            System.out.println("pass"+pass);

            LoginDto dto = new LoginDto();
            dto.setUsername(user);
            dto.setPassword(pass);

            LoginDatabase loginDatabase=new LoginDatabase();
            loginDatabase.saveData(dto);

            if(user.equals("shivam") && pass.equals("admin")){
                System.out.println("if .....");
                LoginRes res=new LoginRes();
                res.setResponseString("credential matchd");
                out.println(gson.toJson(res));
            }

        }catch (Exception e){
            System.out.println("problem--"+e);
        }
    }
}
