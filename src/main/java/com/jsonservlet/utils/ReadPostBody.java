package com.jsonservlet.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadPostBody {
    public String readBody(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        System.out.println("inread post");
        StringBuffer buffer=new StringBuffer();
        String line="";
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                buffer.append(line);

            return buffer.toString();
        }catch (Exception e){
            System.out.println("error in readPostBody in utils--"+e);
        }
        return null;
    }
}
