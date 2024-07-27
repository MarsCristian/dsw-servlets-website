package br.ufscar.dc.dsw.Controller;


import br.ufscar.dc.dsw.Model.DAO.PacienteDAO;
import br.ufscar.dc.dsw.Model.Entities.Paciente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(urlPatterns = "/pacientes/*")
public class PacienteController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PacienteDAO pacienteDAO = new PacienteDAO();

    @Override
    public void init() throws ServletException {
        pacienteDAO = new PacienteDAO();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String action = request.getPathInfo();
        if (action == null){
            action = "";
        }

        try {
            switch (action) {
                case "/cadastro":
                    ApresentarFormCadastro(request,response);
                    break;
                case "/insercao":
                    Inserir(request,response);
                    break;
                case "/remocao":
                    Remover(request,response);
                    break;
                case "/edicao":
                    ApresentarFormEdicao(request,response);
                    break;
                case "/atualizacao":
                    Atualizar(request,response);
                    break;
                default:
                    Listar(request,response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }

    private Paciente PacienteInfo(HttpServletRequest request, String method) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        String dataNascimento = request.getParameter("dataNascimento");

        if (method.equals("atualizar")) {
            String id = request.getParameter("id");
            return new Paciente(senha,email,nome,cpf,telefone,sexo,dataNascimento);
        }
        else {
            return new Paciente(senha,email,nome,cpf,telefone,sexo,dataNascimento);
        }


    }

    private void ApresentarFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/paciente/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void ApresentarFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Paciente paciente = pacienteDAO.GetById(id);
        request.setAttribute("paciente", paciente);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/paciente/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void Listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Paciente> listaPacientes = pacienteDAO.GetAll();
        request.setAttribute("listaPacientes", listaPacientes);
        request.setAttribute("contextPath",request.getContextPath().replace("/", ""));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/paciente/listar.jsp");
        dispatcher.forward(request, response);

    }

    private void Inserir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Paciente paciente = PacienteInfo(request,"inserir");
        pacienteDAO.Insert(paciente);

        response.sendRedirect("listar");
    }

    private void Remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Paciente paciente = new Paciente(id);
        pacienteDAO.Delete(paciente);
        response.sendRedirect("listar");
    }

    private void Atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Paciente paciente = PacienteInfo(request,"atualizar");
        pacienteDAO.Update(paciente);
        response.sendRedirect("listar");
    }

}
