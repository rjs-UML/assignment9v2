package edu.rseymour.advancedjava.servlet;

import edu.rseymour.advancedjava.model.StockQuote;
import edu.rseymour.advancedjava.services.ServiceFactory;
import edu.rseymour.advancedjava.services.StockService;
import edu.rseymour.advancedjava.services.StockServiceException;
import edu.rseymour.advancedjava.util.Interval;
import sun.security.pkcs.ParsingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StockSearchServlet extends HttpServlet {

    // name the parameters
    private static final String SYMBOL_PARAMETER_KEY = "symbol";
    private static final String FROM_PARAMETER_KEY = "from";
    private static final String UNTIL_PARAMETER_KEY = "until";

    /**
     * Retrieves search criteria from form on stockquote.jsp and searches the database for
     * quotes within search criteria.
     *
     * @param request object containing search criteria entered in stockquote.jsp
     * @param response list of
     * @throws IOException
     * @throws ServletException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        String symbol = request.getParameter(SYMBOL_PARAMETER_KEY);
        String fromString = request.getParameter(FROM_PARAMETER_KEY);
        String untilString = request.getParameter(UNTIL_PARAMETER_KEY);

        // turn fromString and untilString into calendar objs
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sFrom;
        Date sUntil;

        try {
            sFrom = dateFormat.parse(fromString);
            sUntil = dateFormat.parse(untilString);
        } catch(ParseException e) {
            throw new ParsingException(e.getMessage());
        }

        Calendar fromCal = Calendar.getInstance();
        Calendar untilCal = Calendar.getInstance();

        fromCal.setTime(sFrom);
        untilCal.setTime(sUntil);


        HttpSession session = request.getSession();
        StockService stockService = ServiceFactory.getStockService();
        List<StockQuote> stocks = null;

        try {
            stocks = stockService.getQuote(symbol,fromCal, untilCal, Interval.DAY);
        } catch(StockServiceException e) {
            e.printStackTrace();
        }

//        stocks = new ArrayList<>(Arrays.asList(
//                new StockQuote(new BigDecimal(100.00), new Date(2019, 01, 01), "APPL"),
//                new StockQuote(new BigDecimal(25.00), new Date(2018, 01, 01), "JTSL")));

        session.setAttribute("stocks", stocks);

        // forward the session
        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher =
                servletContext.getRequestDispatcher("/stockQuoteResults.jsp");
        dispatcher.forward(request, response);

    }
}
