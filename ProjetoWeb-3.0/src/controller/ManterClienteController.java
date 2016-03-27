package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import to.ClienteTO;

/**
 * Servlet implementation class ManterCliente
 */
@WebServlet("/ManterCliente.do")
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterClienteController() {
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
		String cId = request.getParameter("id");
		String cNome = request.getParameter("nome");
		String cFone = request.getParameter("fone");
		String cEndereco = request.getParameter("endereco");
		String cIdade = request.getParameter("idade");

		String acao = request.getParameter("manterCliente");
		Cliente cliente;
		Cliente cli = new Cliente();

		int id = -1;

		try {
			id = Integer.parseInt(cId);
		} catch (NumberFormatException e) {
			
		}

		cliente = new Cliente(id, cNome, cFone, cEndereco, cIdade);

		if ("incluir".equals(acao)) {
			cliente.criar();

		} else if ("alterar".equals(acao)) {
			cliente.atualizar();

		} else if ("deletar".equals(acao)) {
			cliente.excluir();
		}

		cliente.carregar();

		ClienteTO to = new ClienteTO();
		to.setId(cliente.getId());
		to.setNome(cliente.getNome());
		to.setTelefone(cliente.getTelefone());
		to.setEndereco(cliente.getEndereco());
		to.setNasc(cliente.getNasc());

		request.setAttribute("cliente", to);

		RequestDispatcher view = request.getRequestDispatcher("cliente.jsp");
		view.forward(request, response);
	}

}
