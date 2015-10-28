package tmv_converter;

import static org.junit.Assert.*;
import org.junit.Test;

//import tmv_converter.Converter;

public class testConverter {

	@Test
	public void testConverterExamples() {
		
		String result;
		
		result = Converter.converter(0);
		assertEquals(result, "ZERO");
		result = Converter.converter(1100);
		assertEquals(result, "ABOVE 1000");
		result = Converter.converter(1000);
		assertEquals(result, "M");
			
		result = Converter.converter(5);
		assertEquals(result, "V");
		result = Converter.converter(1);
		assertEquals(result, "I");
		result = Converter.converter(3);
		assertEquals(result, "III");
		result = Converter.converter(5);
		assertEquals(result, "V");
		result = Converter.converter(7);
		assertEquals(result, "VII");
		result = Converter.converter(9);
		assertEquals(result, "IX");
		result = Converter.converter(10);
		assertEquals(result, "X");
		result = Converter.converter(12);
		assertEquals(result, "XII");
		result = Converter.converter(17);
		assertEquals(result, "XVII");
		
		result = Converter.converter(20);
		assertEquals(result, "XX");
		result = Converter.converter(74);
		assertEquals(result, "LXXIV");
		result = Converter.converter(87);
		assertEquals(result, "LXXXVII");
		result = Converter.converter(40);
		assertEquals(result, "XXXX");
		result = Converter.converter(49);
		assertEquals(result, "XXXXIX");
		
		result = Converter.converter(315);
		assertEquals(result, "CCCXV");
		result = Converter.converter(500);
		assertEquals(result, "D");
		result = Converter.converter(513);
		assertEquals(result, "DXIII");
		
		result = Converter.converter(600);
		assertEquals(result, "DC");
		result = Converter.converter(750);
		assertEquals(result, "DCCL");
		result = Converter.converter(878);
		assertEquals(result, "DCCCLXXVIII");
		result = Converter.converter(999);
		assertEquals(result, "DCCCCLXXXXIX");
		
	}
}
