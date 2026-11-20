package com.aquamonitor.platform.u202312348.shared.interfaces.rest;

import java.util.List;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/** Configures the supported request locales and the English default. @author Yazid Said */
@Configuration
public class WebConfiguration {
    @Bean
    public LocaleResolver localeResolver() {
        var resolver = new AcceptHeaderLocaleResolver();
        resolver.setDefaultLocale(Locale.ENGLISH);
        resolver.setSupportedLocales(List.of(
            Locale.ENGLISH, Locale.US, Locale.forLanguageTag("es"), Locale.forLanguageTag("es-PE")));
        return resolver;
    }
}
