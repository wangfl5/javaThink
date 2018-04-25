package luceneTest;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class MySearch {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		Directory directory = FSDirectory.open(new File("D://index/myindex")); 
		DirectoryReader dReader = DirectoryReader.open(directory);
		IndexSearcher iSearcher = new IndexSearcher(dReader);
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43); 
		QueryParser parse = new QueryParser(Version.LUCENE_43, "标题", analyzer);
		Query query = parse.parse("下发");
		TopDocs topDocs = iSearcher.search(query, 5);
		if(topDocs!=null){
			System.out.println("共查询出"+topDocs.totalHits+"条结果");
			for(int i=0;i<topDocs.scoreDocs.length;i++){
				Document document = iSearcher.doc(topDocs.scoreDocs[i].doc);
				System.out.println("第"+(i+1)+"条数据   标题："+document.get("标题")+"\n 正文："+document.get("正文"));
			}
		}
		dReader.close();
		directory.close();
	}

}
