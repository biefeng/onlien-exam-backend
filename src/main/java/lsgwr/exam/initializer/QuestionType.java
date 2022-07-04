package lsgwr.exam.initializer;

public enum QuestionType {

    RADIO("单项选择题"),
    CHECK("多项选择题"),
    JUDGE("判断题");
    String type;

    QuestionType(String type) {
        this.type = type;
    }
}