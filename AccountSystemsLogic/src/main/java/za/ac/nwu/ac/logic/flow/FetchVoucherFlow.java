package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.domain.dto.VoucherDto;

import java.util.List;

public interface FetchVoucherFlow {
    List<VoucherDto> getAllVouchers();
}
