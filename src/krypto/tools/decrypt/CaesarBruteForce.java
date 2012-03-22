/** ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 *  +      Zuercher Hochschule angewandter Wissenschaften      +
 *  +                    Software Projekt 2                    +
 *  +                                                          +
 *  +        Gruppe 10: Miro Ljubicic & Mathias Weigert        +
 *  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */
package krypto.tools.decrypt;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mathias Weigert & Miro Ljubicic
 * @version 1.0
 */
public class CaesarBruteForce {

	private String cipher;
	private String plain;
	private Map<Character, String> report;
	private Long time;

	/*
	 * Method which try all 26 keys on the cipher text. The solution for each
	 * key will be stored in a map (report).
	 */
	public CaesarBruteForce(String cipher) {
		time = -System.currentTimeMillis();
		report = new HashMap<Character, String>();
		this.cipher = cipher;
		plain = new String();
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i <= 25; i++) {
			for (int x = 0; x < cipher.length(); x++) {
				if (cipher.charAt(x) != ' ') {
					int pos = abc.indexOf(cipher.charAt(x)) + i;
					if (pos > 25) {
						pos = pos - 26;
					}
					Character c = abc.charAt(pos);
					plain = plain + c;
				} else {
					plain = plain + ' ';
				}
			}
			plain = plain.toLowerCase();
			report.put(abc.charAt(i), plain);
			plain = "";
		}
		time = time + System.currentTimeMillis();
	}
	
	public String getCipher() {
		return cipher;
	}
	
	public Map<Character, String> getReport() {
		return report;
	}
	
	public Long getTime() {
		return time;
	}
}
