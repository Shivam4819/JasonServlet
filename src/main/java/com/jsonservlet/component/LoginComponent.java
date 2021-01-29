package com.jsonservlet.component;

import com.jsonservlet.dao.LoginDao;
import com.jsonservlet.dto.LoginDto;
import com.jsonservlet.request.LoginRequest;
import com.jsonservlet.response.LoginResponse;

public class LoginComponent {
    public LoginResponse loginUser(LoginRequest loginRequest){
        try {
            LoginDto dto = new LoginDto();
            dto.setUsername(loginRequest.getUsername());

            LoginDao dao = new LoginDao();
            LoginDto resultdto = dao.saveData(dto);

            LoginResponse response = new LoginResponse();

            if(loginRequest.getPassword().equals(resultdto.getPassword())){
                response.setResponseString("credential matched");
                return response;
            }else {
                response.setResponseString("invalid user or pass");
                return response;
            }

        }catch (Exception e){
            System.out.println("problem at login component--"+e);
        }
        return null;
    }
}
