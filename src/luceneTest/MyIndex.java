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
		doc1.add(new TextField("����", "0425���߻�ִ", Store.YES));
		doc1.add(new TextField("����", "����������߼������� ���� 1.��״�����񻯸���һ�׶Σ��ֻ�����   ����ʧ��   ԭ�򣺲��Բ��ɹ����޴���ֻ����ֵ����������ˡ�����������߳ɹ��������������������������ֵ����Աע��۲졣", Store.YES));
		Document doc2 = new Document();
		doc2.add(new TextField("����", "����������������ȶ����·��ӿ���ش���", Store.YES));
		doc2.add(new TextField("����", "�鷳����һ�����", Store.YES));
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
