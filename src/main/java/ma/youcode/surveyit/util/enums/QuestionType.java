package ma.youcode.surveyit.util.enums;

public enum QuestionType {
    SINGLE_CHOICE("Single choice option where only one answer can be selected"),
    MULTI_CHOICE("Multiple choice option allowing multiple answers");


    private final String desc;

    QuestionType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


}
