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
public class Documento{
    
    private int id_documento;
    private String url;
    private String nome;
    private int cliente_id;
    private boolean ativo_doc;
    private boolean adm;
    private String data;

    public Documento(int id_documento, String url, String nome, int cliente, boolean ativo_doc, String data, boolean adm) {
        this.id_documento = id_documento;
        this.url = url;
        this.nome = nome;
        this.cliente_id = cliente;
        this.ativo_doc = ativo_doc;
        this.adm = adm;
        this.data = data;
    }

    public Documento(String url,String nome , int cliente, boolean ativo_doc, boolean adm, String data) {
        this.url = url;
        this.nome = nome;
        this.cliente_id = cliente;
        this.ativo_doc = ativo_doc;
        this.adm = adm;
        this.data = data;
    }

    public Documento(String url, String nome, int cliente_id, boolean adm) {
        this.url = url;
        this.nome = nome;
        this.cliente_id = cliente_id;
        this.adm = adm;
    }
    
    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente) {
        this.cliente_id = cliente;
    }

    public boolean isAtivo_doc() {
        return ativo_doc;
    }

    public void setAtivo_doc(boolean ativo_doc) {
        this.ativo_doc = ativo_doc;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Documento{" + "url=" + url + ", nome=" + nome + ", cliente_id=" + cliente_id + ", ativo_doc=" + ativo_doc + ", adm=" + adm + ", data=" + data + '}';
    }
}
