package fr.afjg.coinbot.trend;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OuvertureFichierTest {

	

	public BufferedReader contenuFichiercsvTest() {
		BufferedReader buff = null;
	try{
		InputStream flux=new FileInputStream("C:/Users/asus/Desktop/COINBOT/Recherche maths/test2.csv"); 
		InputStreamReader lecture=new InputStreamReader(flux);
		buff=new BufferedReader(lecture);




		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
	
	return buff;
	}

}