package luceneTest;
/**   
 *@Description:  索引检索demo 
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
            //索引硬盘存储路径  
            directory = FSDirectory.open(new File("D://index/testindex"));  
            //读取索引  
            DirectoryReader dReader = DirectoryReader.open(directory);  
            //创建索引检索对象  
            IndexSearcher searcher = new IndexSearcher(dReader);  
            //指定分词技术，这里采用的语言处理模块要和创建索引的时候一致，否则检索的结果很不理想  
            Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);  
            //创建查询query，搜索词为“空间向量”  
            QueryParser parse = new QueryParser(Version.LUCENE_43, "name", analyzer);  
            Query query = parse.parse("Lucene");  
            //检索索引，获取符合条件的前10条记录  
            TopDocs topDocs = searcher.search(query, 10);  
            if (topDocs != null) {  
                System.out.println("总共查找到 " +  topDocs.totalHits + " 条符合条件的记录");  
                //循环输出记录内容  
                for (int i = 0; i < topDocs.scoreDocs.length; i++) {  
                    Document doc = searcher.doc(topDocs.scoreDocs[i].doc);  
                    System.out.println("第" + (i + 1) + "条内容为--\tname:\t" + doc.get("name") + "\tcontent:\t" + doc.get("content"));  
                }  
            }  
            //关闭资源  
            dReader.close();  
            directory.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  