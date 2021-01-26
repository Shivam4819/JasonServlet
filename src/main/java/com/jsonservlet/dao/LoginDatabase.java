package com.jsonservlet.dao;

import com.jsonservlet.dto.LoginDto;
import com.jsonservlet.utils.Database;

import java.sql.SQLException;

public class LoginDatabase {
    Database database=new Database();

    public void saveData(LoginDto dto){
        String user=dto.getUsername();
        String pass=dto.getPassword();
        try {
            database.makeConnection();
            try {
                database.st.executeUpdate("insert into loginData(username,password) values('"+user+"','"+pass+"') ");

            }catch (SQLException s){
                System.out.println("syntax error"+s);
            }

        }catch (Exception e){
            System.out.println("db connection problem-"+e);
        }
    }

}
