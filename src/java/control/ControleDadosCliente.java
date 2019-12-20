/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidades.Cliente;
import java.util.ArrayList;

/**
 *
 * @author 2017202777
 */
public class ControleDadosCliente {

    public static ArrayList validaDados(Cliente novo) {

        ArrayList<Boolean> erro = new ArrayList();
        
        if (novo.getNome().isEmpty() || novo.getNome().length() < 3) {
            erro.add(true);
        } else {
            erro.add(false);
        }
        if (novo.getCnpj().isEmpty() || !validaCNPJ(novo.getCnpj())) {
            erro.add(true);
        } else {
            erro.add(false);
        }
        if (novo.getEmail().isEmpty()) {
            erro.add(true);
        } else {
            erro.add(false);
        }
        if (novo.getEndereco().isEmpty()) {
            erro.add(true);
        } else {
            erro.add(false);
        }
        if (novo.getNumero() < 1) {
            erro.add(true);
        } else {
            erro.add(false);
        }
        if (novo.getCidade().isEmpty()) {
            erro.add(true);
        } else {
            erro.add(false);
        }
        if (novo.getUf().isEmpty() && novo.getUf().length() < 6) {
            erro.add(true);
        } else {
            erro.add(false);
        }
        boolean num = false;
        boolean maiusculo = false;
        for (int i = 0; i < novo.getSenha().length(); i++) {
            char x = novo.getSenha().charAt(i);
            if (Character.isUpperCase(x)) {
                maiusculo = true;
                break;
            }
        }
        for (int i = 0; i < novo.getSenha().length(); i++) {
            char x = novo.getSenha().charAt(i);
            if (Character.isDigit(x)) {
                num = true;
                break;
            }
        }
        if (maiusculo && num && novo.getSenha().length() > 6 && novo.getSenha() != null) {
            erro.add(false);
        } else {
            erro.add(true);
        }

        return erro;
    }

    private static boolean validaCNPJ(String cnpj) {
        if (!cnpj.substring(0, 1).equals("")) {
            try {
                cnpj = cnpj.replace('.', ' ');
                cnpj = cnpj.replace('/', ' ');
                cnpj = cnpj.replace('-', ' ');
                cnpj = cnpj.replaceAll(" ", "");
                int soma = 0;
                int dig;
                String cnpj_calc = cnpj.substring(0, 12);
                
                if (cnpj.length() != 14) {
                    return false;
                }
                char[] chr_cnpj = cnpj.toCharArray();
//                primeiro digito
                for (int i = 0; i < 4; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                        soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
//                segundo digito
                soma = 0;
                for (int i = 0; i < 5; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                        soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
                return cnpj.equals(cnpj_calc);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

}
