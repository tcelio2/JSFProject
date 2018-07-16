package br.com.livraria2.servlets;

import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria2.infra.FileSaver;

@WebServlet("/file/*")
public class FileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException, IOException {

		//PARTE REFERENTE A REQUISICAO (REQUEST)	
		String path = req.getRequestURI().split("/file")[1];		
		Path source = Paths.get(FileSaver.SERVER_PATH + "/" + path);
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String contentType = fileNameMap.getContentTypeFor("file:"+source);
		
		//PARTE REFERENTE AO (RESPONSE)
		res.reset();
		res.setContentType(contentType);
		res.setHeader("Content-Length", String.valueOf(Files.size(source)));
		res.setHeader("Content-Disposition", 
				"filename=\""+source.getFileName().toString() + "\"");
				
		//PARTE QUE SOLICITA A IMAGEM PARA O METODO DA CLASSE FILESAVER.JAVA
		FileSaver.transfer(source, res.getOutputStream());
	}


}
