package za.ac.nwu.domain.dto.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MEMBER", schema = "PROJECT")
public class Member implements Serializable {

    private String idNumber;
    private String name;
    private String lastName;
    public long plays;
    public long miles;

    public Member() {
    }

    public Member(String idNumber, String name, String lastName, long plays, long miles) {
        this.idNumber = idNumber;
        this.name = name;
        this.lastName = lastName;
        this.plays = plays;
        this.miles = miles;
    }

    @Id
    @Column(name = "ID_NUMBER")
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "PLAYS")
    public long getPlays() {
        return plays;
    }

    public void setPlays(long plays) {
        this.plays = plays;
    }

    @Column(name = "MILES")
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
        Member member = (Member) o;
        return plays == member.plays && miles == member.miles && Objects.equals(idNumber, member.idNumber) && Objects.equals(name, member.name) && Objects.equals(lastName, member.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, name, lastName, plays, miles);
    }

    @Override
    public String toString() {
        return "Member{" +
                "idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", plays=" + plays +
                ", miles=" + miles +
                '}';
    }
}
