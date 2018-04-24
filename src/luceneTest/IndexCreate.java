package luceneTest;
import java.io.File;  
import org.apache.lucene.analysis.Analyzer;  
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
    
public class IndexCreate {  
  
    public static void main(String[] args) {  
        //ָ�������ִʼ���������ʹ�õ��Ǳ�׼�ִ�  
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);  
        //indexwriter ������Ϣ  
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_43, analyzer);  
        //�����Ĵ򿪷�ʽ��û�������ļ����½����оʹ�  
        indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);  
        Directory directory = null;  
        IndexWriter indexWrite = null;  
        try {  
            //ָ������Ӳ�̴洢·��  
            directory = FSDirectory.open(new File("D://index/testindex"));  
            //���������������״̬�������  
            if (IndexWriter.isLocked(directory)){  
                IndexWriter.unlock(directory);  
            }  
            //ָ�����Բ�������indexWrite  
            indexWrite = new IndexWriter(directory, indexWriterConfig);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
        //�����ĵ�һ  
        Document doc1 = new Document();  
        //��name��ֵ�����Ա��⡱���洢��ֵ��Ϣ  
        doc1.add(new TextField("name", "���Ա���", Store.YES));  
        //��content��ֵ�����Ա��⡱���洢��ֵ��Ϣ  
        doc1.add(new TextField("content", "��������", Store.YES));  
        try {  
            //���ĵ�д�뵽������  
            indexWrite.addDocument(doc1);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
        //�����ĵ���  
        Document doc2 = new Document();  
        doc2.add(new TextField("name", "����lucene�İ���������������ѧģ��", Store.YES));  
        doc2.add(new TextField("content", "lucene��һƪ�ĵ��ֳ����ɸ���ÿ�����ֳַ����ɸ���Ԫ��ͨ����Ԫ���ĵ��е���Ҫ�̶ȣ����ĵ�ת��ΪNά�Ŀռ�������ͨ��������������֮��ļн�����ֵ�����������ĵ������Ƴ̶�", Store.YES));  
        try {  
            //���ĵ�д�뵽������  
            indexWrite.addDocument(doc2);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
        //��indexWrite�����ύ��������ύ��֮ǰ�Ĳ��������ᱣ�浽Ӳ��  
        try {  
            //��һ��������ϵͳ��Դ������commit������Ҫ��һ���Ĳ���  
            indexWrite.commit();  
            //�ر���Դ  
            indexWrite.close();  
            directory.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  
