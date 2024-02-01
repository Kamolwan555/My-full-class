package org.acme.hibernate.orm;

import java.sql.Date;

public class DateTimeRequest {
    private Date inputDate;

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getInputDate() {
        return this.inputDate;
    }
}
