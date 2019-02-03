package com.example.ideapad510.sherkatquestionear.Save;

/**
 * Created by Ideapad 510 on 2/2/2019.
 */

public class SaveObject {
    private String questionId;
    private String answerId;
    private String porseshnameId;
    private String user;

    public SaveObject(String questionId, String answerId, String porseshnameId, String user){
        this.questionId = questionId;
        this.answerId = answerId;
        this.porseshnameId = porseshnameId;
        this.user = user;
    }

    public String getQuestionId(){return questionId;}

    public String getAnswerId(){ return  answerId;}

    public String getPorseshnameId(){ return porseshnameId;}

    public String getUser(){ return user;}

    public void setQuestionId(String questionId){this.questionId = questionId;}

    public void setAnswerId(String answerId){ this.answerId = answerId;}

    public void setPorseshnameId(String porseshnameId){ this.porseshnameId = porseshnameId;}

    public void setUser(String user){ this.user = user;}

}
