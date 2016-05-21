package bishe.xcl.com.xcl.data.bean;

public class Plan {
    private String begindate;
    private String enddate;
    private String content;
    private String alerttime;

    public Plan(String begindate, String enddate, String content, String time) {
        this.begindate = begindate;
        this.enddate = enddate;
        this.content = content;
        this.alerttime = time;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAlertTime() {
        return alerttime;
    }

    public void setAlertTime(String time) {
        this.alerttime = time;
    }
}
