package ru.denisenkodenis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.denisenkodenis.service.DataService;

@Controller
public class PdfController {
    @Autowired
    private DataService Service;

    @RequestMapping("/pdf")
    public ModelAndView pdfView() {
        Service.setLang("ru");
        return new ModelAndView("PdfView", "Data", Service);
    }

    @RequestMapping("/en/pdf")
    public ModelAndView pdfViewEn() {
        Service.setLang("en");
        return new ModelAndView("PdfView", "Data", Service);
    }

}
