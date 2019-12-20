/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entidades.Documento;
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
public class DocumentoDAO {
    
    public static int qtdDocumentos(int id_cliente) throws ClassNotFoundException {
        int qtd = 0;
        try {
            Connection consulta = ConnectionFactory.getConnection();

            String sql = "SELECT COUNT(*) AS qtd FROM documentos WHERE cliente_id = ? AND ativo=1";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            
            stmt.setInt(1, id_cliente);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.first()) {

                qtd = rs.getInt("qtd");
                
            }
            rs.close();
            stmt.close();

            return qtd;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return qtd;
        }
    }
    
    public static void cadastrar(Documento novo) {

        try {
            Connection con = ConnectionFactory.getConnection();

            String sql = "INSERT INTO documentos "
                    + "(cliente_id, url, nome, data_env_doc, enviado_adm, ativo) "
                    + "VALUES(?,?,?,CURDATE(),?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, novo.getCliente_id());
            stmt.setString(2, novo.getUrl());
            stmt.setString(3, novo.getNome());
            
            if (novo.isAdm()) {
                stmt.setBoolean(4, true);
            }else{
                stmt.setBoolean(4, false);
            }
            stmt.setBoolean(5, true);

            stmt.execute();

            stmt.close();

            con.close();

        } catch (Exception e) {
            System.out.println("Ocorreu o erro: " + e);
        }
    }
    
    public static void apagar(int id_doc) {

        try {
            Connection con = ConnectionFactory.getConnection();

            String sql = "UPDATE documentos SET ativo = 0 WHERE id_doc = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id_doc);

            stmt.execute();

            stmt.close();

            con.close();

        } catch (Exception e) {
            System.out.println("Ocorreu o erro: " + e);
        }
    }
    
    public static ArrayList<Documento> consultaDocs(int id_cli) throws ClassNotFoundException {
        ArrayList<Documento> lista = new ArrayList();
        try {
            Connection consulta = ConnectionFactory.getConnection();
            
            String sql = "SELECT * FROM documentos WHERE ativo=? AND cliente_id =?";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            
            stmt.setBoolean(1, true);
            stmt.setInt(2, id_cli);
            
            ResultSet rs = stmt.executeQuery();
            int i=0;
            while (rs.next()) {

                int id = rs.getInt("id_doc");
                int id_cliente = rs.getInt("cliente_id");
                String url = rs.getString("url");
                String nome = rs.getString("nome");
                String data = rs.getString("data_env_doc");
                boolean env_adm = rs.getBoolean("enviado_adm");
                boolean ativo = rs.getBoolean("ativo");

               Documento d = new Documento(id, url, nome, id_cliente, ativo, data, env_adm);
               
               lista.add(d);
            }
            
            rs.close();
            stmt.close();

            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
    }
    
    public static Documento download(int id_doc) {
        try {
            
            Connection con = ConnectionFactory.getConnection();

            String sql = "SELECT * FROM documentos WHERE id_doc=? AND ativo=1";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_doc);

            ResultSet rs = stmt.executeQuery();

            if (rs.first()) {
                int id = rs.getInt("id_doc");
                int id_cliente = rs.getInt("cliente_id");
                String url = rs.getString("url");
                String nome = rs.getString("nome");
                String data = rs.getString("data_env_doc");
                boolean ativo = rs.getBoolean("ativo");
                boolean enviado_adm = rs.getBoolean("enviado_adm");
                

                Documento autenticado = new Documento(id, url, nome, id_cliente, ativo, data, enviado_adm);

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
}
