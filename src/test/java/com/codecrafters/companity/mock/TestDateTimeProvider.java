package com.codecrafters.companity.mock;

import com.codecrafters.companity.application.out.utility.DateTimeProvider;
import java.time.LocalDateTime;

public class TestDateTimeProvider implements DateTimeProvider {
    private final LocalDateTime fixedDateTime;
    public TestDateTimeProvider(LocalDateTime localDateTime){
        this.fixedDateTime = localDateTime;
    }
    @Override
    public LocalDateTime getNow() {
        return this.fixedDateTime;
    }
}
