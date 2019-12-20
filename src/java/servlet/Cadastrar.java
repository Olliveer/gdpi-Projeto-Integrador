/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import control.ControleDadosCliente;
import entidades.Cliente;
import java.io.File;
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
 * @author 2017203277
 */
@WebServlet(name = "Cadastrar", urlPatterns = {"/Cadastrar"})
public class Cadastrar extends HttpServlet {

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

            String nome = request.getParameter("nome");
            String cnpj = request.getParameter("cnpj");
            String email = request.getParameter("email");
            String endereco = request.getParameter("endereco");
            int numero;
            if (request.getParameter("numero").isEmpty()) {
                numero = 0;
            }else{
                numero = Integer.parseInt(request.getParameter("numero"));
            }
            String complemento = request.getParameter("complemento");
            String cidade = request.getParameter("cidade");
            String uf = request.getParameter("estado");
            String senha = request.getParameter("senha");

            Cliente novo = new Cliente(nome, cnpj, email, endereco, numero, complemento, cidade, uf, senha, true);
             
            ArrayList<Boolean> erro = ControleDadosCliente.validaDados(novo);

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
                request.getSession().setAttribute("cliente", novo);
                request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            } else {
                ClienteDAO.cadastrar(novo);
                request.getRequestDispatcher("inicio.jsp").forward(request, response);
                new File("C:\\Users\\2017203277\\Documents\\UPLOAD\\"+novo.getNome()).mkdir();
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
