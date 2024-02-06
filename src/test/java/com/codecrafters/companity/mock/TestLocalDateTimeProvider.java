package com.codecrafters.companity.mock;

import com.codecrafters.companity.application.out.datetime.LocalDateTimeProvider;
import java.time.LocalDateTime;

public class TestLocalDateTimeProvider implements LocalDateTimeProvider {
    private final LocalDateTime fixedDateTime;
    public TestLocalDateTimeProvider(LocalDateTime localDateTime){
        this.fixedDateTime = localDateTime;
    }
    @Override
    public LocalDateTime getNow() {
        return this.fixedDateTime;
    }
}
