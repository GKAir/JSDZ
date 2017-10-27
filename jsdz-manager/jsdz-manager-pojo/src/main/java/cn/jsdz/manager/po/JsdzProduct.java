package cn.jsdz.manager.po;

import java.io.Serializable;

public class JsdzProduct implements Serializable{
    private Integer id;

    private Integer typeId;

    private Integer thickId;

    private Integer nmcThickId;

    private Integer back;

    private Float length;

    private Float width;

    private Integer material;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getThickId() {
        return thickId;
    }

    public void setThickId(Integer thickId) {
        this.thickId = thickId;
    }

    public Integer getNmcThickId() {
        return nmcThickId;
    }

    public void setNmcThickId(Integer nmcThickId) {
        this.nmcThickId = nmcThickId;
    }

    public Integer getBack() {
        return back;
    }

    public void setBack(Integer back) {
        this.back = back;
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

    @Override
    public String toString() {
        return "JsdzProduct{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", thickId=" + thickId +
                ", nmcThickId=" + nmcThickId +
                ", back=" + back +
                ", length=" + length +
                ", width=" + width +
                ", material=" + material +
                '}';
    }
}