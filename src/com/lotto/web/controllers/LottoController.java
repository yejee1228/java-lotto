package com.lotto.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lotto.web.domains.LottoBean;
import com.lotto.web.serverImples.LottoServiceImpl;
import com.lotto.web.servers.LottoService;
@WebServlet("/lotto.do")
public class LottoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String money = request.getParameter("money");
		System.out.println("넘어온 돈"+money);
		LottoBean param = new LottoBean();
		LottoService service = new LottoServiceImpl();
		service.createLotto(param);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
