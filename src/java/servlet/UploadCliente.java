package servlet;

import entidades.Cliente;
import entidades.Documento;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClienteDAO;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadCliente extends HttpServlet {

    private File diretorio;
    private String path;
    private Documento doc;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        path = config.getInitParameter("diretorio");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            out.println("<h1>Voce não enviou um arquivo!</h1>");
            return;
        }

        for (String elemento : request.getParameterMap().keySet()) {
            System.out.println(elemento);
        }

        path = path;
        diretorio = new File(path);
        diretorio.mkdirs();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(diretorio);

        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> items = upload.parseRequest(request);
            String valorDoCampo = null;
            for (FileItem item : items) {
                if (item.isFormField()) {
                    String nomeDoCampo = item.getFieldName();
                    valorDoCampo = item.getString();
                    Cliente c = ClienteDAO.Busca_edit(Integer.valueOf(valorDoCampo));

                    if (!path.contains(c.getNome())) {
                        path = path + c.getNome();
                        diretorio = new File(path);
                        diretorio.mkdirs();
                    }
                    System.out.println(nomeDoCampo);
                }
            }
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    String nomeDoCampo = item.getName();
                    doc = new Documento(path, nomeDoCampo, Integer.valueOf(valorDoCampo), false);
                    processUploadedFile(item);
                }
            }
            
            request.getRequestDispatcher("Cadastrar_Doc?nome="+doc.getNome()+"&url="+doc.getUrl()+"&id_cli="+doc.getCliente_id()+"&adm="+doc.isAdm()+"&env=1").forward(request, response);

        } catch (Exception e) {
            out.println("<h1>Erro ao escrever no arquivo!</h1>");
            return;
        }

    }

    private void processUploadedFile(FileItem item) throws Exception {
        String fileName = item.getName();
        File uploadedFile = new File(diretorio, fileName);
        item.write(uploadedFile);
    }
}
