package model.services;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class FormatarStrings {

	public static String formatString(String value, String pattern) {
		MaskFormatter mf;
		try {
			mf = new MaskFormatter(pattern);
			mf.setValueContainsLiteralCharacters(false);
			value.replaceAll("([0-9]) ", "$1");
			return mf.valueToString(value);
		} catch (ParseException ex) {
			return value;
		}
	}

}
