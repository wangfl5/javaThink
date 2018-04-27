package luceneTest;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Field;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;

public class MyQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);
		String queryKey = "基于IPhone的案例开发";
		String field = "contect";
		String[] fields ={"name","contect"};
		Query query = null;
		QueryParser qp = new QueryParser(Version.LUCENE_43, field, analyzer);
		try {
			query = qp.parse(queryKey);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(query.getClass());
		System.out.println(query.toString());
	}

}
