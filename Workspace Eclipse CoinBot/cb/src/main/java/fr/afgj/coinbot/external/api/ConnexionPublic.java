package fr.afgj.coinbot.external.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

public class ConnexionPublic {

	private HttpsURLConnection con;

	public ConnexionPublic(String httpsUrl) throws IOException {
		super();
		URL url = new URL(httpsUrl);
		this.setCon((HttpsURLConnection) url.openConnection());
	}

	@SuppressWarnings("unused")
	private StringBuffer print_https_cert() {

		if (this.getCon() != null) {
			StringBuffer sb = new StringBuffer();
			try {

				this.getCon().connect();
				sb.append("Response Code : ");
				sb.append(this.getCon().getCipherSuite());
				sb.append("\n");
				sb.append("Cipher Suite : ");
				sb.append(this.getCon().getCipherSuite());
				sb.append("\n");

				Certificate[] certs = this.getCon().getServerCertificates();
				for (Certificate cert : certs) {
					sb.append("Cert Type : ");
					sb.append(cert.getType());
					sb.append("\n");
					sb.append("Cert Hash Code : ");
					sb.append(cert.hashCode());
					sb.append("\n");
					sb.append("Cert Public Key Algorithm : ");
					sb.append(cert.getPublicKey().getAlgorithm());
					sb.append("\n");
					sb.append("Cert Public Key Format : ");
					sb.append(cert.getPublicKey().getFormat());
					sb.append("\n");
				}

			} catch (SSLPeerUnverifiedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return sb;
		}
		return null;

	}

	// Permet de récupérer le Json des apis
	public StringBuffer print_content() {
		if (this.getCon() != null) {
			StringBuffer sb = new StringBuffer();
			try {
				// On met les données dans un BufferReader
				BufferedReader br = new BufferedReader(new InputStreamReader(this.getCon().getInputStream()));
				
				while (br.ready()) {
					// On incremente la chaine de caractere, afin de renvoyer le json a la couche superieur
					sb.append(br.readLine());
				}
				br.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			return sb;
		}
		return null;

	}

	public HttpsURLConnection getCon() {
		return con;
	}

	public void setCon(HttpsURLConnection con) {
		this.con = con;
	}

}
