import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionResolve {

    public static final Pattern themePattern = Pattern.compile("\\s*\\{(?<cat>.*)}\\s*");
    public static final Pattern selectOptionPattern = Pattern.compile("^(?<optKey>[A-Za-z]+)\\s*(\\.|、|．)\\s*(?<optVal>.*)[\\t\\s\\r\\n]*$");
    public static final Pattern questionPattern = Pattern.compile("^\\d+\\s*(\\.|、|．)\\s*(?<question>.*)$");
    public static final Pattern selectAnswerPattern = Pattern.compile("^参考答案\\s*(:|：)\\s*(?<answer>.*)[\\t\\s\\r\\n]*$");
    public static final Pattern explainPattern = Pattern.compile("^答案解析\\s*(:|：)\\s*(?<explain>.*)[\\t\\s\\r\\n]*$");

    public static List<Question> getQuestions() {
        List<String> strings = FileUtil.readLines(new File("D:\\workspace\\idea\\spring-boot-online-exam\\doc\\税务稽查案件办理程序规定专题.txt"), CharsetUtil.UTF_8);
        Question question = null;
        String theme = null;
        String explain = "";
        QuestionType questionType = null;
        LineType lineType = null;
        List<Question> questionList = new ArrayList<>();
        outer:
        for (String string : strings) {
            if (StrUtil.isEmpty(string)) {
                continue;
            }
            string = string.trim();
            Matcher themeMatcher = themePattern.matcher(string);
            if (themeMatcher.find()) {
                theme = themeMatcher.group("cat");
                lineType = LineType.THEME;
                continue;
            }

            Matcher explainMatcher = explainPattern.matcher(string);
            if (explainMatcher.find()) {
                String e = explainMatcher.group("explain");
                question.explain += e;
                lineType = LineType.EXPLAIN;
                questionList.add(question);
                continue;
            } else if (lineType == LineType.EXPLAIN) {
                question.explain += string;
            }

            Matcher selectAnswerMatcher = selectAnswerPattern.matcher(string);
            if (selectAnswerMatcher.find() && null != question) {
                lineType = LineType.ANSWER;
                String answer = selectAnswerMatcher.group("answer");
                if (questionType == QuestionType.CHECK) {
                    ((Check) question).answer.addAll(Arrays.asList(answer.split("|")));
                } else if (questionType == QuestionType.RADIO) {
                    ((Radio) question).answer = answer;
                } else if (questionType == QuestionType.JUDGE) {
                    ((Judge) question).answer = answer.trim().equals("对");
                }
                continue;
            }

            for (QuestionType value : QuestionType.values()) {
                if (string.indexOf(value.type) > 0) {
                    questionType = value;
                    lineType = LineType.TYPE;
                    continue outer;
                }
            }


            if (questionType == QuestionType.CHECK || questionType == QuestionType.RADIO) {
                Matcher selectOptMatcher = selectOptionPattern.matcher(string);
                if (selectOptMatcher.find() && (lineType == LineType.OPTION || LineType.QUESTION == lineType)) {
                    lineType = LineType.OPTION;
                    String optKey = selectOptMatcher.group("optKey");
                    String optVal = selectOptMatcher.group("optVal");
                    question.options.put(optKey, optVal);
                    continue;
                }
            }


            Matcher matcher = questionPattern.matcher(string);
            if (matcher.find() && (lineType == LineType.TYPE || lineType == LineType.EXPLAIN)) {
                lineType = LineType.QUESTION;
                if (QuestionType.RADIO.equals(questionType)) {
                    question = new Radio();
                } else if (QuestionType.CHECK.equals(questionType)) {
                    question = new Check();
                } else if (QuestionType.JUDGE.equals(questionType)) {
                    question = new Judge();
                    question.options.put("true", "正确");
                    question.options.put("false", "错误");
                }
                question.theme = theme;
                question.question = matcher.group("question");
                question.type = questionType;
                continue;
            }

        }
        for (Question q : questionList) {
            System.out.println(q);
        }
        return questionList;
    }


    public static void main(String[] args) {
        List<Question> questions = getQuestions();

    }


}


