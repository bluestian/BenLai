package kf.qf.com.benlai.entity;

import java.util.List;

/**
 * Created by yzy on 2016/3/7/0007.
 */
public class CityEntity {


    /**
     * areaName : A
     * city : [{"cityNo":86,"cityName":"鞍山"},{"cityNo":152,"cityName":"安庆"},{"cityNo":203,"cityName":"安阳"}]
     */

    private String areaName;
    /**
     * cityNo : 86
     * cityName : 鞍山
     */

    private List<CityEnt> city;

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setCity(List<CityEnt> city) {
        this.city = city;
    }

    public String getAreaName() {
        return areaName;
    }

    public List<CityEnt> getCity() {
        return city;
    }

    public static class CityEnt {
        private int cityNo;
        private String cityName;

        public void setCityNo(int cityNo) {
            this.cityNo = cityNo;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public int getCityNo() {
            return cityNo;
        }

        public String getCityName() {
            return cityName;
        }
    }
}
