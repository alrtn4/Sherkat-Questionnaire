package com.example.ideapad510.sherkatquestionear.Save;

/**
 * Created by Ideapad 510 on 2/2/2019.
 */

public class SaveObject {
    private String questionId;
    private String answerId;
    private String porseshnameId;
    private String user;
    private String delete;

    public SaveObject(String questionId, String answerId, String porseshnameId, String user, String delete){
        this.questionId = questionId;
        this.answerId = answerId;
        this.porseshnameId = porseshnameId;
        this.user = user;
        this.delete = delete;
    }

    public String getQuestionId(){return questionId;}

    public String getAnswerId(){ return  answerId;}

    public String getPorseshnameId(){ return porseshnameId;}

    public String getUser(){ return user;}

    public String getDelete(){return delete;}

    public void setQuestionId(String questionId){this.questionId = questionId;}

    public void setAnswerId(String answerId){ this.answerId = answerId;}

    public void setPorseshnameId(String porseshnameId){ this.porseshnameId = porseshnameId;}

    public void setUser(String user){ this.user = user;}

}
