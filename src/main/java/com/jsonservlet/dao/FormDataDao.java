package com.jsonservlet.dao;

import com.jsonservlet.dto.FormDataDto;
import com.jsonservlet.utils.Database;

import java.sql.SQLException;

public class FormDataDao {
    Database database=new Database();
    public int saverRecord(FormDataDto dto){
        try {
            database.makeConnection();
            try {
                database.st.executeUpdate("insert into formData(id,email,coursename,instructorname) values('"+dto.getId()+"'," +
                        "'"+dto.getEmail()+"','"+dto.getCoursename()+"','"+dto.getInstructorname()+"') ");
                return 200;
            }catch (SQLException s){
                System.out.println("syntax error in form data dao--"+s);
            }

        }catch (Exception e){
            System.out.println("db connection problem-"+e);
        }
        return 0;
    }
}
