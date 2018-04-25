package luceneTest;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class MyIndex {
	public static void main(String[] args) {
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_43, analyzer);
		indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
		Directory directory = null;
		IndexWriter indexWriter = null;
		try {
			directory = FSDirectory.open(new File("D://index/myindex"));
			indexWriter = new IndexWriter(directory, indexWriterConfig);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		Document doc1 = new Document();
		doc1.add(new TextField("标题", "0425上线回执", Store.YES));
		doc1.add(new TextField("正文", "昨晚紧急上线集团需求 其中 1.网状网服务化改造一阶段：手机导航   上线失败   原因：测试部成功，无代码只有数值配置无需回退。其余均已上线成功，错单检查正常详见附件。请白天值班人员注意观察。", Store.YES));
		Document doc2 = new Document();
		doc2.add(new TextField("标题", "智能语音导航满意度短信下发接口相关代码", Store.YES));
		doc2.add(new TextField("正文", "麻烦明天一起更新", Store.YES));
		try {
			indexWriter.addDocument(doc1);
			indexWriter.addDocument(doc2);
			indexWriter.commit();
			indexWriter.close();
			directory.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
