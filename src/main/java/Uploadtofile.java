
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Uploadtofile
 */
@WebServlet("/Uploadtofile")
@MultipartConfig(maxFileSize = 1024 * 1024, maxRequestSize = 2048 * 2048, fileSizeThreshold = 1024)
public class Uploadtofile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String realPath = getServletContext().getRealPath("/");
		System.out.println(realPath);
		getServletContext().getRequestDispatcher("/fileupload.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		final String reqname = request.getParameter("name");

		final String path = "C:\\Users\\knandani\\eclipse-workspace\\HelloWorld\\src\\main\\webapp\\images\\" + reqname;		
		

//		OutputStream opt = null;
//		InputStream ipt = null;
//		final PrintWriter pw = response.getWriter();

		try {

			File fileout = new File(path);
			if (!fileout.exists()) {
				fileout.mkdir();
			}

			int i = 1;
			for (Part part : request.getParts()) {
				String filename=null,extension = null;
				
//				System.out.println(part.getSubmittedFileName());
				
				
				if(part.getSubmittedFileName()!=null) {
					
					filename = part.getSubmittedFileName();
					extension = ".jpg";//filename.substring(filename.indexOf('.'));
					
//					Paths.get(part.getHeader(path));

//					System.out.println(part.getHeaders("Content-Disposition").toString()+" \n"+part.getHeaderNames().toString());
//					ipt = part.getInputStream();

					String filePath = path + File.separator + reqname + String.valueOf(i) + extension;

//					File file = new File(path);
//					opt=new FileOutputStream(new File(filePath));
					part.write(filePath);
					i++;
				}
				
//				int read = 0;
//				final byte[] bytes=new byte[1024];
//				while((read=ipt.read(bytes))!=-1) {
//					opt.write(bytes,0,read);
//					
//			}

			}
			request.setAttribute("name", reqname);
			request.setAttribute("path", path);
			getServletContext().getRequestDispatcher("/Items").forward(request, response);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		finally {
//			if (ipt != null)
//				ipt.close();
//			if (opt != null)
//				opt.close();
//			if (pw != null)
//				pw.close();
//		}

	}

}
