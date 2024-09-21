package com.Springmvc.lc.Propertyeditor;

import java.beans.PropertyEditorSupport;

public class NameEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		// to convert string to upper case
		String convertedStr = text.toUpperCase();

		// to send the updated string to our dto
		setValue(convertedStr);

	}

}
