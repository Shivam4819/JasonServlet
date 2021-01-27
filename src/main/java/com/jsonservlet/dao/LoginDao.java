package com.jsonservlet.dao;

import com.jsonservlet.dto.LoginDto;
import com.jsonservlet.utils.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    Database database=new Database();

    public LoginDto saveData(LoginDto dto){
        try {
            database.makeConnection();
            try {
                database.rs=(ResultSet) database.st.executeQuery("SELECT * from registerData where username='"+dto.getUsername()+"'");
                while (database.rs.next()){
                    dto.setUsername(database.rs.getString("username"));
                    dto.setPassword(database.rs.getString("password"));
                }
                return dto;

            }catch (SQLException s){
                System.out.println("syntax error"+s);
            }

        }catch (Exception e){
            System.out.println("db connection problem-"+e);
        }
        return null;
    }

}
