package com.silvershield.ssc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {

    private final TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    String build(String message, String url) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("url", url);
        return templateEngine.process("mailTemplate", context);  // from mailTemplate.html
    }

}
