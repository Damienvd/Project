package za.ac.nwu.ac.translator;

import za.ac.nwu.domain.dto.VoucherDto;
import za.ac.nwu.domain.dto.persistance.Voucher;

import java.util.List;

public interface VoucherTranslator {

    List<VoucherDto> getAllVouchers();

    VoucherDto create(VoucherDto voucher);
}
