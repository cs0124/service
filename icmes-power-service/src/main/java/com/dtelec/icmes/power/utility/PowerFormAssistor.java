package com.dtelec.icmes.power.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PowerFormAssistor {

	public static String generatePowerFormId(String prefix, String suffix) {
		StringBuilder stringBuilder = new StringBuilder();
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String nowDate = sdf.format(d);
		
		stringBuilder.append(prefix);
		stringBuilder.append(nowDate);
		if(suffix.equals("001")) {

			stringBuilder.append("001");
		}
		else {
			String maxId = addZeroAsPrefix(3, Integer.toString((Integer.parseInt(suffix.substring(10)) + 1)));
			stringBuilder.append(maxId);
		}
			
		return stringBuilder.toString();
	}
	
	public static String addZeroAsPrefix(int requireLen, String s) {

        String sReturn = "";
        for (int i = 0; i < requireLen - s.length(); i++) {
            sReturn += 0;
        }
        sReturn += s;

        return sReturn;
    }
}
