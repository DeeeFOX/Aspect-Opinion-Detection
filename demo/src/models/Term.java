package models;

/**
 * Created by Chiu on 2016/3/12.
 */
public class Term {
    private String word;
    private String nature;

    public Term() {
    }

    public Term(String word, String nature) {
        this.word = word;
        this.nature = nature;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
}
