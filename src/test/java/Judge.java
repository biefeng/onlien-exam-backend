

public class Judge extends Question {
    boolean answer;

    @Override
    public String toString() {
        return "Judge{" +
                "theme='" + theme + '\'' +
                ", question='" + question + '\'' +
                ", explain='" + explain + '\'' +
                ", options=" + options +
                ", answer=" + answer +
                '}';
    }
}