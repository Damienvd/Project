package za.ac.nwu.domain.dto.persistance;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_VOUCHER", schema = "PROJECT")
public class MemberVoucher implements Serializable {

    private long voucherId;
    private String memberId;
    private long Id;

    public MemberVoucher() {
    }

    public MemberVoucher(long voucherId, String memberId, long Id) {
        this.voucherId = voucherId;
        this.memberId = memberId;
        this.Id = Id;
    }

    @Column(name = "VOUCHER_ID")
    public long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(long voucherId) {
        this.voucherId = voucherId;
    }

    @Column(name = "MEMBER_ID")
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_VOUCHER_SEQ")
    @SequenceGenerator(name = "MEMBER_VOUCHER_SEQ", sequenceName = "MEMBER_VOUCHER_SEQ", allocationSize = 1)
    @Column(name = "ID")
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
        MemberVoucher that = (MemberVoucher) o;
        return voucherId == that.voucherId && memberId.equals(that.memberId) && Id == that.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherId, memberId, Id);
    }

    @Override
    public String toString() {
        return "MemberVoucher{" +
                "voucherId=" + voucherId +
                ", memberId=" + memberId +
                ", Id=" + Id +
                '}';
    }
}
