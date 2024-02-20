package com.codecrafters.companity.adapter.utility;

import com.codecrafters.companity.application.out.utility.DateTimeProvider;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DateTimeProviderImpl implements DateTimeProvider {
    @Override
    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }
}
