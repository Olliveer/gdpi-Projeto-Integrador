<%-- 
    Document   : inicio
    Created on : 08/11/2018, 19:40:08
    Author     : 2017202777
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.DocumentoDAO"%>
<%@page import="model.TelefoneDAO"%>
<%@page import="entidades.Telefone"%>
<%@page import="model.ClienteDAO"%>
<%@page import="entidades.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <!-- Bootstrap CSS CDN -->
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Estilos da fonte JS -->
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" crossorigin="anonymous"></script>


        <link href='http://fonts.googleapis.com/css?family=OpenSans:300,400,700' rel='stylesheet' type='text/css'>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">

        <!-- Janela modal -->
        <link rel="stylesheet" href="css/modal.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!-- TABELA COM PESQUISA -->

        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>

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
                    
                    <li class="active">
                        <a href="#">Inicio</a>
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

                <!-- aqui vai o corpo do site -->

                <%
                    ArrayList<Cliente> lista = ClienteDAO.consultaClientes();
                %>
                
                <nav class="navbar navbar-expand-lg navbar-light bg-light" >
                    <div class="container-fluid div_tabela">
                        <table id="tabelin" name="tb" class="table table-striped table-bordered table-hover">

                            <thead>
                                <tr>
                                    <th class="text-center">Id</th>
                                    <th>Razão Social</th>
                                    <th class="text-center">CNPJ</th>
                                    <th class="text-center">EMAIL</th>
                                    <th class="text-center">ENDEREÇO</th>

                                    <th class="text-center">AÇÃO</th>
                                </tr>
                            </thead>
                            <tbody class="table-striped">
                                <%
                                    for (int i = 0; i < lista.size(); i++) {
                                        Cliente c = lista.get(i);
                                %>
                                <tr>
                                    <td class="text-center"><%= c.getId_cliente()%></td>
                                    <td><%= c.getNome()%></td>
                                    <td class="text-center"><%= c.getCnpj()%></td>
                                    <td class="text-center"><%= c.getEmail()%></td>
                                    <td class="text-center"><%= c.getEndereco()%></td>




                                    <td class="text-center">
                                        <a href="Documentos.jsp?id=<%= c.getId_cliente()%>" class="btn btn-info " data-toggle="tooltip" title="Ir para documento(s)"><i class="glyphicon glyphicon-folder-open"></i>  </a>
                                        <a href="update_cliente.jsp?id=<%= lista.get(i).getId_cliente()%>" class="btn btn-primary"> <i class="glyphicon glyphicon-edit"></i> Editar </a>
                                        <a href="Excluir?id=<%= c.getId_cliente()%>" class="btn btn-danger "><i class="glyphicon glyphicon-trash"></i> Excluir </a>
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </nav>

                <!-- Termina o corpo do site -->
                <div class="line"></div>


            </div> <!-- DIV CONTENT acaba aqui-->
        </div>

        <!-- jQuery CDN - Slim version (=without AJAX) -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" crossorigin="anonymous"></script>
        <!-- Popper.JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" crossorigin="anonymous"></script>
        <!-- Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" crossorigin="anonymous"></script>


        <!-- ESTE JS FAZZ A FUNÇÃO DO SIDEBAR DE ABRIR E ESCONDER -->
        <script type="text/javascript">
            $(document).ready(function () {
                $('#sidebarCollapse').on('click', function () {
                    $('#sidebar').toggleClass('active');
                });
            });
        </script>

        <!-- ESTE SCRIPT SERVE PARA ESTILIZAR A TABELA COM PAGINAÇÃO E FILTRAGEM -->
        <script type="text/javascript">

            $(document).ready(function () {
                $('#tabelin').DataTable();
            });

        </script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="js/tabela.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>

        <script>

            function cliente(id) {

                var op = id;

            }

            function contaLinhasTabela() {
                var tabela = document.getElementById('tabelin');
                var linhas = tabela.getElementsByTagName('tr');
                alert('A tabela tabelin possui ' + linhas.length + ' linhas' + tabela);
            }
        </script>

    </body>
</html>
