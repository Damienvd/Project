package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.repo.Persistance.MemberRepository;
import za.ac.nwu.ac.translator.MemberTranslator;
import za.ac.nwu.domain.dto.MemberDto;
import za.ac.nwu.domain.dto.persistance.Member;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberTranslatorImpl implements MemberTranslator {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberTranslatorImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberDto> getAllMembers() {
        List<MemberDto> memberDtos = new ArrayList<>();
        try {
            for (Member member : memberRepository.findAll()) {
                memberDtos.add(new MemberDto(member));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return memberDtos;
    }

    @Override
    public MemberDto create(MemberDto memberDto) {
        try {
            Member member = memberRepository.save(memberDto.getMember());
            return new MemberDto(member);
        } catch (Exception e ) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public MemberDto addMiles(String idNumber, int milesAmount) {
        try {
            Member dbMember = memberRepository.getMemberById(idNumber);

            dbMember.plays--;
            dbMember.miles = milesAmount;

            Member updatedMember = memberRepository.save(dbMember);
            return new MemberDto(updatedMember);

        } catch (Exception e ) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public MemberDto getMemberById(String idNumber) {
        try {
            Member member = memberRepository.getMemberById(idNumber);
        } catch (Exception e ) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return null;
    }

}
