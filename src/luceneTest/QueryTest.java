 /**   
 *@Description:     Queryѧϰdemo 
 */   
package luceneTest;    
  
import org.apache.lucene.analysis.Analyzer;  
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
import org.apache.lucene.index.Term;  
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;  
import org.apache.lucene.queryparser.classic.QueryParser;  
import org.apache.lucene.search.BooleanClause.Occur;  
import org.apache.lucene.search.BooleanQuery;  
import org.apache.lucene.search.NumericRangeQuery;  
import org.apache.lucene.search.PhraseQuery;  
import org.apache.lucene.search.PrefixQuery;  
import org.apache.lucene.search.Query;  
import org.apache.lucene.search.TermQuery;  
import org.apache.lucene.search.TermRangeQuery;  
import org.apache.lucene.search.WildcardQuery;  
import org.apache.lucene.util.Version;  
    
public class QueryTest {  
  
    public static void main(String[] args) throws Exception {  
        //Query������ʹ�õķִ���  
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);  
        //������  
        String key = "����IPhone�İ�������";  
//      keyValue = "����lucene�İ������� ������������ʣ�http://blog.csdn.net/xiaojimanman/article/category/2841877";  
        //�������ʽ�����ת�壬�����������û��lucene�е������ַ������Բ�����ת��  
        //String key = LuceneKey.escapeLuceneKey(keyValue);  
        //����������  
        String field = "content";  
        //���������  
        String []fields = {"name" , "content"};  
        Query query = null;  
          
        //�Ե����򹹽���ѯ���  
        QueryParser parse = new QueryParser(Version.LUCENE_43, field, analyzer);  
        query = parse.parse(key);   
        System.out.println(QueryParser.class);  
        System.out.println(query.toString());  
        System.out.println("--------------------------------");  
          
        //�Զ���򴴽���ѯ���  
        MultiFieldQueryParser parse1 = new MultiFieldQueryParser(Version.LUCENE_43, fields, analyzer);  
        query = parse1.parse(key);  
        System.out.println(MultiFieldQueryParser.class);  
        System.out.println(query.toString());  
        System.out.println("--------------------------------");  
          
        //��������  
        query = new TermQuery(new Term(field, key));  
        System.out.println(query.getClass());  
        System.out.println(query.toString());  
        System.out.println("--------------------------------");  
          
        //ǰ׺����  
        query = new PrefixQuery(new Term(field, key));  
        System.out.println(query.getClass());  
        System.out.println(query.toString());  
        System.out.println("--------------------------------");  
          
        //��������  
        PhraseQuery query1 = new PhraseQuery();  
        //���ö��������������  
        query1.setSlop(2);  
        query1.add(new Term("content", "����"));  
        query1.add(new Term("content", "����"));  
        System.out.println(query1.getClass());  
        System.out.println(query1.toString());  
        System.out.println("--------------------------------");  
          
        //ͨ�������  
        query = new WildcardQuery(new Term(field, "����?"));  
        System.out.println(query.getClass());  
        System.out.println(query.toString());  
        System.out.println("--------------------------------");  
          
        //�ַ�����Χ����  
        query = TermRangeQuery.newStringRange(field, "abc", "azz", true, false);  
        System.out.println(query.getClass());  
        System.out.println(query.toString());  
          
        //int��Χ����  
        query = NumericRangeQuery.newIntRange("star", 0, 3, false, false);  
        System.out.println(query.getClass() + "\tint");  
        System.out.println(query.toString());  
          
        //float��Χ����  
        query = NumericRangeQuery.newFloatRange("star", 0.0f, 3.0f, false, false);  
        System.out.println(query.getClass() + "\tfloat");  
        System.out.println(query.toString());  
          
        //double��Χ����  
        query = NumericRangeQuery.newDoubleRange("star", 0.0, 3d, false, false);  
        System.out.println(query.getClass() + "\tdouble");  
        System.out.println(query.toString());  
        System.out.println("--------------------------------");  
          
        //BooleanQuery  
        BooleanQuery query2 = new BooleanQuery();  
        query2.add(new TermQuery(new Term("content", "����")), Occur.SHOULD);  
        query2.add(new TermQuery(new Term("name", "lucene")), Occur.MUST);  
        query2.add(new TermQuery(new Term("star", "3")), Occur.MUST_NOT);  
        System.out.println(query2.getClass());  
        System.out.println(query2.toString());  
        System.out.println("--------------------------------");  
    }  
}  
