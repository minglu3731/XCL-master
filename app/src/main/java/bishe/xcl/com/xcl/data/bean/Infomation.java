package bishe.xcl.com.xcl.data.bean;

import java.io.Serializable;

public class Infomation implements Serializable{
    private int imgId;
    private int[] imgBigId;
    private String title;
    private String content;

    public Infomation(int imgId, int[] imgBigId, String title, String content) {
        this.imgId = imgId;
        this.imgBigId = imgBigId;
        this.title = title;
        this.content = content;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int[] getImgBigId() {
        return imgBigId;
    }

    public void setImgBigId(int[] imgBigId) {
        this.imgBigId = imgBigId;
    }
}
