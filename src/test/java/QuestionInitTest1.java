import cn.hutool.core.util.IdUtil;
import lsgwr.exam.ExamApplication;

import lsgwr.exam.entity.QuestionBank;
import lsgwr.exam.entity.QuestionCategory;
import lsgwr.exam.entity.QuestionOption;
import lsgwr.exam.repository.QuestionBankRepository;
import lsgwr.exam.repository.QuestionCategoryRepository;
import lsgwr.exam.repository.QuestionOptionRepository;
import lsgwr.exam.repository.QuestionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest(classes = {ExamApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class QuestionInitTest1 {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionOptionRepository questionOptionRepository;

    @Autowired
    private QuestionBankRepository questionBankRepository;

    @Autowired
    private QuestionCategoryRepository questionCategoryRepository;

    @Test
    public void name() {
        List<Question> questions = (List<Question>) QuestionResolve1.getQuestions();
        Set<String> cats = new HashSet<>();
        for (Question question : questions) {
            cats.add(question.theme);
        }
        Map<String, Integer> catMap = new HashMap<>();
        int i=0;
        for (String cat : cats) {
            QuestionCategory questionCategory = new QuestionCategory();
            int questionCategoryId =i++;
//            questionCategory.setQuestionCategoryId(questionCategoryId);
            questionCategory.setQuestionCategoryName(cat);
            questionCategoryRepository.save(questionCategory);
            catMap.put(cat,questionCategory.getQuestionCategoryId());
        }
        QuestionBank questionBank = new QuestionBank();
        String questionBankId = IdUtil.simpleUUID();
        questionBank.setId(questionBankId);
        questionBank.setName("大企业税收管理");

        questionBankRepository.save(questionBank);

        for (Question question : questions) {
            Map<String, String> options = question.options;

            Map<String, String> answerMap = new HashMap<>();
            List<String> optionIdList = new ArrayList<>();
            for (Map.Entry<String, String> entry : options.entrySet()) {
                QuestionOption questionOption = new QuestionOption();
                String questionOptionId = UUID.randomUUID().toString().replaceAll("-", "");
                questionOption.setQuestionOptionId(questionOptionId);
                questionOption.setQuestionOptionContent(entry.getValue());
                questionOption.setQuestionOptionKey(entry.getKey());
                questionOptionRepository.save(questionOption);
                answerMap.put(entry.getKey(), questionOptionId);
                optionIdList.add(questionOptionId);
            }

            lsgwr.exam.entity.Question s = new  lsgwr.exam.entity.Question();
            if (question.type == QuestionType.RADIO) {
                String answer = ((Radio) question).answer;
                s.setQuestionAnswerOptionIds(answerMap.get(answer));
                s.setQuestionTypeId(1);
            } else if (question.type == QuestionType.CHECK) {
                List<String> answers = ((Check) question).answer;
                s.setQuestionAnswerOptionIds(String.join("-", answers.stream().map(answerMap::get).collect(Collectors.toList())));
                s.setQuestionTypeId(2);
            } else if (question.type == QuestionType.JUDGE) {
                boolean answer = ((Judge) question).answer;
                s.setQuestionAnswerOptionIds(answerMap.get(Boolean.toString(answer)));
                s.setQuestionTypeId(3);
            }
            s.setQuestionId(UUID.randomUUID().toString().replaceAll("-",""));
            s.setQuestionOptionIds(String.join("-",optionIdList));
            s.setQuestionName(question.question);
            s.setQuestionCategoryId(catMap.get(question.theme));
            s.setQuestionLevelId(1);
            s.setQuestionDescription(question.explain);
            s.setQuestionScore(5);
            s.setQuestionCreatorId("6a4a7ba7d94f4b87a1cf7f744f903f18");
            questionRepository.save(s);
        }
    }
}
