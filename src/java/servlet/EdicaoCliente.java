/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import control.ControleDadosCliente;
import entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClienteDAO;

/**
 *
 * @author 2017202777
 */
@WebServlet(name = "BtnEdita", urlPatterns = {"/BtnEdita"})
public class EdicaoCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            int id = Integer.valueOf(request.getParameter("idCliente"));
            String nome = request.getParameter("txtNome");
            String cnpj = request.getParameter("txtCnpj");
            String email = request.getParameter("txtEmail");
            String endereco = request.getParameter("txtEndereco");
            int numero;
            if (request.getParameter("txtNumero").isEmpty()) {
                numero = 0;
            } else {
                numero = Integer.parseInt(request.getParameter("txtNumero"));
            }
            String complemento = request.getParameter("txtComplemento");
            String cidade = request.getParameter("txtCidade");
            String uf = request.getParameter("txtUf");
            String senha = request.getParameter("txtSenha");

            Cliente alterado = new Cliente(id, nome, cnpj, email, endereco, numero, complemento, cidade, uf, senha, true);

            ArrayList<Boolean> erro = ControleDadosCliente.validaDados(alterado);

            ArrayList<String> txtErro = new ArrayList<>();

            boolean teste = false;

            for (int i = 0; i < erro.size(); i++) {
                if (erro.get(i)) {
                    txtErro.add(i, "*Campo inválido!");
                    teste = true;
                } else {
                    txtErro.add(i, "");
                }
            }

            if (teste) {
                request.getSession().setAttribute("erro", txtErro);
                request.getRequestDispatcher("update_cliente.jsp?id="+id).forward(request, response);
            } else {
                ClienteDAO.alterar(alterado);                                                                         
                request.getRequestDispatcher("inicio.jsp").forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
