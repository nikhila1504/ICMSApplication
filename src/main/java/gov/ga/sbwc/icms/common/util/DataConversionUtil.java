package gov.ga.sbwc.icms.common.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class DataConversionUtil {

	private static final String DATE_FORMAT = "MM/dd/yyyy";
	private static final String HYPHEN = "-";
	private static final String CROSS = "x";
	private static final String EMPTY_STRING = "";
	

	public static String formatSSN(String ssn) {
		if (StringUtils.isNotBlank(ssn)&& ssn.length()==9) {
			return ssn.substring(0, 3) + HYPHEN + ssn.substring(3, 5) + HYPHEN + ssn.substring(5, 9);
		}else if(StringUtils.isNotBlank(ssn)&& ssn.length()!=9){
			return ssn;
		}

		return EMPTY_STRING;
	}

	public static String parseSSN(String ssn) {
		if (StringUtils.isNotBlank(ssn)) {
			 ssn= ssn.replaceAll("[^\\da-zA-z.]", "");
			 ssn=ssn.replace("b", "B");
			 ssn=ssn.replace("t", "T");
			 ssn=ssn.replace("n", "N");
			 
			 return ssn;
		}
		
		return EMPTY_STRING;
	}
	
	public static String parseName(String ssn) {
		if (StringUtils.isNotBlank(ssn)) {
			 return ssn.replace(" ", "");
		}
		
		return EMPTY_STRING;
	}
	
	public static String parseClaimNo(String claimNo) {
		if (StringUtils.isNotBlank(claimNo)) {
			return claimNo = claimNo.replaceAll("[^\\d.]", "");
		}
		return EMPTY_STRING;
	}

	public static Date parseDate(String formattedDate) {
		Date date = null;
		try {
			date = DateUtils.parseDate(formattedDate, new String[] { DATE_FORMAT });
		} catch (ParseException e) {

		}

		return date;
	}

	public static String formatDate(Date date) {
		if (date != null) {
			return DateFormatUtils.format(date, DATE_FORMAT);
		}

		return EMPTY_STRING;
	}

	public static String formatEIN(String ein) {
		if (StringUtils.isNotBlank(ein)) {
			return ein.substring(0, 2) + HYPHEN + ein.substring(2, 9);
		}

		return EMPTY_STRING;
	}

	public static String parseEIN(String ein) {
		if (StringUtils.isNotBlank(ein)) {
			return ein.replace(HYPHEN, "");
		}

		return EMPTY_STRING;
	}

	// Added by Victor
	public static String formatPhone(String phoneWithExt) {

		String phone = null;
		String phoneExt = null;
		
		if (StringUtils.isNotBlank(phoneWithExt)) {
			if (phoneWithExt.length() > 10) {
				//Defect# 2023 - Begin
				phoneExt = phoneWithExt.substring(10, phoneWithExt.length()).replace("-", "");
				//Defect# 2023 - End
			}
			//Defect# 2023 - Begin
			phone = phoneWithExt.length()>=10?phoneWithExt.substring(0, 10):phoneWithExt;
			//Defect# 2023 - End
		}
		return formatPhone(phone, phoneExt);

	}

	public static String formatPhone(String phone, String phoneExt) {
		if (StringUtils.isNotBlank(phone)) {
			StringBuilder phoneWithExtension = new StringBuilder();
			if(phone.length()==10) {
				phoneWithExtension.append("(" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + HYPHEN + phone.substring(6, 10));
				if (StringUtils.isNotBlank(phoneExt)) {
					phoneWithExtension.append(CROSS + phoneExt);
				}
			}
			return phoneWithExtension.toString();
		}

		return EMPTY_STRING;
	}

	public static String parsePhone(String phone) {
		if (StringUtils.isNotBlank(phone)) {
			phone = phone.replaceAll("[\\s\\-()]", "");
			if (phone.length() >= 10) {
				return phone.substring(0, 10);
			}
		}

		return EMPTY_STRING;
	}

	public static String parsePhoneExt(String phone) {
		if (StringUtils.isNotBlank(phone)) {
			phone = phone.replaceAll("[\\s\\-()x]", "");
			if (phone.length() >= 10) {
				return phone.substring(10, phone.length());
			}
		}

		return EMPTY_STRING;
	}

	// Added by Victor
	public static String formatZip(String zipWithExt) {
		String zipExt = null;
		String zip = null;
		if (StringUtils.isNotBlank(zipWithExt)) {
			if (zipWithExt.length() > 5 && zipWithExt.length()>=9)
				zipExt = zipWithExt.substring(5, 9);

			zip = zipWithExt.substring(0, 5);
		}
		return formatZip(zip, zipExt);
	}

	public static String formatZip(String zip, String zipExt) {
		StringBuilder zipWithExtension = new StringBuilder();
		if (StringUtils.isNotBlank(zip) && zip.length() >= 5) {
			zipWithExtension.append(zip.substring(0, 5));
			if (StringUtils.isNotBlank(zipExt)) {
				zipWithExtension.append(HYPHEN + zipExt);
			}

			return zipWithExtension.toString();
		}

		return EMPTY_STRING;
	}

	public static String parseZip(String zip) {
		if (StringUtils.isNotBlank(zip)) {
			return zip.substring(0, 5);
		}

		return EMPTY_STRING;

	}

	public static String parseZipExt(String zip) {
		if (StringUtils.isNotBlank(zip) && zip.length() == 10) {
			return zip.substring(6, 10);
		}

		return EMPTY_STRING;
	}
	
	public static String parseDataWithExt(String Data, String DataExt){
		StringBuilder phone = new StringBuilder();
		if(StringUtils.isNotEmpty(Data)){
			phone.append(Data);
		}
		if(StringUtils.isNotEmpty(DataExt)){
			phone.append( "-"+DataExt);
		}
		return phone.toString();
	}
	
	public static String formatSSNOrBTN(String ssnOrBtn) {
		String formattedStr = "";
		if (ssnOrBtn != null && !ssnOrBtn.equals("")) {
			if (ssnOrBtn.startsWith("BTN")) {
				formattedStr = ssnOrBtn;
			} else {
				formattedStr = "xxx-xx-" + ssnOrBtn.substring(ssnOrBtn.length()-4, ssnOrBtn.length());
			}
		}
		
		return formattedStr;
	}
	
	public static String formatClaimNo(String claimNo) {
		String formattedStr = "";
		if (StringUtils.isNotBlank(claimNo)) {
			if (claimNo.length() == 10) {
				formattedStr = claimNo.substring(0, 4) + "-" + claimNo.substring(4, 10);
			} else {
				formattedStr = claimNo.substring(0, 4) + "-" + claimNo.substring(4, claimNo.length());
			}
		}
		
		return formattedStr;
	}
	
	public static String formatCurrency(double value) {
		DecimalFormat formatter = new DecimalFormat("$###,###,##0.00");
		return formatter.format(value);
	}
}
