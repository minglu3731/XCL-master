package bishe.xcl.com.xcl.data.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_plan")
public class Plan {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "data")
    private String date;
    @DatabaseField(columnName = "content")
    private String content;
    @DatabaseField(columnName = "alert_time")
    private String alerttime;

    public Plan() {
    }

    public Plan(String date, String content, String time) {
        this.date = date;
        this.content = content;
        this.alerttime = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
