package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.dto.persistance.Member;
import za.ac.nwu.domain.dto.persistance.Voucher;

import javax.naming.Name;
import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Voucher", description = "A DTO that represents Voucher")

public class VoucherDto implements Serializable {

    private long voucherId;
    private String voucherName;
    private String voucherDesc;
    private int value;
    private int cost;

    public VoucherDto() {
    }

    public VoucherDto(long voucherId, String name, String vDesc, int value, int cost) {
        this.voucherId = voucherId;
        this.voucherName = name;
        this.voucherDesc = vDesc;
        this.value = value;
        this.cost = cost;
    }

    public VoucherDto(Voucher voucher) {
        this.setVoucherId(voucher.getVoucherId());
        this.setVoucherName(voucher.getVoucherName());
        this.setVoucherDesc(voucher.getVoucherDesc());
        this.setValue(voucher.getValue());
        this.setCost(voucher.getCost());
    }

    @ApiModelProperty(position = 1,
            value = "Voucher VoucherId",
            name = "VoucherId",
            notes = "Uniquely identifies the Voucher",
            dataType = "java.lang.String",
            example = "123",
            required = true)
    public long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(long voucherId) {
        this.voucherId = voucherId;
    }

    @ApiModelProperty(position = 2,
            value = "Voucher voucherName",
            name = "voucherName",
            notes = "Voucher name",
            dataType = "java.lang.String",
            example = "Checkers",
            required = true)
    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String name) {
        this.voucherName = name;
    }

    @ApiModelProperty(position = 3,
            value = "Voucher voucherDesc",
            name = "voucherDesc",
            notes = "Voucher description",
            dataType = "java.lang.String",
            example = "Checkers voucher",
            required = true)
    public String getVoucherDesc() {
        return voucherDesc;
    }

    public void setVoucherDesc(String vDesc) {
        this.voucherDesc = vDesc;
    }

    @ApiModelProperty(position = 4,
            value = "Voucher Value",
            name = "Value",
            notes = "Voucher value",
            dataType = "java.lang.String",
            example = "10",
            required = true)
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @ApiModelProperty(position = 4,
            value = "Voucher Cost",
            name = "Cost",
            notes = "Voucher cost",
            dataType = "java.lang.String",
            example = "10",
            required = true)
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoucherDto that = (VoucherDto) o;
        return voucherId == that.voucherId && value == that.value && cost == that.cost && Objects.equals(voucherName, that.voucherName) && Objects.equals(voucherDesc, that.voucherDesc);
    }

    @JsonIgnore
    public Voucher getVoucher() {
        return new Voucher(getVoucherId(), getVoucherName(), getVoucherDesc(), getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherId, voucherName, voucherDesc, value, cost);
    }

    @Override
    public String toString() {
        return "VoucherDto{" +
                "voucherId=" + voucherId +
                ", voucherName='" + voucherName + '\'' +
                ", voucherDesc='" + voucherDesc + '\'' +
                ", value=" + value +
                ", cost=" + cost +
                '}';
    }
}
