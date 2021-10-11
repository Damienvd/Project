package za.ac.nwu.ac.logic.flow.impl;

import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.translator.MemberTranslator;
import za.ac.nwu.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.flow.MemberFlow;


import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Component
public class MemberFlowImpl implements MemberFlow{

    private final MemberTranslator memberTranslator;

    @Autowired
    public MemberFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public List<MemberDto> getAllMembers() {
        return memberTranslator.getAllMembers();
    }

    @Override
    public MemberDto getMemberById(String idNumber) {
        return memberTranslator.getMemberById(idNumber);
    }

    @Override
    public MemberDto addMiles(String idNumber) {
        int miles = 500;//random num
        return memberTranslator.addMiles(idNumber, miles );
    }

}
