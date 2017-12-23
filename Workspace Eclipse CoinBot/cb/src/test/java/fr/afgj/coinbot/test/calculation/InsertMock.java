package fr.afgj.coinbot.test.calculation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class InsertMock {

	public static void main(String[] args) {

		Date timerecord = new Date(1511458791000L);
		
		System.out.println(timerecord);
		Date timerecord2 = new Date(1511458791000L + 3600000);
		
		System.out.println(timerecord2);

	}

}
