package luceneTest;
import java.io.StringReader;   
import org.apache.lucene.analysis.Analyzer;  
import org.apache.lucene.analysis.TokenStream;  
import org.apache.lucene.analysis.cjk.CJKAnalyzer;  
import org.apache.lucene.analysis.core.KeywordAnalyzer;  
import org.apache.lucene.analysis.core.SimpleAnalyzer;  
import org.apache.lucene.analysis.core.StopAnalyzer;  
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;  
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
import org.apache.lucene.util.Version;  
import org.wltea.analyzer.lucene.IKAnalyzer;  
public class AnalyzerTest {  

    public static void main(String[] args) throws Exception {  
        //��Ҫ����Ĳ����ַ���  
        String str = "����һ���ִ������Գ���ϣ����Ҽ�����ע�ҵĸ���ϵ�в��ͣ�����Lucene�İ��������������һ����ո�ı�ǩ LUCENE java �ִ���";  
        Analyzer analyzer = null;  
        //��׼�ִ�������������������ģ���ChineseAnalyzer��һ����Ч������Ҳ�����֮��İ汾����ChineseAnalyzer��һ��ԭ��  
        //analyzer = new StandardAnalyzer(Version.LUCENE_43);  
        //���������ķִ�����������2�й��췽����  
        //analyzer = new IKAnalyzer();  
        //analyzer = new IKAnalyzer(false);  
        analyzer = new IKAnalyzer(true);  
        //�ո�ִ��������ַ���������δ���  
        //analyzer = new WhitespaceAnalyzer(Version.LUCENE_43);  
        //�򵥷ִ�����һ��һ�λ����зִ�  
        //analyzer = new SimpleAnalyzer(Version.LUCENE_43);  
        //���ַ��ִ���������ִʷ�ʽ��������һ�ִ�(���ַ��ִ�)��ͬһ���ֻ��������ߺ��ұ���ϳ�һ���Σ�ÿ���˳������Σ��������ֺ�ĩ��  
        //analyzer = new CJKAnalyzer(Version.LUCENE_43);  
        //�ؼ��ִַ������Ѵ�����ַ�������һ������  
        //analyzer = new KeywordAnalyzer();  
        //�����ԵĴʷִ���  
        //analyzer = new StopAnalyzer(Version.LUCENE_43);  
        //ʹ�÷ִ�����������ַ���  
        StringReader reader = new StringReader(str);  
        TokenStream  tokenStream  = analyzer.tokenStream("", reader);  
        tokenStream.reset();  
        CharTermAttribute  term = tokenStream.getAttribute(CharTermAttribute.class);  
        int l = 0;  
        //����ִ����ʹ�����  
        System.out.println(analyzer.getClass());  
        while(tokenStream.incrementToken()){    
            System.out.print(term.toString() + "|");  
            l += term.toString().length();  
            //���һ���������������30���ͻ������  
            if (l > 30) {  
                System.out.println();  
                l = 0;  
            }  
        }   
    }  
}  
