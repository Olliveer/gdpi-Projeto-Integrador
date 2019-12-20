/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.ConnectionFactory.getConnection;

/**
 *
 * @author 2017202777
 */
public class ClienteDAO {

    public static Cliente logar(String em, String se) {
        try {
            Connection con = ConnectionFactory.getConnection();

            String sql = "SELECT * FROM cliente WHERE email=? AND senha=? AND ativo=1";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, em);
            stmt.setString(2, se);

            ResultSet rs = stmt.executeQuery();

            if (rs.first()) {
                int id_cliente = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                int numero = rs.getInt("numero_empresa");
                String complemento = rs.getString("complemento");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("UF");
                String senha = rs.getString("senha");
                boolean ativo = rs.getBoolean("ativo");

                Cliente autenticado = new Cliente(id_cliente, nome, cnpj, email, endereco, numero, complemento, cidade, uf, senha, ativo);

                stmt.close();
                con.close();
                return autenticado;

            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Ocorreu o erro: " + e);
            return null;

        }

        return null;//não existe esse email/senha
    }

    public static ArrayList<Cliente> consultaClientes() throws ClassNotFoundException {
        ArrayList<Cliente> lista = new ArrayList();
        try {
            Connection consulta = ConnectionFactory.getConnection();

            String sql = "SELECT * FROM cliente WHERE ativo=1";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int id_cliente = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                int numero = rs.getInt("numero_empresa");
                String complemento = rs.getString("complemento");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String senha = rs.getString("senha");
                boolean ativo = rs.getBoolean("ativo");

               Cliente c = new Cliente(id_cliente, nome, cnpj, email, endereco, numero, complemento, cidade, uf, senha, ativo);
               
               lista.add(c);
            }
            rs.close();
            stmt.close();

            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
    }

    public static void cadastrar(Cliente novo) {

        try {
            Connection con = ConnectionFactory.getConnection();

            String sql = "INSERT INTO cliente "
                    + "(nome, cnpj, email, endereco, numero_empresa, complemento, cidade, uf, senha, ativo) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, novo.getNome());
            stmt.setString(2, novo.getCnpj());
            stmt.setString(3, novo.getEmail());
            stmt.setString(4, novo.getEndereco());
            stmt.setInt(5, novo.getNumero());
            stmt.setString(6, novo.getComplemento());
            stmt.setString(7, novo.getCidade());
            stmt.setString(8, novo.getUf());
            stmt.setString(9, novo.getSenha());
            stmt.setBoolean(10, true);

            stmt.execute();

            stmt.close();

            con.close();

        } catch (Exception e) {
            System.out.println("Ocorreu o erro: " + e);
        }
    }
    
    public static void apagar(int id_cliente) {

        try {
            Connection con = ConnectionFactory.getConnection();

            String sql = "UPDATE cliente SET ativo = 0 WHERE id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id_cliente);

            stmt.execute();

            stmt.close();

            con.close();

        } catch (Exception e) {
            System.out.println("Ocorreu o erro: " + e);
        }
    }
    
    public static Cliente Busca_edit(int id) {
        try {
            Connection con = ConnectionFactory.getConnection();
            
            String sql = "SELECT * FROM cliente WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.first()) {
                int id_cliente = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                int numero = rs.getInt("numero_empresa");
                String complemento = rs.getString("complemento");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("UF");
                String senha = rs.getString("senha");
                boolean ativo = rs.getBoolean("ativo");

                Cliente autenticado = new Cliente(id_cliente, nome, cnpj, email, endereco, numero, complemento, cidade, uf, senha, ativo);

                stmt.close();
                con.close();
                
                return autenticado;

            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Ocorreu o erro: " + e);
            return null;

        }

        return null;//não existe esse email/senha
    }
    
    public static void alterar(Cliente alterado) {

        try {
            Connection con = ConnectionFactory.getConnection();

            String sql = "UPDATE cliente SET nome=?,"
                    + " cnpj=?,"
                    + " email=?,"
                    + " endereco=?,"
                    + " numero_empresa=?,"
                    + " complemento=?,"
                    + " cidade=?,"
                    + " UF=?,"
                    + " senha=?"
                    + " WHERE id=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, alterado.getNome()); 
            stmt.setString(2, alterado.getCnpj()); 
            stmt.setString(3, alterado.getEmail()); 
            stmt.setString(4, alterado.getEndereco()); 
            stmt.setInt(5, alterado.getNumero()); 
            stmt.setString(6, alterado.getComplemento()); 
            stmt.setString(7, alterado.getCidade()); 
            stmt.setString(8, alterado.getUf()); 
            stmt.setString(9, alterado.getSenha()); 
            stmt.setInt(10, alterado.getId_cliente() );
            
            stmt.execute();

            stmt.close();

            con.close();

        } catch (Exception e) {
            System.out.println("Ocorreu o erro: " + e);
        }
    }
}
