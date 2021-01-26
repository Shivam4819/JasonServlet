package com.jsonservlet.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    public Statement st=null;
    public ResultSet rs=null;
    public Connection con= null;
    public void makeConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/FeedbackApp","root","");
            st= (Statement) con.createStatement();
        }catch(Exception e){
            System.out.print(e);
        }
    }
}
