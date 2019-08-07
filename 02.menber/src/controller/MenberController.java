package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseDAO.MenberDAO;
import baseDAO.Menberimpl;
import model.Menber;

@WebServlet(name = "MenberController", urlPatterns= {"/menber_detail","/menber_input","/menber_save","/menber_List","/benber_update"})
public class MenberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		int lastIndex= uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		if(action.equals("menber_input")) {
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/menber/menberForm.jsp");
			rd.forward(req, resp);	
		
		}else if(action.equals("menber_save")) {
			Menber menber = new Menber();
			MenberDAO dao = new Menberimpl();
			
			menber.setId(req.getParameter("ID"));
			menber.setPassword(req.getParameter("PASSWORD"));
			menber.setName(req.getParameter("NAME"));
			menber.setGender(req.getParameter("GENDER"));
			menber.setBirth(req.getParameter("BIRTH"));
			
			dao.insert(menber);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/menber/menberList.jsp");
			rd.forward(req, resp);
		}
	
		if(action.equals("menber_List")) {
			MenberDAO dao = new Menberimpl();
			List<Menber> menbers= dao.selectAll();
			req.setAttribute("menber", menbers);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/menber/menberList.jsp");
			rd.forward(req, resp);
	
			for(Menber m :menbers) {
				System.out.println(m);
			}	
		}else if(action.equals("menber_detail")) {
			int no = Integer.parseInt(req.getParameter("no"));
			MenberDAO dao = new Menberimpl();
			
			Menber menber = dao.selectByno(no);
			
			req.setAttribute("menber", menber);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/menber/menber_detail.jsp");
			rd.forward(req, resp);
		}else if (action.equals("menber_update")) {
			MenberDAO dao = new Menberimpl();
			Menber menber = new Menber(); 
			menber.setNo(Integer.parseInt(req.getParameter("no")));
			menber.setId(req.getParameter("id"));
			menber.setPassword(req.getParameter("password"));
			menber.setName(req.getParameter("name"));
			menber.setGender(req.getParameter("gender"));
			menber.setBirth(req.getParameter("birth"));
			
			dao.update(menber);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/menber/menber_detail.jsp");
			rd.forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
			
	}

}
