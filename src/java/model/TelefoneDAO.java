/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entidades.Telefone;
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
public class TelefoneDAO {
    
    public static ArrayList<Telefone> consultaTelefone(int id_cliente) throws ClassNotFoundException {
        
        ArrayList<Telefone> lista = new ArrayList();
        try {
            Connection consulta = ConnectionFactory.getConnection();

            String sql = "SELECT * FROM telefone WHERE cliente_id = ? AND ativo=1";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setInt(1, id_cliente);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
               int numero = rs.getInt("numero");
               int ddd = rs.getInt("ddd");
               
               Telefone t = new Telefone(numero, ddd, id_cliente, true);
               
               lista.add(t);
            }
            rs.close();
            stmt.close();

            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return lista;
        }
    }
    
    public static void cadastrar(Telefone novo) {

        try {
            Connection con = ConnectionFactory.getConnection();

            String sql = "INSERT INTO telefone "
                    + "(cliente_id, numero, DDD, ativo) "
                    + "VALUES(?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, novo.getCliente_id());
            stmt.setInt(2, novo.getNumero());
            stmt.setInt(3, novo.getDdd());
            stmt.setBoolean(4, true);

            stmt.execute();

            stmt.close();

            con.close();

        } catch (Exception e) {
            System.out.println("Ocorreu o erro: " + e);
        }
    }
}
