package com.codecrafters.companity.adapter.util;

import com.codecrafters.companity.application.out.utility.LocalDateTimeProvider;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LocalDateTimeProviderImpl implements LocalDateTimeProvider {
    @Override
    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }
}
