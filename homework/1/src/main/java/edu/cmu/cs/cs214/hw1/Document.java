package edu.cmu.cs.cs214.hw1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Class to calculate cosine similarity of two web pages.
 * 
 *@author zhilinh *
 */
public class Document {
	private Hashtable<String, Integer> dict;
	private String url;
	
	/**
	 * Public constructor that takes a URL string and a Hashtable referring to words frequency. 
	 * 
	 * @param urlString
	 * 					a URL string to process a web page.
	 * @throws MalformedURLException
	 * 					for URL exception.
	 * @throws IOException
	 * 					for URL exception.
	 */
	public Document(String urlString) throws MalformedURLException, IOException {
		Scanner sc = new Scanner(new URL(urlString).openStream());
		buildDict(sc);
		this.url = urlString;
	}
	
	/**
	 * Method that uses two words frequency tables to calculate their cosine similarity.
	 * 
	 * @param doc
	 * 			A second Document to compare.
	 * @return
	 * 			return the cosine similarity of two web pages.
	 */
	public double calcSimilarity(Document doc) {
		double numerator = 0;
		double denomA = 0;
		double denomB = 0;

		for (String key : this.dict.keySet()) {
			if (doc.dict.containsKey(key)) {
				numerator += this.dict.get(key) * doc.dict.get(key);
			}
			denomA += Math.pow(this.dict.get(key), 2);
		}

		for (String key : doc.dict.keySet()) {
			denomB += Math.pow(doc.dict.get(key), 2);
		}

		return numerator / (double) Math.sqrt(denomA * denomB);
	}
	
	/**
	 * Method that uses a Scanner and a Hashtable to process and save words in web pages and their frequency.
	 * 
	 * @param sc
	 * 			A scanner to collect all words in web pages.
	 */
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

	/**
	 * toString method that returns a URL string which identifies its Document.
	 */
	@Override
	public String toString() {
		return url;
	}
	
	/**
	 * Method that is called when this program runs (the 'main' method).
	 * 
	 * @param args
	 * 				command line arguments ¡ª¡ª input two URLs.
	 * @throws MalformedURLException
	 * 				for URL exception.
	 * @throws IOException
	 * 				for URL exception.
	 */
	public static void main(String[] args) throws MalformedURLException, IOException {
		Document doc1 = new Document(args[0]);
		Document doc2 = new Document(args[1]);
	}

}
