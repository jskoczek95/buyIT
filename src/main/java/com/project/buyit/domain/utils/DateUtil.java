package com.project.buyit.domain.utils;

import java.time.LocalDateTime;

public final class DateUtil {

    private DateUtil() {
    }

    public static LocalDateTime addDays(int days) {
        return LocalDateTime.now().plusDays(days);
    }


}
