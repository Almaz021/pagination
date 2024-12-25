package ru.itis.fisd.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.itis.fisd.service.ProfessionService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/profession")
public class ProfessionServlet extends HttpServlet {
    final static Logger logger = LogManager.getLogger(ProfessionServlet.class);
    private final ProfessionService service = new ProfessionService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String page = request.getParameter("page");
            String profession = request.getParameter("name");
            if (page == null || page.isEmpty()) page = "1";
            if (profession == null) profession = "";

            request.setAttribute("professions",
                    service.findByName(profession, 25, (Integer.parseInt(page) - 1) * 25));

            int countPages = service.countResults(profession) / 25;

            List<Integer> cpList = new ArrayList<>();
            for (int i = 1; i <= countPages; ++i) {
                cpList.add(i);
            }

            System.out.println(cpList);
            request.setAttribute("name", profession);
            request.setAttribute("countPages", cpList);
            request.getRequestDispatcher("/profession.ftl").forward(request, response);
        } catch (IOException | ServletException e) {
            logger.error(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String page = request.getParameter("page");
            String profession = request.getParameter("name");
            if (page == null || page.isEmpty()) page = "1";
            if (profession == null) profession = "";

            request.setAttribute("professions",
                    service.findByName(profession, 25, (Integer.parseInt(page) - 1) * 25));

            int countPages = service.countResults(profession) / 25;

            List<Integer> cpList = new ArrayList<>();
            for (int i = 1; i <= countPages; ++i) {
                cpList.add(i);
            }

            System.out.println(cpList);

            request.setAttribute("countPages", cpList);
            request.setAttribute("name", profession);
            request.getRequestDispatcher("/profession.ftl").forward(request, response);
        } catch (IOException | ServletException e) {
            logger.error(e);
        }
    }
}