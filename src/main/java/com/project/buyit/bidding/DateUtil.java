package com.project.buyit.bidding;

import java.time.LocalDateTime;

public class DateUtil {

    public static LocalDateTime addDays(int days) {
        return LocalDateTime.now().plusDays(days);
    }
}
