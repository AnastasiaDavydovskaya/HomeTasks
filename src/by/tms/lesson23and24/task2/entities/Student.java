package by.tms.lesson23and24.task2.entities;

public class Student {

    private String name;
    private String language;
    private String additionalInfo;
    private String secretWord;

    public Student(String name, String language, String additionalInfo, String secretWord) {
        this.name = name;
        this.language = language;
        this.additionalInfo = additionalInfo;
        this.secretWord = secretWord;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", secretWord='" + secretWord + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }
}
