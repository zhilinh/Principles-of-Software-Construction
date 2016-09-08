package edu.cmu.cs.cs214.hw1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * Class to find a URL string of the most similar web page for every URL string.
 * 
 * @author zhilinh
 */
public class ClosestMatches {
	
	/**
	 * Method that uses Document classes to calculate cosine similarity among all URLs,
	 * to find the URL with the highest similarity with each of them then prints it out.
	 * 
	 * @param docList
	 * 				A Document list includes all URLs to be compared.
	 */
	private static void calcClosestDocs(List<Document> docList) {
		Document selectedDoc2 = null;
		List<Document> docList2 = new ArrayList<>(docList);
		List<Document> copydocList2 = new ArrayList<>(docList);

		Hashtable<List<Document>, Double> docSi = new Hashtable<>();

		for (Document doc1 : docList) {
			docList2.remove(0);
			for (Document doc2 : docList2) {
				double tmp = doc1.calcSimilarity(doc2);
				docSi.put(Arrays.asList(doc1, doc2), tmp);
				docSi.put(Arrays.asList(doc2, doc1), tmp);
			}
		}

		for (Document doc1 : docList) {
			double maxSi = 0;
			for (Document doc2 : copydocList2) {
				if (doc1 != doc2 && docSi.get(Arrays.asList(doc1, doc2)) > maxSi) {
					maxSi = docSi.get(Arrays.asList(doc1, doc2));
					selectedDoc2 = doc2;
				}
			}
			System.out.print(doc1 + " ");
			System.out.println(selectedDoc2);
		}
	}

	/**
	 * Main method that takes a list of Documents represented by URLs and starts similarity calculation.
	 * 
	 * @param args
	 * 			command line arguments ¡ª¡ª input all URLs.
	 * @throws MalformedURLException
	 * 	 		for URL exception.
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
