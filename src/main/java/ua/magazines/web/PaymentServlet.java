package ua.magazines.web;

import ua.magazines.entity.Magazine;
import ua.magazines.entity.Payment;
import ua.magazines.entity.User;
import ua.magazines.service.MagazineService;
import ua.magazines.service.PaymentService;
import ua.magazines.service.UserService;
import ua.magazines.service.impl.MagazineServiceImpl;
import ua.magazines.service.impl.PaymentServiceImpl;
import ua.magazines.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class PaymentServlet extends HttpServlet {

    private final PaymentService paymentService = PaymentServiceImpl.getPaymentService();
    private final MagazineService magazineService = MagazineServiceImpl.getMagazineService();
    private final UserService userService = UserServiceImpl.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String magazineId = request.getParameter("magazineId");
        String price = request.getParameter("price");

        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        Magazine magazine = magazineService.read(Integer.parseInt(magazineId));
        User user = userService.read(userId);

        Payment payment = new Payment();
      //  payment.setId(999);
        payment.setId(UUID.randomUUID().toString());
        payment.setMagazine(magazine);
        payment.setUser(user);
        payment.setDateOfPayment(new Date());
        payment.setSumPayment(Double.parseDouble(price));
        paymentService.create(payment);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String paymentId = request.getParameter("paymentId");
        paymentService.delete(Integer.parseInt(paymentId));

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }
}
