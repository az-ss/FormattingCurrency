package az.currency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Logger;


@Controller
public class IndexController {
    private final static Logger log = Logger.getLogger(IndexController.class.getName());

    @RequestMapping(value = "/param.form",method = RequestMethod.GET)
    public String test(@RequestParam("amount") Double amount,
                       @RequestParam("siteLocale") Locale siteLocale,
                       @RequestParam("currencyLocale") Locale currencyLocale,
                       ModelMap model){
        String result = "";

        if (amount!=null) {
            try {
                amount = amount.doubleValue();
                result = getResult(amount, siteLocale, currencyLocale);
            } catch (NumberFormatException e) {
                log.warning("Passed amount is not a number. Value='"+amount+"'");
                result = "Passed amount is not a number. Value='"+amount+"'";
            }
        }

        model.addAttribute("amount", result);
        model.addAttribute("localeSite", siteLocale);
        model.addAttribute("localeCurrency", currencyLocale);
        model.addAttribute("locales", Locale.getAvailableLocales());


        return "/../index";
    }



    private String getResult(double amount, Locale siteLocale, Locale quoteLocale) {
        DecimalFormat decimalFormat =
                (DecimalFormat) NumberFormat.getCurrencyInstance(siteLocale);
        Currency currency = Currency.getInstance(quoteLocale);
        String symbol = currency.getSymbol(quoteLocale);

        DecimalFormatSymbols smb =
                new DecimalFormatSymbols(quoteLocale);
        smb.setCurrencySymbol(symbol);

        decimalFormat.setDecimalFormatSymbols(smb);
        decimalFormat.getMaximumFractionDigits();
        decimalFormat.getMinimumFractionDigits();
        return decimalFormat.format(amount);
    }
}
