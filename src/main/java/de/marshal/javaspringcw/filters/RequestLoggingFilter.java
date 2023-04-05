package de.marshal.javaspringcw.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestLoggingFilter implements Filter { // jakarta.servlet пакет
    private static final Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class.getName());
    /*
    Сервлет — это специальный интерфейс, который нужен для обмена информацией между серверной и клиентской частью программы.
    Сервлет размещается на сервере, принимает запросы от клиента и отправляет на них ответы.
    Он управляет общением между разными частями приложения.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("servletRequest: {}", servletRequest); // Логирование (вывод на экран значения переменной)


        if (servletRequest instanceof HttpServletRequest){
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

            log.info(
                    "Received request, path={}{}",
                    httpServletRequest.getRequestURI(),
                    httpServletRequest.getQueryString());
        }

        filterChain.doFilter(servletRequest, servletResponse); // Передача запроса по цепочке

        log.info("servletResponse: {}", servletResponse);
    }
}
