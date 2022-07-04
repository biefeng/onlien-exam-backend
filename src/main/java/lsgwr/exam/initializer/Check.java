package lsgwr.exam.initializer;

import lsgwr.exam.initializer.Question;

import java.util.ArrayList;
import java.util.List;

public class Check extends Question {
    List<String> answer = new ArrayList<>();

    @Override
    public String toString() {
        return "Check{" +
                "theme='" + theme + '\'' +
                ", question='" + question + '\'' +
                ", explain='" + explain + '\'' +
                ", options=" + options +
                ", answer=" + answer +
                '}';
    }
}