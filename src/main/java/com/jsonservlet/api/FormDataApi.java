package com.jsonservlet.api;

import com.google.gson.Gson;
import com.jsonservlet.component.FormDataComponent;
import com.jsonservlet.request.FormDataRequest;
import com.jsonservlet.response.FormDataResponse;
import com.jsonservlet.utils.ReadPostBody;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FormDataApi", value = "/FormDataApi")
public class FormDataApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in new");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("connection made");
        System.out.println("yoyoyoyoyoyoyyo");
        PrintWriter out=response.getWriter();
        try {
            ReadPostBody readPostBody=new ReadPostBody();
            String buffer= readPostBody.readBody(request,response);
            System.out.println(buffer);

            Gson gson=new Gson();
            FormDataRequest req= gson.fromJson(buffer, FormDataRequest.class);

            FormDataComponent component=new FormDataComponent();
            FormDataResponse res=component.formData(req);

            out.println(gson.toJson(res));

        } catch (Exception e) {
            System.out.println("error="+e);
        }

    }
}
