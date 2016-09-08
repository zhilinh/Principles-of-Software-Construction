package edu.cmu.cs.cs214.hw1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to find two URLs that represent two the most similar web pages among URLS.  
 * @author zhilinh
 */
public class ClosestMatch {
	
	/**
	 * Method that uses Document classes to calculate cosine similarity,
	 * to find two URLs with the highest similarity among all URLs.
	 *  
	 * @param docList
	 * 				A Document list includes all URLs to be compared.
	 */
	private static void calcClosestDocs(List<Document> docList) {
		double maxSi = 0;
		Document selectedDoc1 = null;
		Document selectedDoc2 = null;
		List<Document> docList2 = new ArrayList<>(docList);
		for (Document doc1 : docList) {
			docList2.remove(0);
			for (Document doc2 : docList2) {
				double tmp = doc1.calcSimilarity(doc2);
				if (tmp > maxSi) {
					maxSi = tmp;
					selectedDoc1 = doc1;
					selectedDoc2 = doc2;
				}
			}
		}
		System.out.println(selectedDoc1);
		System.out.println(selectedDoc2);
	}

	/**
	 * Main method that takes a list of Documents represented by URLs and starts similarity calculation.
	 * 
	 * @param args
	 * 			command line arguments -- input all URLs.
	 * @throws MalformedURLException
	 * 			for URL exception.
	 * @throws IOException
	 * 			for URL exception.
	 */
	public static void main(String[] args) throws MalformedURLException, IOException {
		List<Document> docList = new ArrayList<>();
		for (String url : args) {
			docList.add(new Document(url));
		}
		calcClosestDocs(docList);
	}

}
