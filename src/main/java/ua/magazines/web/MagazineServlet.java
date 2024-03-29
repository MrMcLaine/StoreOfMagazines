package ua.magazines.web;


import ua.magazines.entity.Magazine;
import ua.magazines.service.MagazineService;
import ua.magazines.service.impl.MagazineServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MagazineServlet extends HttpServlet {

    MagazineService magazineService = MagazineServiceImpl.getMagazineService();

    // to create resource (magazine)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        Magazine magazine  = new Magazine();
        magazine.setName(name);
        magazine.setDescription(description);
        magazine.setPriceForMount(getValidatedPrice(price));
        magazineService.create(magazine);
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

    private double getValidatedPrice(String price) {
        if(price == null || price.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(price);
    }

    // to get resource (magazine)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String magazineId = request.getParameter("id");

        Magazine magazine = magazineService.read(Integer.parseInt(magazineId));

        request.setAttribute("singleMagazine", magazine);
        request.getRequestDispatcher("singleMagazine.jsp").forward(request, response);
    }

    // to update resource (magazine)
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doPut(req, resp);
    }

    // to delete resource (magazine)
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doDelete(req, resp);
    }
}
