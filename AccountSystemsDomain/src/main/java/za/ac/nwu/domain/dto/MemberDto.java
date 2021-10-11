package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.dto.persistance.Member;


import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Member", description = "A DTO that represents Member")

public class MemberDto implements Serializable {

    private String idNumber;
    private String name;
    private String lastName;
    private long plays;
    private long miles;

    public MemberDto() {
    }

    public MemberDto(String idNumber, String name, String lastName, long plays, long miles) {
        this.idNumber = idNumber;
        this.name = name;
        this.lastName = lastName;
        this.plays = plays;
        this.miles = miles;
    }

    public MemberDto(Member member) {
        this.setIdNumber(member.getIdNumber());
        this.setName(member.getName());
        this.setLastName(member.getLastName());
        this.setPlays(member.getPlays());
        this.setMiles(member.getMiles());
    }



    @ApiModelProperty(position = 1,
            value = "Member IdNumber",
            name = "IdNumber",
            notes = "Uniquely identifies the Member",
            dataType = "java.lang.String",
            example = "9802205207087",
            required = true)
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @ApiModelProperty(position = 2,
            value = "Member Name",
            name = "Name",
            notes = "Name of member",
            dataType = "java.lang.String",
            example = "John",
            required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(position = 3,
            value = "Member LastName",
            name = "LastName",
            notes = "LastName of Member",
            dataType = "java.lang.String",
            example = "Doe",
            required = true)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ApiModelProperty(position = 4,
            value = "Member Plays",
            name = "Plays",
            notes = "Number of plays a member has",
            dataType = "java.lang.String",
            example = "3",
            required = true)
    public long getPlays() { return plays; }

    public void setPlays(long plays) {
        this.plays = plays;
    }

    @ApiModelProperty(position = 5,
            value = "Member Miles",
            name = "Miles",
            notes = "Amount of Miles a member has",
            dataType = "java.lang.String",
            example = "10",
            required = true)
    public long getMiles() {
        return miles;
    }

    public void setMiles(long miles) {
        this.miles = miles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDto memberDto = (MemberDto) o;
        return plays == memberDto.plays && miles == memberDto.miles && Objects.equals(idNumber, memberDto.idNumber) && Objects.equals(name, memberDto.name) && Objects.equals(lastName, memberDto.lastName);
    }

    @JsonIgnore
    public Member getMember()
    {
        return new Member(getIdNumber(), getName(), getLastName(), getPlays(), getMiles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, name, lastName, plays, miles);
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", plays=" + plays +
                ", miles=" + miles +
                '}';
    }
}
