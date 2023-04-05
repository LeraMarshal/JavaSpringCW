package de.marshal.javaspringcw.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@WebServlet(
        name = "Hello World Servlet",
        urlPatterns = {"/servlets/HelloWorldServlet"})
public class HelloWorldServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(HelloWorldServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // scheme    hostname      port      uri         query_string
        // http://some.domain.name:port/path/to/resource?param1=value1&param2=value2

        // method         uri          query_string          protocol
        // GET /path/to/resource?param1=value1&param2=value2 HTTP/1.1
        // Host: some.domain.name:port
        log.info("method={}, uri={}, queryString={}", req.getMethod(), req.getRequestURI(), req.getQueryString());

        resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                                                      // mime-type
        resp.addHeader(HttpHeaders.CONTENT_TYPE, "application/json"); // "application/json;charset=utf-8" -> json это всего utf-8 (MediaType.APPLICATION_JSON_VALUE)

        Writer writer = resp.getWriter();
        writer.write("""
                {
                    "status": "Accepted",
                    "error": null
                }
                """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!MediaType.APPLICATION_JSON_VALUE.equals(req.getContentType())){ // header
            throw new ServletException("Invalid content-type");
        }

        InputStream inputStream = req.getInputStream();

        byte[] bytes = inputStream.readAllBytes();
        String body = new String(bytes, StandardCharsets.UTF_8);

        log.info("request body={}", body);

        // ответ
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType(MediaType.APPLICATION_JSON_VALUE);

        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(bytes);
    }
}
