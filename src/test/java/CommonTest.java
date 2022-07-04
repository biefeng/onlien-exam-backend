import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonTest {
    public static final Pattern questionPattern = Pattern.compile("^\\d+\\.\\s*(?<question>.*)$");
    public static final Pattern explainPattern = Pattern.compile("^答案解析\\s*(:|：)\\s*(?<explain>.*)[\\t\\s\\r\\n]*$");
    public static final Pattern selectAnswerPattern = Pattern.compile("^参考答案\\s*(:|：)\\s*(?<answer>.*)[\\t\\s\\r\\n]*$");
    @Test
    public void name() {
        Matcher matcher = questionPattern.matcher("1.税务稽查人员应当依法为纳税人、扣缴义务人和其他涉税当事人的商业秘密、个人隐私、个人信息保密，下列不属于保密内容的是（）：");
        if (matcher.find()){
            System.out.println(matcher.group("question"));
        }
    }

    @Test
    public void name1() {
        Matcher matcher = explainPattern.matcher("答案解析:《税务稽查案件办理程序规定》第三十条第二款规定，除《税务稽查案件办理程序规定》第三十条第一款规定情形外采取查封、扣押、冻结措施的，期限不得超过30日；情况复杂的，经县以上税务局局长批准，可以延长，但是延长期限不得超过30日。");
        if (matcher.find()){
            System.out.println(matcher.group("explain"));
        }
    }

    @Test
    public void name3() {
        Matcher matcher = selectAnswerPattern.matcher("参考答案：C ");
        if (matcher.find()){
            System.out.println(matcher.group("answer"));
        }
    }
}
