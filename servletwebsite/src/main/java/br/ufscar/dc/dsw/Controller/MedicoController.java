package br.ufscar.dc.dsw.Controller;


import br.ufscar.dc.dsw.Model.DAO.MedicoDAO;
import br.ufscar.dc.dsw.Model.Entities.Medico;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(urlPatterns = "/medicos/*")
public class MedicoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private MedicoDAO medicoDAO = new MedicoDAO();

    @Override
    public void init() throws ServletException {
        medicoDAO = new MedicoDAO();
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

    private Medico MedicoInfo(HttpServletRequest request, String method) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String crm = request.getParameter("crm");
        String nome = request.getParameter("nome");
        String especialidade = request.getParameter("especialidade");
        if (method.equals("atualizar")) {
            String id = request.getParameter("id");
            return new Medico(senha,email,nome,crm,especialidade);//todo see here
        }
        else {
            return new Medico(senha,email,nome,crm,especialidade);
        }


    }

    private void ApresentarFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // request.setAttribute("editoras", getEditoras());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/medico/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void ApresentarFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void Listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Medico> listaMedicos = medicoDAO.GetAll();
        request.setAttribute("listaMedicos", listaMedicos);
        request.setAttribute("contextPath",request.getContextPath().replace("/", ""));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/medico/listar.jsp");
        dispatcher.forward(request, response);

    }

    private void Inserir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Medico medico = MedicoInfo(request,"inserir");
        medicoDAO.Insert(medico);

        response.sendRedirect("listar");
    }

    private void Remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Medico medico = new Medico(id);
        medicoDAO.Delete(medico);
        response.sendRedirect("listar");
    }

    private void Atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Medico medico = MedicoInfo(request,"atualizar");
        medicoDAO.Update(medico);
        response.sendRedirect("listar");
    }

}
