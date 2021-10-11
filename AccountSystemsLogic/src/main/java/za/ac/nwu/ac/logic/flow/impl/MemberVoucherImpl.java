package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.logic.flow.MemberVoucherFlow;
import za.ac.nwu.ac.translator.MemberTranslator;
import za.ac.nwu.ac.translator.MemberVoucherTranslator;
import za.ac.nwu.domain.dto.MemberVoucherDto;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class MemberVoucherImpl implements MemberVoucherFlow {

    private final MemberVoucherTranslator memberVoucherTranslator;

    @Autowired
    public MemberVoucherImpl(MemberVoucherTranslator memberVoucherTranslator) {
        this.memberVoucherTranslator = memberVoucherTranslator;
    }

    @Override
    public List<MemberVoucherDto> getAllMemberVouchers() {
        return memberVoucherTranslator.getAllMemberVouchers();
    }

    @Override
    public MemberVoucherDto create(MemberVoucherDto memberVoucher) {
        return memberVoucherTranslator.create(memberVoucher);
    }

}
