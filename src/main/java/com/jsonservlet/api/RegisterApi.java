package com.jsonservlet.api;

import com.google.gson.Gson;
import com.jsonservlet.component.RegisterComponent;
import com.jsonservlet.request.RegisterRequest;
import com.jsonservlet.response.RegisterResponse;

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
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                buffer.append(line);

            System.out.println(buffer.toString());

            Gson gson = new Gson();
            RegisterRequest req= gson.fromJson(buffer.toString(), RegisterRequest.class);

            RegisterComponent component=new RegisterComponent();
            RegisterResponse res= component.sendToDao(req);

            out.println(gson.toJson(res));


        } catch (Exception e) {
            System.out.println("error--" + e);
        }
    }
}
