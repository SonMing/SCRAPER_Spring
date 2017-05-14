package org.zerock.domain;

import java.util.Date;

public class ScrapVO {

	
	
	public Integer getScrap_num() {
		return scrap_num;
	}
	public String getScrap_type() {
		return scrap_type;
	}
	public String getScrap_rink() {
		return scrap_rink;
	}
	public Date getScrap_date() {
		return scrap_date;
	}
	
	
	public void setScrap_num(Integer scrap_num) {
		this.scrap_num = scrap_num;
	}
	public void setScrap_type(String scrap_type) {
		this.scrap_type = scrap_type;
	}
	public void setScrap_rink(String scrap_rink) {
		this.scrap_rink = scrap_rink;
	}
	public void setScrap_date(Date scrap_date) {
		this.scrap_date = scrap_date;
	}

	
	@Override
	public String toString() {
		return "ScrapVO [scrap_num=" + scrap_num + ", scrap_type=" + scrap_type + ", scrap_rink=" + scrap_rink
				+ ", scrap_date=" + scrap_date + "]";
	}

	
	private Integer scrap_num;
	private String scrap_type;
	private String scrap_rink;
	private Date scrap_date;
	
}
