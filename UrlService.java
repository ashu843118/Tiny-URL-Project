package com.example.tinyUrl;

import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlService {

	@Value("www.tinyurl.com")
	private String domain;

	private Random random = new Random();
	private static char myChars[] = new char[62];
	static {
		{
			for (int i = 0; i < 62; i++) {
				int j = 0;
				if (i < 10) {
					j = i + 48;
				} else if (i > 9 && i <= 35) {
					j = i + 55;
				} else {
					j = i + 61;
				}
				myChars[i] = (char) j;
			}
		}
	}
	HashMap<String, String> valueMap = new HashMap<>();// long url-hash map to quickly check
	HashMap<String, String> keyMap = new HashMap<>(); // hash-long-URL

	public String getShortUrl(String URL) {
		if (valueMap.containsKey(URL))
			return domain + "/" + valueMap.get(URL);
		else
			return domain + "/" + generateShortUrl(URL);
	}

	private String generateShortUrl(String URL) {

		String hash = "";
		do {

			for (int i = 0; i < 6; i++) {
				hash += UrlService.myChars[random.nextInt(62)];

			}
		} while (keyMap.containsKey(hash));
		for (int i = 0; i < myChars.length; i++)
			System.out.print(myChars[i] + " ");
		keyMap.put(hash, URL);
		valueMap.put(URL, hash);
		return hash;
	}

	public String getLongUrl(String URL) {

		URL = URL.substring(domain.length() + 1);

		return keyMap.get(URL);

	}

}
