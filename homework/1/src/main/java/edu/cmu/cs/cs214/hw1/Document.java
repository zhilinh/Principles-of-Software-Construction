package edu.cmu.cs.cs214.hw1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Scanner;

public class Document {
	private Hashtable<String, Integer> dict;
	private String url;

	public Document(String urlString) throws MalformedURLException, IOException {
		Scanner sc = new Scanner(new URL(urlString).openStream());
		buildDict(sc);
		this.url = urlString;
	}

	public float calcSimilarity(Document doc) {
		float numerator = 0;
		float denomA = 0;
		float denomB = 0;

		for (String key : this.dict.keySet()) {
			if (doc.dict.containsKey(key)) {
				numerator += this.dict.get(key) * doc.dict.get(key);
			}
			denomA += Math.pow(this.dict.get(key), 2);
		}

		for (String key : doc.dict.keySet()) {
			denomB += Math.pow(doc.dict.get(key), 2);
		}

		return numerator / (float) Math.sqrt(denomA * denomB);
	}

	private void buildDict(Scanner sc) {
		dict = new Hashtable<>();
		while (sc.hasNext()) {
			String word = sc.next();
			if (dict.get(word) == null) {
				dict.put(word, 1);
			} else {
				dict.put(word, dict.get(word) + 1);
			}
		}
	}

	@Override
	public String toString() {
		return url;
	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		Document doc1 = new Document(args[0]);
		Document doc2 = new Document(args[1]);
	}

}
