package junit.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.NumberToWordConverter;

public class NumberToWordJunitTest {

	@Test
	public void testConvert() throws Exception{
		long num=10l; 
		String convertedWord=NumberToWordConverter.convert(num);
		assertEquals("ten",convertedWord);
	}

}
