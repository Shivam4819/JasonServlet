package com.jsonservlet.api;

import com.google.gson.Gson;
import com.jsonservlet.component.RegisterComponent;
import com.jsonservlet.request.RegisterRequest;
import com.jsonservlet.response.RegisterResponse;
import com.jsonservlet.utils.ReadPostBody;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterApi", urlPatterns = {"/registerApi"})
public class RegisterApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        System.out.println("in registration");

        try {
            ReadPostBody readPostBody=new ReadPostBody();
            String buffer= readPostBody.readBody(request,response);
            System.out.println(buffer);

            Gson gson = new Gson();
            RegisterRequest req= gson.fromJson(buffer, RegisterRequest.class);

            RegisterComponent component=new RegisterComponent();
            RegisterResponse res= component.sendToDao(req);

            out.println(gson.toJson(res));


        } catch (Exception e) {
            System.out.println("error in registerApi--" + e);
        }
    }
}
