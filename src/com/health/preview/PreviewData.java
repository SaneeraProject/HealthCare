package com.health.preview;

import java.util.LinkedHashMap;

import javax.swing.table.DefaultTableModel;

public class PreviewData {
	public String title;
	public LinkedHashMap<String, String> headerMap;
	public DefaultTableModel model;
	public LinkedHashMap<String, String> footerMap;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LinkedHashMap<String, String> getHeaderMap() {
		return headerMap;
	}

	public void setHeaderMap(LinkedHashMap<String, String> header) {
		this.headerMap = header;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public LinkedHashMap<String, String> getFooterMap() {
		return footerMap;
	}

	public void setFooterMap(LinkedHashMap<String, String> footerMap) {
		this.footerMap = footerMap;
	}

}