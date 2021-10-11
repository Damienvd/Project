package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.domain.dto.MemberVoucherDto;

import java.util.List;

public interface MemberVoucherFlow {
    List<MemberVoucherDto> getAllMemberVouchers();
    MemberVoucherDto create(MemberVoucherDto memberVoucher);
}
