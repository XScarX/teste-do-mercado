package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import to.ProdutoTO;

/**
 * Servlet implementation class ManterProdutoController
 */
@WebServlet("/ManterProduto.do")
public class ManterProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterProdutoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cCodigo = request.getParameter("codigo");
		String cMarca = request.getParameter("marca");
		String cModelo = request.getParameter("modelo");
		String cPrecoDeVenda = request.getParameter("precoDeVenda");
		String cPrecoDeCompra = request.getParameter("precoDeCompra");
		String cCor = request.getParameter("cor");

		String acao = request.getParameter("manterProduto");
		Produto pro = new Produto();
		
		int codigo = -1;
		double pdv = -1;
		double pdc = -1;
		
		try {
			codigo = Integer.parseInt(cCodigo);
			pdv = Double.parseDouble(cPrecoDeVenda);
			pdc = Double.parseDouble(cPrecoDeCompra);
		} catch (NumberFormatException e) {
			
		}
		
		Produto produto = new Produto(codigo, cMarca, cModelo, pdv, pdc, cCor);
		
		if ("incluir".equals(acao)) {
			produto.criar();
			produto.carregar();
		} else if ("alterar".equals(acao)) {
			produto.atualizar();
			produto.carregar();

		} else if ("deletar".equals(acao)) {
			produto.excluir();

		}

		produto.carregar();

		ProdutoTO to = new ProdutoTO();
		to.setCodigo(produto.getCodigo());
		to.setMarca(produto.getMarca());
		to.setModelo(produto.getModelo());
		to.setPrecoDeVenda(produto.getPrecoDeVenda());
		to.setPrecoDeCompra(produto.getPrecoDeCompra());
		to.setCor(produto.getCor());

		request.setAttribute("produto", to);

		RequestDispatcher view = request.getRequestDispatcher("produto.jsp");
		view.forward(request, response);
	}

}
