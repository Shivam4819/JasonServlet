package com.jsonservlet.api;

import com.google.gson.Gson;
import com.jsonservlet.request.FormDataRequest;
import com.jsonservlet.utils.Database;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "DisplayDataApi", urlPatterns = {"/DisplayDataApi"})
public class DisplayDataApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Database database=new Database();
        Gson gson=new Gson();
        ArrayList<String> arrayList=new ArrayList();
        System.out.println("in display api");
        try {
            database.makeConnection();
            try {
                database.rs=(ResultSet) database.st.executeQuery("SELECT * from formData ");
                while (database.rs.next()) {
                    FormDataRequest formDataRequest=new FormDataRequest();

                    formDataRequest.setId(database.rs.getLong("id"));
                    formDataRequest.setEmail(database.rs.getString("email"));
                    formDataRequest.setCoursename(database.rs.getString("coursename"));
                    formDataRequest.setInstructorname(database.rs.getString("instructorname"));
                    String result= gson.toJson(formDataRequest);
                    arrayList.add(result);
                }
                response.addHeader("Access-Control-Allow-Origin","http://localhost:3000/#/");
                response.getWriter().println(arrayList);

                
            }catch (Exception e){
                System.out.println("syntax error --"+e);
            }
        }catch (Exception e){
            System.out.println("error in display api--"+e);
        }
    }
}
