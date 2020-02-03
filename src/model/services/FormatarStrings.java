package model.services;

import java.lang.Character.Subset;
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

	public static String formatDate(String value) {

		MaskFormatter mf;

		mf = new MaskFormatter();
		mf.setValueContainsLiteralCharacters(false);
		value.replaceAll("([0-9]) ", "$1");

		String formantando = value.substring(0, 2) + "/" + value.substring(2, 4) + "/"
				+ value.substring(4, 8);

		return formantando;

	}

}
