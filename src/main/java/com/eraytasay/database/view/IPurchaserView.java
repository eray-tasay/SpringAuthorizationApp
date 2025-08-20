package com.eraytasay.database.view;

import java.time.LocalDate;

public interface IPurchaserView {
    Integer getId();
    String getUsername();
    String getEmail();
    LocalDate getBirthDate();
}
