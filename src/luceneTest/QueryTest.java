 /**   
 *@Description:     Query学习demo 
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
        //Query过程中使用的分词器  
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);  
        //搜索词  
        String key = "基于IPhone的案例开发";  
//      keyValue = "基于lucene的案例开发 更多内容请访问：http://blog.csdn.net/xiaojimanman/article/category/2841877";  
        //将搜索词进行下转义，如果搜索词中没有lucene中的特殊字符，可以不进行转义  
        //String key = LuceneKey.escapeLuceneKey(keyValue);  
        //单个搜索域  
        String field = "content";  
        //多个搜索域  
        String []fields = {"name" , "content"};  
        Query query = null;  
          
        //对单个域构建查询语句  
        QueryParser parse = new QueryParser(Version.LUCENE_43, field, analyzer);  
        query = parse.parse(key);   
        System.out.println(QueryParser.class);  
        System.out.println(query.toString());  
        System.out.println("--------------------------------");  
          
        //对多个域创建查询语句  
        MultiFieldQueryParser parse1 = new MultiFieldQueryParser(Version.LUCENE_43, fields, analyzer);  
        query = parse1.parse(key);  
        System.out.println(MultiFieldQueryParser.class);  
        System.out.println(query.toString());  
        System.out.println("--------------------------------");  
          
        //词条搜索  
        query = new TermQuery(new Term(field, key));  
        System.out.println(query.getClass());  
        System.out.println(query.toString());  
        System.out.println("--------------------------------");  
          
        //前缀搜索  
        query = new PrefixQuery(new Term(field, key));  
        System.out.println(query.getClass());  
        System.out.println(query.toString());  
        System.out.println("--------------------------------");  
          
        //短语搜索  
        PhraseQuery query1 = new PhraseQuery();  
        //设置短语间允许的最大间隔  
        query1.setSlop(2);  
        query1.add(new Term("content", "基于"));  
        query1.add(new Term("content", "案例"));  
        System.out.println(query1.getClass());  
        System.out.println(query1.toString());  
        System.out.println("--------------------------------");  
          
        //通配符搜索  
        query = new WildcardQuery(new Term(field, "基于?"));  
        System.out.println(query.getClass());  
        System.out.println(query.toString());  
        System.out.println("--------------------------------");  
          
        //字符串范围搜索  
        query = TermRangeQuery.newStringRange(field, "abc", "azz", true, false);  
        System.out.println(query.getClass());  
        System.out.println(query.toString());  
          
        //int范围搜索  
        query = NumericRangeQuery.newIntRange("star", 0, 3, false, false);  
        System.out.println(query.getClass() + "\tint");  
        System.out.println(query.toString());  
          
        //float范围搜索  
        query = NumericRangeQuery.newFloatRange("star", 0.0f, 3.0f, false, false);  
        System.out.println(query.getClass() + "\tfloat");  
        System.out.println(query.toString());  
          
        //double范围搜索  
        query = NumericRangeQuery.newDoubleRange("star", 0.0, 3d, false, false);  
        System.out.println(query.getClass() + "\tdouble");  
        System.out.println(query.toString());  
        System.out.println("--------------------------------");  
          
        //BooleanQuery  
        BooleanQuery query2 = new BooleanQuery();  
        query2.add(new TermQuery(new Term("content", "基于")), Occur.SHOULD);  
        query2.add(new TermQuery(new Term("name", "lucene")), Occur.MUST);  
        query2.add(new TermQuery(new Term("star", "3")), Occur.MUST_NOT);  
        System.out.println(query2.getClass());  
        System.out.println(query2.toString());  
        System.out.println("--------------------------------");  
    }  
}  
