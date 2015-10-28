package tmv_converter;

/**
 * @author teleginmv
 * method converts from arabic digits to roman digits
 * usage:
 * converter(int arabicDigit) where 0 < arabicDigit <= 1000 returns String "romanDigit"
 * converter(0) returns String "ZERO"
 * converter(int aboveThousand) where aboveThousand > 1000 returns String "ABOVE 1000"
 */

public class Converter {

	public static String converter(int number) {
		
		//returning result: romanDigit
		String result = "";
		int temp;
		
		if(number == 0) return "ZERO";
		if(number > 1000) return "ABOVE 1000";
		if(number == 1000) return "M";
		
		//convert from 500 
		if(number >= 500)  {
			result = result + "D"; 
			number -= 500;
		}
		
		//convert from 100 till 500
		//temp = fractional part (1-99)
		temp = number % 100;
		number = (number - temp) / 100;
		while(number != 0) {
			result = result + "C";
			number--;
		}
		//temp = fractional part (1-99)
		number = temp;
		
		//convert from 50
		if(number >= 50) {
			result = result + "L";
			number -= 50;
		}
		
		//convert from 10 till 49	
		//temp = fractional part (0-9)
		temp = number % 10;
		number = (number - temp) / 10;
		while(number != 0) {
			result = result + "X";
			number--;
		}
		
		//convert from 1 till 9
		switch(temp) {
			
		case 0: return result;
		case 1: return result + "I";
		case 2: return result + "II";
		case 3: return result + "III";
		case 4: return result + "IV";
		case 5: return result + "V";
		case 6: return result + "VI";
		case 7: return result + "VII";
		case 8: return result + "VIII";
		case 9: return result + "IX";
		}
		return result;
	}

}
