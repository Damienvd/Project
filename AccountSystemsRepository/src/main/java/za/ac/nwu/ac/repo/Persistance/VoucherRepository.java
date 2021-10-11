package za.ac.nwu.ac.repo.Persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import za.ac.nwu.domain.dto.persistance.Voucher;

@Component
@Repository
public interface VoucherRepository  extends JpaRepository<Voucher, Long> {

//@Query(value = "SELECT " +
//           "           v" +
//           "   FROM " +
//           "       Voucher v" +
//           "   WHERE v.voucherId = :voucherId")
//   Voucher getVoucherById(long voucherId);

}
