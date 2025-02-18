package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class DateTimeTest {

	@Test
	void test() throws Exception {
		Date now =new Date();
		System.out.println(now);
		Date independenceDay = new Date(47,7,15);
		System.out.println(independenceDay);
		/*
		yyyy -> year(2025)
		yy -> 25
		
		MM-> numeric Month(7) 
		MMM -> alpha(aug)
		
		dd-> day
		Hour -> hh
		minute -> mm
		Second -> ss
		*/
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
		//System.out.println(df);
		Date republicDay= df.parse("26-01-1950");
		System.out.println(republicDay);
	}

}
