package fr.afjg.coinbot.trend;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OuvertureFichierTest {

	

	public BufferedReader contenuFichiercsvTest(String nameCurrency) {
		BufferedReader buff = null;
	try{
		InputStream flux=new FileInputStream("C:/Users/asus/Desktop/COINBOT/Recherche maths/"+nameCurrency +".csv"); 
		//InputStream flux=new FileInputStream("C:/Users/ghislain/Desktop/COINBOT/test maths/"+nameCurrency +".csv"); 
		InputStreamReader lecture=new InputStreamReader(flux);
		buff=new BufferedReader(lecture);




		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
	
	return buff;
	}

}
