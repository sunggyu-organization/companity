package com.codecrafters.companity.common.adapter;

import com.codecrafters.companity.application.out.utility.DateTimeProvider;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LocalDateTimeProvider implements DateTimeProvider {
    @Override
    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }
}
