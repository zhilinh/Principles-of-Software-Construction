package edu.cmu.cs.cs214.hw1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class ClosestMatch {
	private static void ClosestMatch(String[] urls) throws MalformedURLException, IOException {
		List<Document> docList = new ArrayList<>();
		for (String url : urls) {
			docList.add(new Document(url));
		}
		calcClosestDocs(docList);
	}

	private static void calcClosestDocs(List<Document> docList) {
		float max_si = 0;
		Document selectedDoc1 = null;
		Document selectedDoc2 = null;
		List<Document> docList2 = new ArrayList<>(docList);
		for (Document doc1 : docList) {
			docList2.remove(0);
			for (Document doc2 : docList2) {
				float tmp = doc1.calcSimilarity(doc2);
				if (tmp > max_si) {
					max_si = tmp;
					selectedDoc1 = doc1;
					selectedDoc2 = doc2;
				}
			}
		}
		System.out.println(selectedDoc1);
		System.out.println(selectedDoc2);
	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		ClosestMatch(args);
	}

}
