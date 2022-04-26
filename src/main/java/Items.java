

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Items
 */
@WebServlet("/Items")

public class Items extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		getServletContext().getRequestDispatcher("/ShowItems.jsp").forward(request, response);
		
		System.out.println("Hiiiiiiiii	"+request.getParameter("dates"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request,response);
		String reqname=(String) request.getAttribute("name");
		String path=(String) request.getAttribute("path");
		String extension=".jpg";
		OutputStream opt = null;
		InputStream ipt = null;
		ArrayList<String> pathlist=new ArrayList<>();
		final PrintWriter pw = response.getWriter();
		
		try {
			File file=new File(path); 
			if(file.isDirectory()) {
				int i=1;
				while(i>0) {
					String filename=path+File.separator+reqname+String.valueOf(i)+extension; 
					File f1=new File(filename);
					if(f1.exists()) {
						pathlist.add("images\\"+reqname+File.separator+reqname+String.valueOf(i)+extension);
					}
					else
						break;
					i++;
				}
				request.setAttribute("paths", pathlist);
				getServletContext().getRequestDispatcher("/ShowItems.jsp").forward(request, response);

			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ipt != null)
				ipt.close();
			if (opt != null)
				opt.close();
			if (pw != null)
				pw.close();
		}
		
	}

}
