package com.codecrafters.companity.common.application;

import java.time.LocalDateTime;

public interface DateTimeProvider {
    LocalDateTime getNow();
}
