
public class Radio extends Question {
    String answer;

    @Override
    public String toString() {
        return "Radio{" +
                "theme='" + theme + '\'' +
                ", question='" + question + '\'' +
                ", explain='" + explain + '\'' +
                ", options=" + options +
                ", answer='" + answer + '\'' +
                '}';
    }
}