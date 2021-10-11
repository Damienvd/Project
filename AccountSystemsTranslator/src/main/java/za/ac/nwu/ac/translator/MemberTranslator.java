package za.ac.nwu.ac.translator;

import za.ac.nwu.domain.dto.MemberDto;
import za.ac.nwu.domain.dto.persistance.Member;

import java.util.List;

public interface MemberTranslator {

    List<MemberDto> getAllMembers();

    MemberDto create(MemberDto member);

    MemberDto addMiles(String idNumber, int milesAmount);

    MemberDto getMemberById(String idNumber);
}
