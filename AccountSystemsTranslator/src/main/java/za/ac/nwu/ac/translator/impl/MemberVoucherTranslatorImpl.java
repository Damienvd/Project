package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.repo.Persistance.MemberRepository;
import za.ac.nwu.ac.repo.Persistance.MemberVoucherRepository;
import za.ac.nwu.ac.repo.Persistance.VoucherRepository;
import za.ac.nwu.ac.translator.MemberVoucherTranslator;
import za.ac.nwu.domain.dto.MemberVoucherDto;
import za.ac.nwu.domain.dto.persistance.Member;
import za.ac.nwu.domain.dto.persistance.MemberVoucher;
import za.ac.nwu.domain.dto.persistance.Voucher;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberVoucherTranslatorImpl implements MemberVoucherTranslator {

    private final MemberVoucherRepository memberVoucherRepository;
    private final VoucherRepository voucherRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberVoucherTranslatorImpl(MemberVoucherRepository memberVoucherRepository, VoucherRepository voucherRepository, MemberRepository memberRepository) {
        this.memberVoucherRepository = memberVoucherRepository;
        this.voucherRepository = voucherRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberVoucherDto> getAllMemberVouchers() {
        List<MemberVoucherDto> memberVoucherDtos = new ArrayList<>();
        try {
            for (MemberVoucher memberVoucher : memberVoucherRepository.findAll()) {
                memberVoucherDtos.add(new MemberVoucherDto(memberVoucher));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return memberVoucherDtos;
    }

    @Override
    public MemberVoucherDto create(MemberVoucherDto memberVoucherDto) {
        try {
            MemberVoucher memberVoucherToCreate = memberVoucherDto.getMemberVoucher();

            Member member = memberRepository.getMemberById(memberVoucherToCreate.getMemberId());
            Voucher voucher = memberVoucherRepository.getVoucherById(memberVoucherToCreate.getVoucherId());

            member.miles -= voucher.cost;
            memberRepository.save(member);

            MemberVoucher memberVoucher = memberVoucherRepository.save(memberVoucherToCreate);
            return new MemberVoucherDto(memberVoucher);
        } catch (Exception e ) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

}
