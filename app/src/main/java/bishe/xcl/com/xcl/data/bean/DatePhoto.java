package bishe.xcl.com.xcl.data.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_date_photo")
public class DatePhoto {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "data")
    private String date;

    public DatePhoto() {
    }

    public DatePhoto(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
