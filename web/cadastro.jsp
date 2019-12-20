<%-- 
    Document   : cada
    Created on : 06/11/2018, 16:18:34
    Author     : matheus.rocha
--%>

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
                    <h3>Cadastrar Novo Cliente</h3>
                </div>

                <ul class="list-unstyled components">
                    <p>Painel de controle</p>
                    <li>
                        <a href="inicio.jsp">Inicio</a>
                    </li>

                    <li class="active">
                        <a href="#">Cadastrar Cliente</a>
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


                <form class="form-horizontal" action="Cadastrar" method="post">
                    <fieldset>

                        <!-- Nome-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtcodigo_produto_id">Nome : </label>  
                            <div class="col-md-4">
                                <input name="nome"  type="text" value="${cliente.getNome()}" placeholder="Nome do Cliente" class="form-control input-md" ><font face="Calibri" color="red"> ${erro.get(0)}</font>

                            </div>
                        </div>

                        <!-- CNPJ-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtproduto">CNPJ : </label>  

                            <div class="col-md-4">
                                <input name="cnpj" type="text" id="cnpj" placeholder="CNPJ do cliente" class="form-control input-md" value="${cliente.getCnpj()}">  <font face="Calibri" color="red">${erro.get(1)}</font> 

                            </div>
                        </div>

                        <!-- email-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtproduto">Email : </label>  
                            <div class="col-md-4">
                                <input type="email" name="email" value="${cliente.getEmail()}" placeholder="Email do cliente" class="form-control input-md"> <font face="Calibri" color="red">${erro.get(2)}</font> 

                            </div>
                        </div>

                        <!-- Endereço-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtproduto">Endereço : </label>  
                            <div class="col-md-4">
                                <input type="text" name="endereco" value="${cliente.getEndereco()}" placeholder="Endereço do cliente" class="form-control input-md"> <font face="Calibri" color="red">${erro.get(3)}</font> 

                            </div>
                        </div>


                        <!-- Numero-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtproduto">Número : </label>  
                            <div class="col-md-4">
                                <input type="number" name="numero" value="${cliente.getNumero()}" class="form-control input-md"> <font face="Calibri" color="red">${erro.get(4)}</font> 

                            </div>
                        </div>


                        <!-- Complemento-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtproduto">Complemento : </label>  
                            <div class="col-md-4">
                                <input type="text" name="complemento" value="${cliente.getComplemento()}" placeholder="Casa? Apartamento? Descrição do local" class="form-control input-md">

                            </div>
                        </div>





                        <!-- Cidade -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtgrupo">Cidade : </label>
                            <div class="col-md-4">
                                
                                <input type="text" name="cidade" value="${cliente.getCidade()}" placeholder="Cidade" class="form-control input-md">
                           
                            </div>
                        </div>

                        <!-- Estado -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="Cidade_id">Estado : </label> <font face="Calibri" color="red">${erro.get(6)}</font> 
                            <div class="col-md-4">
                                <input type="text" name="estado" value="${cliente.getUf()}" placeholder="Estado" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Senha-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtestoque_atual">Senha : </label>  
                            <div class="col-md-4">
                                <input type="password" name="senha" class="form-control input-md"> <font face="Calibri" color="red">${erro.get(7)}</font> <small class="form-text text-muted">A senha deve conter letras MAIÚSCULAS, minúsculas e números!.</small> 

                            </div>
                        </div>

                        <!-- Botoes -->
                        <div class="form-group">

                            <div class="col-md-8">
                                <input type="submit" value="Cadastrar" class="btn btn-success">
                                <input type="submit" value="Cancelar" class="btn btn-warning">

                            </div>
                        </div>

                    </fieldset>

                </form>

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
