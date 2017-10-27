package cn.jsdz.manager.po;

import java.io.Serializable;
import java.util.Date;

public class JsdzBuyerOrder implements Serializable{
    private Long id;

    private String sellerId;

    private String buyerId;

    private String typeId;

    private String thickId;

    private String nmcThickId;

    private Integer back;

    private Integer wenlu;

    private Float length;

    private Float width;

    private Integer material;

    private Date createTime;

    private Date updateTime;

    private String buyerAddress;

    private Integer requireTime;

    private String province;

    private String city;

    private String district;

    private Float area;

    private String description;

    private Integer state;

    private String pic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getThickId() {
        return thickId;
    }

    public void setThickId(String thickId) {
        this.thickId = thickId == null ? null : thickId.trim();
    }

    public String getNmcThickId() {
        return nmcThickId;
    }

    public void setNmcThickId(String nmcThickId) {
        this.nmcThickId = nmcThickId == null ? null : nmcThickId.trim();
    }

    public Integer getBack() {
        return back;
    }

    public void setBack(Integer back) {
        this.back = back;
    }

    public Integer getWenlu() {
        return wenlu;
    }

    public void setWenlu(Integer wenlu) {
        this.wenlu = wenlu;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Integer getMaterial() {
        return material;
    }

    public void setMaterial(Integer material) {
        this.material = material;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress == null ? null : buyerAddress.trim();
    }

    public Integer getRequireTime() {
        return requireTime;
    }

    public void setRequireTime(Integer requireTime) {
        this.requireTime = requireTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}