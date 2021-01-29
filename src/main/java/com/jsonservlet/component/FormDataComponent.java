package com.jsonservlet.component;

import com.jsonservlet.dao.FormDataDao;
import com.jsonservlet.dto.FormDataDto;
import com.jsonservlet.request.FormDataRequest;
import com.jsonservlet.response.FormDataResponse;

public class FormDataComponent {

    public FormDataResponse formData(FormDataRequest req){
      try {
          System.out.println("in component");
          FormDataDto dto=new FormDataDto();
          dto.setId(req.getId());
          dto.setEmail(req.getEmail());
          dto.setCoursename(req.getCoursename());
          dto.setInstructorname(req.getInstructorname());

          FormDataDao dao=new FormDataDao();
          int code=dao.saverRecord(dto);

          FormDataResponse response=new FormDataResponse();
          if(code==200){
              response.setResponseString("data inserted");
          }else {
              response.setResponseString("data not inserted");
          }
          return response;


      }catch (Exception e){
          System.out.println("error in form component--"+e);
      }
        return null;
    }
}
