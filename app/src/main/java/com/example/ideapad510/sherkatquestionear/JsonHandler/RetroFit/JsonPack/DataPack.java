
package com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPack {

    @SerializedName("id")
    private Integer id;
    @SerializedName("rcode")
    private String rcode;
    @SerializedName("ucode")
    private String ucode;
    @SerializedName("changeucode")
    private String changeucode;
    @SerializedName("ushadolist")
    private String ushadolist;
    @SerializedName("changeacodelist")
    private String changeacodelist;
    @SerializedName("jmrcode")
    private String jmrcode;
    @SerializedName("qlcode")
    private String qlcode;
    @SerializedName("qcode")
    private String qcode;
    @SerializedName("qtype")
    private String qtype;
    @SerializedName("acode")
    private String acode;
    @SerializedName("rtext")
    private String rtext;
    @SerializedName("rdone")
    private String rdone;
    @SerializedName("rtime")
    private String rtime;

    public DataPack(Integer id, String rcode, String ucode, String changeucode, String ushadolist, String changeacodelist, String jmrcode, String qlcode, String qcode, String qtype, String acode, String rtext, String rdone, String rtime) {
        this.id = id;
        this.rcode = rcode;
        this.ucode = ucode;
        this.changeucode = changeucode;
        this.ushadolist = ushadolist;
        this.changeacodelist = changeacodelist;
        this.jmrcode = jmrcode;
        this.qlcode = qlcode;
        this.qcode = qcode;
        this.qtype = qtype;
        this.acode = acode;
        this.rtext = rtext;
        this.rdone = rdone;
        this.rtime = rtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    public String getChangeucode() {
        return changeucode;
    }

    public void setChangeucode(String changeucode) {
        this.changeucode = changeucode;
    }

    public String getUshadolist() {
        return ushadolist;
    }

    public void setUshadolist(String ushadolist) {
        this.ushadolist = ushadolist;
    }

    public String getChangeacodelist() {
        return changeacodelist;
    }

    public void setChangeacodelist(String changeacodelist) {
        this.changeacodelist = changeacodelist;
    }

    public String getJmrcode() {
        return jmrcode;
    }

    public void setJmrcode(String jmrcode) {
        this.jmrcode = jmrcode;
    }

    public String getQlcode() {
        return qlcode;
    }

    public void setQlcode(String qlcode) {
        this.qlcode = qlcode;
    }

    public String getQcode() {
        return qcode;
    }

    public void setQcode(String qcode) {
        this.qcode = qcode;
    }

    public String getQtype() {
        return qtype;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    public String getAcode() {
        return acode;
    }

    public void setAcode(String acode) {
        this.acode = acode;
    }

    public String getRtext() {
        return rtext;
    }

    public void setRtext(String rtext) {
        this.rtext = rtext;
    }

    public String getRdone() {
        return rdone;
    }

    public void setRdone(String rdone) {
        this.rdone = rdone;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

}
