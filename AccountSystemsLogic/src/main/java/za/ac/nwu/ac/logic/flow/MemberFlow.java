package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.domain.dto.MemberDto;

import java.util.List;

public interface MemberFlow {
    List<MemberDto> getAllMembers();

    MemberDto getMemberById(String idNumber);

    MemberDto addMiles(String idNumber);

}
