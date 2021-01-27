package com.jsonservlet.component;

import com.jsonservlet.dao.RegisterDao;
import com.jsonservlet.dto.RegisterDto;
import com.jsonservlet.request.RegisterRequest;
import com.jsonservlet.response.RegisterResponse;

public class RegisterComponent {
    public RegisterResponse sendToDao(RegisterRequest req){
        try {
            RegisterDto dto = new RegisterDto();
            dto.setFullname(req.getFullname());
            dto.setUsername(req.getUsername());
            dto.setPassword(req.getPassword());

            RegisterDao db = new RegisterDao();
            int code = db.registration(dto);
            if (code == 200) {
                RegisterResponse res = new RegisterResponse();
                res.setRegisterResponse("registration done");
                return res;
            }
        }catch (Exception e){
            System.out.println("error in commponent"+e);
        }
        return null;
    }
}
