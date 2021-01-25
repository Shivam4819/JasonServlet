import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "JSONServlet",urlPatterns = {"/display"})
public class JSONServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("connection made");
        PrintWriter out=response.getWriter();
        StringBuffer buffer=new StringBuffer();
        String line="";
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                buffer.append(line);

            System.out.println(buffer.toString());

            // convert jason object to java object using gson library

            Gson gson=new Gson();
            JSONServletReq req= gson.fromJson(buffer.toString(),JSONServletReq.class);

            long id=(Long) req.getId();
            String email= req.getEmail();
            String course= req.getCoursename();
            String instructor= req.getInstructorname();

            System.out.println("id"+id);
            System.out.println("email-"+email);
            System.out.println("couse-"+course);
            System.out.println("instructor-"+instructor);

            //covering java object to json and send response
            JSONServletRes res=new JSONServletRes();
            res.setResponseString("work completed");
            out.println(gson.toJson(res));

        } catch (Exception e) {
            System.out.println("error="+e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
