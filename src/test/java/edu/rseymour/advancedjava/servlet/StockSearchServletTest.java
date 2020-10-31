package edu.rseymour.advancedjava.servlet;

import org.junit.Test;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;

public class StockSearchServletTest {

    HttpServletRequest request;
    private static final String SYMBOL_PARAMETER_KEY = "symbol";
    private static final String FROM_PARAMETER_KEY = "from";
    private static final String UNTIL_PARAMETER_KEY = "until";

    /**
     * Verifies that the request object is correctly linked to the fields on
     * the form on stockquote.jsp.
     */
    @Test
    public void testDoPostRequestObject() {

        request = mock(HttpServletRequest.class);

        // setup request parameters
        when(request.getParameter(SYMBOL_PARAMETER_KEY)).thenReturn("symbol");
        when(request.getParameter(FROM_PARAMETER_KEY)).thenReturn("from");
        when(request.getParameter(UNTIL_PARAMETER_KEY)).thenReturn("until");
    }

}
