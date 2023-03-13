package com.develhope.interceptor02.interceptors;

import com.develhope.interceptor02.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    private List<Month> months = new ArrayList<>();

    public MonthInterceptor() {
        months.add(new Month(1, "January", "Gennaio", "Januar"));
        months.add(new Month(2, "February", "Febbraio", "Februar"));
        months.add(new Month(3, "March", "Marzo", "März"));
        months.add(new Month(4, "April", "Aprile", "April"));
        months.add(new Month(5, "May", "Maggio", "Mai"));
        months.add(new Month(6, "June", "Giugno", "Juni"));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberString = request.getHeader("monthNumber");
        if (monthNumberString == null || monthNumberString.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.out.println("BADREQUEST");
            return false;
        }else {
            Integer monthNumber = Integer.valueOf(monthNumberString);
            Month month = getMonth(monthNumber);
            request.setAttribute("monthNumber", month);
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
    }

    public Month getMonth(Integer monthNumber) {
        Optional<Month> optionalMonth = months.stream()
                .filter(month -> month.getMonthNumber() == monthNumber)
                .findFirst();
        return optionalMonth.orElse(new Month(monthNumber, "nope", "nope", "nope"));
    }

}
