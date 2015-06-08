package com.nbi.chlidportal.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateParam {
  private final Date date;

  public DateParam(String dateStr) throws Exception {
    if (isEmpty(dateStr)) {
      this.date = null;
      return;
    }
    final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
      this.date = dateFormat.parse(dateStr);
    } catch (ParseException e) {
      e.printStackTrace();
      throw new Exception();
    }
  }

  private boolean isEmpty(String dateStr) {
	if(dateStr==null || "".equals(dateStr)){
		return true;
	}
	return false;
}

public Date getDate() {
    return date;
  }
}