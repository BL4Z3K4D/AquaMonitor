package com.aquamonitor.platform.u202312348.shared.interfaces.rest;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/** Resolves localized API messages. @author Yazid Said */
@Component
public class LocalizedMessages {
    private final MessageSource messageSource;

    public LocalizedMessages(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String get(String key, Locale locale) {
        return messageSource.getMessage(key, null, key, locale);
    }
}
