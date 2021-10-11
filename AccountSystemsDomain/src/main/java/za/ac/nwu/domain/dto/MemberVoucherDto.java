package za.ac.nwu.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.dto.persistance.MemberVoucher;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "MemberVoucher", description = "A DTO that represents MemberVoucher")

public class MemberVoucherDto implements Serializable {

    private long voucherId;
    private String memberId;
    private long Id;


    public MemberVoucherDto() {
    }

    public MemberVoucherDto(long voucherId, String memberId, long Id) {
        this.voucherId = voucherId;
        this.memberId = memberId;
        this.Id = Id;
    }

    public MemberVoucherDto(MemberVoucher memberVoucher) {
        this.setMemberId(memberVoucher.getMemberId());
        this.setVoucherId(memberVoucher.getVoucherId());
        this.setId(memberVoucher.getId());
    }

    @ApiModelProperty(position = 1,
            value = "MemberVoucher voucherId",
            name = "voucherId",
            notes = "Uniquely identifies the Voucher",
            dataType = "java.lang.String",
            example = "20201010",
            required = true)
    public long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(long voucherId) {
        this.voucherId = voucherId;
    }

    @ApiModelProperty(position = 2,
            value = "MemberVoucher MemberId",
            name = "MemberId",
            notes = "Uniquely identifies the member",
            dataType = "java.lang.String",
            example = "9802205207087",
            required = true)
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(position = 3,
            value = "MemberVoucher Id",
            name = "Id",
            notes = "Uniquely identifies the MemberVoucher",
            dataType = "java.lang.String",
            example = "123",
            required = true)
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberVoucherDto that = (MemberVoucherDto) o;
        return voucherId == that.voucherId && memberId == that.memberId && Id == that.Id;
    }

    @JsonIgnore
    public MemberVoucher getMemberVoucher() {
        return new MemberVoucher(getVoucherId(), getMemberId(), getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherId, memberId, Id);
    }

    @Override
    public String toString() {
        return "MemberVoucherDto{" +
                "voucherId=" + voucherId +
                ", memberId=" + memberId +
                ", Id=" + Id +
                '}';
    }
}
