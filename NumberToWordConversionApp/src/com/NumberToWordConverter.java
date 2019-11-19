package com;

import java.text.DecimalFormat;

import com.service.NumToWordService;


public class NumberToWordConverter implements NumToWordService{

	static NumberToWordConverter numConverter=new NumberToWordConverter();
	  private static final String[] tensNames = {
	    "",
	    " ten",
	    " twenty",
	    " thirty",
	    " forty",
	    " fifty",
	    " sixty",
	    " seventy",
	    " eighty",
	    " ninety"
	  };

	  private static final String[] numNames = {
	    "",
	    " one",
	    " two",
	    " three",
	    " four",
	    " five",
	    " six",
	    " seven",
	    " eight",
	    " nine",
	    " ten",
	    " eleven",
	    " twelve",
	    " thirteen",
	    " fourteen",
	    " fifteen",
	    " sixteen",
	    " seventeen",
	    " eighteen",
	    " nineteen"
	  };

	  private NumberToWordConverter() {}

	   static String convertToWord(String inputStr){
		  boolean b=inputStr.matches("-?(0|[1-9]\\d*)");
		  if(b){
			  
			  return convert(Long.parseLong(inputStr));
		  }
		  else{
			  try {
				throw  new CustomizedException("invalid input"); 
			} catch (CustomizedException e) {
					System.out.println(e.getMessage());
			}
		  }
		  return "It is not a Number ";
		  
	  }
	 public String convertLessThanOneThousand(int number) {
	    String soFar;

	    if (number % 100 < 20){
	      soFar = numNames[number % 100];
	      number /= 100;
	    }
	    else {
	      soFar = numNames[number % 10];
	      number /= 10;

	      soFar = tensNames[number % 10] + soFar;
	      number /= 10;
	    }
	    if (number == 0) return soFar;
	    return numNames[number] + " hundred" + soFar;
	  }


	  public static String convert(long number) {
	 
	    if (number == 0) { return "zero"; }

	    String snumber = Long.toString(number);


	    String mask = "000000000000";
	    DecimalFormat df = new DecimalFormat(mask);
	    snumber = df.format(number);

	    int billions = Integer.parseInt(snumber.substring(0,3));

	    int millions  = Integer.parseInt(snumber.substring(3,6));

	    int hundredThousands = Integer.parseInt(snumber.substring(6,9));

	    int thousands = Integer.parseInt(snumber.substring(9,12));

	    String tradBillions;
	    switch (billions) {
	    case 0:
	      tradBillions = "";
	      break;
	    case 1 :
	      tradBillions = numConverter.convertLessThanOneThousand(billions)
	      + " billion ";
	      break;
	    default :
	      tradBillions = numConverter.convertLessThanOneThousand(billions)
	      + " billion ";
	    }
	    String result =  tradBillions;

	    String tradMillions;
	    switch (millions) {
	    case 0:
	      tradMillions = "";
	      break;
	    case 1 :
	      tradMillions = numConverter.convertLessThanOneThousand(millions)
	         + " million ";
	      break;
	    default :
	      tradMillions = numConverter.convertLessThanOneThousand(millions)
	         + " million ";
	    }
	    result =  result + tradMillions;

	    String tradHundredThousands;
	    switch (hundredThousands) {
	    case 0:
	      tradHundredThousands = "";
	      break;
	    case 1 :
	      tradHundredThousands = "one thousand ";
	      break;
	    default :
	      tradHundredThousands = numConverter.convertLessThanOneThousand(hundredThousands)
	         + " thousand ";
	    }
	    result =  result + tradHundredThousands;

	    String tradThousand;
	    tradThousand = numConverter.convertLessThanOneThousand(thousands);
	    result =  result + tradThousand;

	  
	    return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
	  }

}

