<%-- 
    Document   : cada
    Created on : 06/11/2018, 16:18:34
    Author     : matheus.rocha
--%>
<%@page import="model.ClienteDAO"%>
<%@page import="java.sql.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="entidades.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           Bootstrap CSS CDN -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" crossorigin="anonymous">
        <!-- Our Custom CSS -->
        <link rel="stylesheet" href="style.css">

        <!-- Estilos da fonte JS -->
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" crossorigin="anonymous"></script>


        <link href='http://fonts.googleapis.com/css?family=OpenSans:300,400,700' rel='stylesheet' type='text/css'>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

        <title>Cad Cliente</title>
    </head>
    <body>
        <div class="wrapper">
            <!-- Sidebar  -->
            <nav id="sidebar">
                <div class="sidebar-header ">
                    <h3>Lista de Clientes</h3>
                </div>

                <ul class="list-unstyled components">
                    <p>Painel de controle</p>
                    <li>
                        <a href="inicio.jsp">Inicio</a>
                    </li>

                    <li>
                        <a href="cadastro.jsp">Cadastrar Cliente</a>
                    </li>

                    <small>
                        <li>
                            <a href="index.html#openModal">Deslogar</a>
                        </li>
                    </small> 
                </ul>

                <ul class="list-unstyled CTAs">

                </ul>
            </nav>

            <!-- Page Content  -->
            <div id="content">

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button type="button" id="sidebarCollapse" class="btn btn-info">
                            <i class="fas fa-align-left"></i>
                            <span>MENU</span>
                        </button>
                        <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fas fa-align-justify"></i>
                        </button>

                    </div>
                </nav>

                <%
                    //Conexao ao banco de dados:
                    
                    int id = Integer.parseInt(request.getParameter("id"));
                    Cliente c = ClienteDAO.Busca_edit(id);
                    if(!c.getCnpj().equals(null)) {
                %>
                
                <form class="form-horizontal" action="BtnEdita" method="post">
                    
                    <fieldset>

                        <!-- Nome-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtcodigo_produto_id">Nome : </label>  
                            <div class="col-md-4">
                                <input name="idCliente" type="hidden" value="<%= c.getId_cliente()%>" placeholder="Nome do Cliente" class="form-control input-md" required>
                                <input name="txtNome"  type="text" value="<%= c.getNome()%>" placeholder="Nome do Cliente" class="form-control input-md" required><font face="Calibri" color="red"> ${erro.get(0)}</font>

                            </div>
                        </div>

                        <!-- CNPJ-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtproduto">CNPJ : </label>  

                            <div class="col-md-4">
                                <input name="txtCnpj" type="text" id="cnpj" placeholder="CNPJ do cliente" class="form-control input-md" value="<%= c.getCnpj()%>" required> <font face="Calibri" color="red"> ${erro.get(1)}</font>

                            </div>
                        </div>

                        <!-- email-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" >Email : </label>  
                            <div class="col-md-4">
                                <input type="email" name="txtEmail" value="<%= c.getEmail()%>" placeholder="Email do cliente" class="form-control input-md" required> <font face="Calibri" color="red"> ${erro.get(2)}</font>

                            </div>
                        </div>

                        <!-- Endereço-->
                        <div class="form-group">
                            <label class="col-md-4 control-label">Endereço : </label>  
                            <div class="col-md-4">
                                <input type="text" name="txtEndereco" value="<%= c.getEndereco()%>" placeholder="Endereço do cliente" class="form-control input-md" required><font face="Calibri" color="red"> ${erro.get(3)}</font>

                            </div>
                        </div>


                        <!-- Numero-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" >Número : </label>  
                            <div class="col-md-4">
                                <input type="number" name="txtNumero" value="<%= c.getNumero()%>" class="form-control input-md" required><font face="Calibri" color="red"> ${erro.get(4)}</font>

                            </div>
                        </div>


                        <!-- Complemento-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" >Complemento : </label>  
                            <div class="col-md-4">
                                <input type="text" name="txtComplemento" value="<%= c.getComplemento()%>" placeholder="Casa? Apartamento? Descrição do local" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Cidade -->
                        <div class="form-group">
                            <label class="col-md-4 control-label">Cidade : </label>
                            <div class="col-md-4">
                                <input type="text" name="txtCidade" value="<%= c.getCidade()%>" placeholder="Cidade" class="form-control input-md" required><font face="Calibri" color="red"> ${erro.get(5)}</font>                  
                            </div>
                        </div>

                        <!-- Estado -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="estado">Estado : </label> 
                            <div class="col-md-4">
                                <input  id="estado" type="text" name="txtUf" value="<%= c.getUf()%>" placeholder="Estado" class="form-control input-md" required=""><font face="Calibri" color="red"> ${erro.get(6)}</font>                         

                            </div>
                        </div>

                        <!-- Senha-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtestoque_atual">Senha : </label>  
                            <div class="col-md-4">
                                <input type="password" name="txtSenha" class="form-control input-md" value="<%= c.getSenha()%>" required> <small class="form-text text-muted">A senha deve conter letras MAIÚSCULAS, minúsculas e números!.</small> <font face="Calibri" color="red">${erro.get(7)}</font> 

                            </div>
                        </div>

                        <!-- Botoes -->
                        <div class="form-group">

                            <div class="col-md-8">
                                <input type="submit" value="Salvar alteração" class="btn btn-primary">
                                <a href="inicio.jsp" class="btn btn-danger">Cancelar</a>
                            </div>

                            <div class="col-md-8">


                            </div>
                        </div>

                    </fieldset>

                </form>
                <%}%>
                <div class="line"></div>


            </div> <!-- DIV CONTENT acaba aqui-->
        </div>

        <!-- jQuery CDN - Slim version (=without AJAX) -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" crossorigin="anonymous"></script>
        <!-- Popper.JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" crossorigin="anonymous"></script>
        <!-- Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" crossorigin="anonymous"></script>


        <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="js/jquery.maskedinput.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/jquery.zebra-datepicker.js"></script>


        <!-- ESTE JS FAZZ A FUNÇÃO DO SIDEBAR DE ABRIR E ESCONDER -->
        <script type="text/javascript">
            $(document).ready(function () {
                $('#sidebarCollapse').on('click', function () {
                    $('#sidebar').toggleClass('active');
                });
            });
        </script>


    </body>
</html>