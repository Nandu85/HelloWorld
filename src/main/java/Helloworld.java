

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 * Servlet implementation class Helloworld
 */
@WebServlet(description = "Firstone", urlPatterns = { "/Helloworld" })
@MultipartConfig
public class Helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public Helloworld() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		StringBuffer sb=new StringBuffer();
//		BufferedReader br = request.getReader();
//		String line=null;
//		while((line = br.readLine())!=null) {
//			sb.append(line);
//		}
		
//		ObjectMapper mapper = new ObjectMapper();
//		Map<String,String> map=mapper.readValue(sb.toString().getBytes(), Map.class);
		
//		System.out.println(map.get("param"));
		
//		System.out.println(sb.toString());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Hello "+request.getParameter("username")+" pass "+request.getParameter("password"));
		System.out.println(request.getParameter("username")+" user");
		System.out.println(request.getParameter("password")+" password");
		
		Part part=request.getPart("file");
		System.out.println(part.getSubmittedFileName());
		InputStream io = part.getInputStream();
		InputStreamReader reader = new InputStreamReader(io);
		BufferedReader breader= new BufferedReader(reader);
		
		String str;
		while((str=breader.readLine())!=null) {
			System.out.println(str);
			out.println(str);
		}
		
		//For image
		part=request.getPart("image");
		System.out.println(part.getSubmittedFileName());

		io=part.getInputStream();
		reader=new InputStreamReader(io);
		breader=new BufferedReader(reader);
		byte[] buffer=new byte[io.available()];
		IOUtils.readFully(io, buffer);
		String str1=Base64.getEncoder().encodeToString(buffer);
		out.println("<img src=\"data:image/png;base64,"+str1+"\"\r\n"
				+ "alt=\"No image found\"> ");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
