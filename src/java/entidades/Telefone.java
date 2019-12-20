/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author 2017202777
 */
public class Telefone {
    
    private int id_telefone;
    private int numero;
    private int ddd;
    private int cliente_id;
    private boolean ativo;

    public Telefone(int id_telefone, int numero, int ddd, int cliente_id, boolean ativo) {
        this.id_telefone = id_telefone;
        this.numero = numero;
        this.ddd = ddd;
        this.cliente_id = cliente_id;
        this.ativo = ativo;
    }

    public Telefone(int numero, int ddd, int cliente_id, boolean ativo) {
        this.numero = numero;
        this.ddd = ddd;
        this.cliente_id = cliente_id;
        this.ativo = ativo;
    }
    
    /**
     * @return the id_telefone
     */
    public int getId_telefone() {
        return id_telefone;
    }

    /**
     * @param id_telefone the id_telefone to set
     */
    public void setId_telefone(int id_telefone) {
        this.id_telefone = id_telefone;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the ddd
     */
    public int getDdd() {
        return ddd;
    }

    /**
     * @param ddd the ddd to set
     */
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    /**
     * @return the cliente_id
     */
    public int getCliente_id() {
        return cliente_id;
    }

    /**
     * @param cliente_id the cliente_id to set
     */
    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
