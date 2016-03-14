package kf.qf.com.benlai.entity;

/**
 * Created by yzy on 2016/3/10/0010.
 */
public class VpHomeEntity {

    /**
     * sysno : 13146
     * img : http://image6.benlailife.com/AppHomePageImage/1c29ea2815414099942be5be363614fd_n-n.jpg
     * position : 1
     * type : 6
     * value : http://m.benlai.com/huanan/zt/20160301mzhx?webSiteSysNo=2&deliverySysNo=246&source=3
     * title : 美洲海鲜盛宴：阿根廷红虾168元4斤；
     * startTime : 0
     * endTime : 0
     */

    private int sysno;
    private String img;
    private int position;
    private int type;
    private String value;
    private String title;
    private int startTime;
    private int endTime;

    public void setSysno(int sysno) {
        this.sysno = sysno;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getSysno() {
        return sysno;
    }

    public String getImg() {
        return img;
    }

    public int getPosition() {
        return position;
    }

    public int getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
