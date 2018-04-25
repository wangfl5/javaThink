package luceneTest;
/**   
 *@Description:  ��������demo 
 */      

import java.io.File;  
import org.apache.lucene.analysis.Analyzer;  
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
import org.apache.lucene.document.Document;  
import org.apache.lucene.index.DirectoryReader;  
import org.apache.lucene.queryparser.classic.QueryParser;  
import org.apache.lucene.search.IndexSearcher;  
import org.apache.lucene.search.Query;  
import org.apache.lucene.search.TopDocs;  
import org.apache.lucene.store.Directory;  
import org.apache.lucene.store.FSDirectory;  
import org.apache.lucene.util.Version;  
    
public class SearchIndex {  
  
    public static void main(String[] args) {  
        Directory directory = null;  
        try {  
            //����Ӳ�̴洢·��  
            directory = FSDirectory.open(new File("D://index/testindex"));  
            //��ȡ����  
            DirectoryReader dReader = DirectoryReader.open(directory);  
            //����������������  
            IndexSearcher searcher = new IndexSearcher(dReader);  
            //ָ���ִʼ�����������õ����Դ���ģ��Ҫ�ʹ���������ʱ��һ�£���������Ľ���ܲ�����  
            Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);  
            //������ѯquery��������Ϊ���ռ�������  
            QueryParser parse = new QueryParser(Version.LUCENE_43, "name", analyzer);  
            Query query = parse.parse("Lucene");  
            //������������ȡ����������ǰ10����¼  
            TopDocs topDocs = searcher.search(query, 10);  
            if (topDocs != null) {  
                System.out.println("�ܹ����ҵ� " +  topDocs.totalHits + " �����������ļ�¼");  
                //ѭ�������¼����  
                for (int i = 0; i < topDocs.scoreDocs.length; i++) {  
                    Document doc = searcher.doc(topDocs.scoreDocs[i].doc);  
                    System.out.println("��" + (i + 1) + "������Ϊ--\tname:\t" + doc.get("name") + "\tcontent:\t" + doc.get("content"));  
                }  
            }  
            //�ر���Դ  
            dReader.close();  
            directory.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  