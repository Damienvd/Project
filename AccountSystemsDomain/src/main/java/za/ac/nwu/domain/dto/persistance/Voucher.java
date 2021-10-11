package za.ac.nwu.domain.dto.persistance;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "VOUCHER", schema = "PROJECT")
public class Voucher implements Serializable {

    private long voucherId;
    private String voucherName;
    private String voucherDesc;
    private int value;
    public int cost;

    public Voucher() {
    }

    public Voucher(long voucherId, String voucherName, String voucherDesc, int cost) {
    }

    public Voucher(long voucherId, String voucherName, String voucherDesc, int value, int cost) {
        this.voucherId = voucherId;
        this.voucherName = voucherName;
        this.voucherDesc = voucherDesc;
        this.value = value;
        this.cost = cost;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VOUCHER_SEQ")
    @SequenceGenerator(name = "VOUCHER_SEQ", sequenceName = "VOUCHER_SEQ", allocationSize = 1)
    @Column(name = "VOUCHER_ID")
    public long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(long voucherId) {
        this.voucherId = voucherId;
    }

    @Column(name = "VOUCHER_NAME")
    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    @Column(name = "VOUCHER_DESC")
    public String getVoucherDesc() {
        return voucherDesc;
    }

    public void setVoucherDesc(String voucherDesc) {
        this.voucherDesc = voucherDesc;
    }

    @Column(name = "VALUE")
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Column(name = "COST")
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
        Voucher voucher = (Voucher) o;
        return voucherId == voucher.voucherId && value == voucher.value && cost == voucher.cost && Objects.equals(voucherName, voucher.voucherName) && Objects.equals(voucherDesc, voucher.voucherDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherId, voucherName, voucherDesc, value, cost);
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "voucherId=" + voucherId +
                ", voucherName='" + voucherName + '\'' +
                ", voucherDesc='" + voucherDesc + '\'' +
                ", value=" + value +
                ", cost=" + cost +
                '}';
    }
}
