package com.jsonservlet.dao;

import com.jsonservlet.dto.RegisterDto;
import com.jsonservlet.utils.Database;

import java.sql.SQLException;

public class RegisterDao {
    Database database = new Database();
    public int  registration(RegisterDto registerDto){
        try {
            database.makeConnection();
            try {
                database.st.executeUpdate("insert into registerData(fullname,username,password) values('"+registerDto.getFullname()+"'," +
                        "'"+registerDto.getUsername()+"','"+registerDto.getPassword()+"') ");
                return 200;
            }catch (SQLException s){
                System.out.println("syntax error in register dao--"+s);
            }

        }catch (Exception e){
            System.out.println("db connection problem-"+e);
        }
        return 0;
    }
}
