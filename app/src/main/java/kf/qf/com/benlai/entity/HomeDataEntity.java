package kf.qf.com.benlai.entity;

import java.util.List;

/**
 * Created by yzy on 2016/3/10/0010.
 */
public class HomeDataEntity {



    private int lotType;
    private int ModelID;
    private int sortnum;


    private List<HomeListEntity> list;

    public void setLotType(int lotType) {
        this.lotType = lotType;
    }

    public void setModelID(int ModelID) {
        this.ModelID = ModelID;
    }

    public void setSortnum(int sortnum) {
        this.sortnum = sortnum;
    }

    public void setList(List<HomeListEntity> list) {
        this.list = list;
    }

    public int getLotType() {
        return lotType;
    }

    public int getModelID() {
        return ModelID;
    }

    public int getSortnum() {
        return sortnum;
    }

    public List<HomeListEntity> getList() {
        return list;
    }


}
