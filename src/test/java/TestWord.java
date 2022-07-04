import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.xmlbeans.XmlException;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestWord {
    public static final  String question = "7.解除税收强制措施时，应当向纳税人、扣缴义务人、纳税担保人送达解除税收强制措施决定书，采取查封商品、货物或者其他财产措施的，应当解除查封并收回的文书是（）：\n" +
            "A.查封商品、货物或者其他财产专用收据\n" +
            "B.查封商品、货物或者其他财产清单\n" +
            "C.查封商品、货物或者其他财产通知书\n" +
            "D.查封商品、货物或者其他财产事项告知书\n" +
            "参考答案:B\n" +
            "答案解析:《税务稽查案件办理程序规定》第三十二条第一款第（二）项规定，解除税收强制措施时，应当向纳税人、扣缴义务人、纳税担保人送达解除税收强制措施决定书，告知其解除税收强制措施的时间、内容和依据，并通知其在规定时间内办理解除税收强制措施的有关事宜：（二）采取查封商品、货物或者其他财产措施的，应当解除查封并收回查封商品、货物或者其他财产清单。\n";
    public static final Pattern zt = Pattern.compile("(?<zt>.*?专题[\\t\\s\\r\\n]+)(?=.*?专题[\\t\\s\\r\\n]+)",Pattern.MULTILINE|Pattern.DOTALL);
    public static final Pattern pattern = Pattern.compile("\\d+\\.(?<t>.*?\\n)(?<options>.*)$",Pattern.MULTILINE|Pattern.DOTALL);
    public static final Pattern quesPattern =  Pattern.compile("\\d+\\.(?<q>.*)\\n(?<options>([A-Z]+\\..*\\n){1,})");

    public static void zt(String txt){
        Matcher matcher = zt.matcher(txt);
        while (matcher.find()){
            String zt = matcher.group("zt");
            System.out.println(zt);
            System.out.println("=====");
        }
    }

    public static void main(String[] args) throws IOException, OpenXML4JException, XmlException {
        OPCPackage opcPackage = POIXMLDocument.openPackage("C:\\Users\\michaelbie\\Documents\\WeChat Files\\wxid_9827038269712\\FileStorage\\MsgAttach\\8ebeab3a899cf90146434a28cddd4083\\File\\2022-06\\税务稽查业务基础题库（200）.docx");
        POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);

        String txt= extractor.getText();
        XWPFDocument document = new XWPFDocument(opcPackage);
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        for (XWPFParagraph paragraph : paragraphs) {
            System.out.println(paragraph.getText());
            System.out.println("======================================");
        }
        //        zt(txt);
//        System.out.println(txt);
//        Matcher matcher = pattern.matcher(question);
//        if (matcher.find()){
//            System.out.println("found");
//            String t = matcher.group("t");
//            System.out.println(t);
//            System.out.println(matcher.group("options"));
//        }
//        Matcher matcher = quesPattern.matcher(txt);
//        while (matcher.find()){
//            System.out.println("found");
//            String t = matcher.group("q");
//            System.out.println(t);
//            System.out.println(matcher.group("options"));
//            System.out.println("=====");
//        }
    }
}
