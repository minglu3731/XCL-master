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

    public Plan() {
    }

    public Plan(String date, String content) {
        this.date = date;
        this.content = content;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
