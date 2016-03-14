package kf.qf.com.benlai.entity;

/**
 * Created by yzy on 2016/3/10/0010.
 */
public class HomeListEntity {

    /**
     * sysno : 13138
     * img : http://image6.benlailife.com/AppHomePageImage/631c4e66cb7f44aa9b2e91a174b3f2fd_n-n.jpg
     * position : 1
     * type : 6
     * value : http://m.benlai.com/huanan/zt/0304nm?webSiteSysNo=3&deliverySysNo=120&source=3
     * title : 定制版安岳柠檬10粒秒杀价3.8元
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
