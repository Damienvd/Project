package za.ac.nwu.ac.translator;

import za.ac.nwu.domain.dto.MemberVoucherDto;

import java.util.List;

public interface MemberVoucherTranslator {
    List<MemberVoucherDto> getAllMemberVouchers();

    MemberVoucherDto create(MemberVoucherDto memberVoucher);

}
