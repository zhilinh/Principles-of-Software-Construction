package edu.cmu.cs.cs214.hw1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class ClosestMatches {
	private static void ClosestMatches(String[] urls) throws MalformedURLException, IOException {
		List<Document> docList = new ArrayList<>();
		for (String url : urls) {
			docList.add(new Document(url));
		}

		calcClosestDocs(docList);
	}

	private static void calcClosestDocs(List<Document> docList) {
		Document selectedDoc2 = null;
		List<Document> docList2 = new ArrayList<>(docList);
		List<Document> docList2_copy = new ArrayList<>(docList);

		Hashtable<List<Document>, Float> docSi = new Hashtable<>();

		for (Document doc1 : docList) {
			docList2.remove(0);
			for (Document doc2 : docList2) {
				float tmp = doc1.calcSimilarity(doc2);
				docSi.put(Arrays.asList(doc1, doc2), tmp);
				docSi.put(Arrays.asList(doc2, doc1), tmp);
			}
		}

		for (Document doc1 : docList) {
			float max_si = 0;
			for (Document doc2 : docList2_copy) {
				if (doc1 != doc2 && docSi.get(Arrays.asList(doc1, doc2)) > max_si) {
					max_si = docSi.get(Arrays.asList(doc1, doc2));
					selectedDoc2 = doc2;
				}
			}
			System.out.println(doc1);
			System.out.println(selectedDoc2);
			System.out.println();
		}
	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		ClosestMatches(args);
	}

}
