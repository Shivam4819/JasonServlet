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
            // jason string
            Object obj= JSONValue.parse(buffer.toString());
            JSONObject jsonObject = (JSONObject)obj;
            long id=(Long) jsonObject.get("k1");
            String email= (String)jsonObject.get("k2");
            String course= (String)jsonObject.get("k3");
            String instructor= (String)jsonObject.get("k4");

            System.out.println("id"+id);
            System.out.println("email-"+email);
            System.out.println("couse-"+course);
            System.out.println("instructor-"+instructor);

            JSONObject responseObj=new JSONObject();
            responseObj.put("response","work is done");
            out.println(responseObj);
        } catch (Exception e) {
            System.out.println("error="+e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        //object.put("name","shivam");
        //object.put("age",new Integer(22));
        //object.put("email","shivam4819@gmail.com");

        out.println("hiiiiiiiiiii");
       // System.out.println(object);
       // out.println(object);
    }
}
