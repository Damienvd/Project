package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.logic.flow.MemberFlow;
import za.ac.nwu.domain.dto.MemberDto;
import za.ac.nwu.domain.dto.service.GeneralResponse;

import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {

    private final MemberFlow memberFlow;

    @Autowired
    public MemberController(MemberFlow memberFlow) {
        this.memberFlow = memberFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get Member.", notes = "Returns list Member")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<MemberDto>>> getAll() {
        List<MemberDto> members = memberFlow.getAllMembers();
        GeneralResponse<List<MemberDto>> response = new  GeneralResponse<>(true, members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Update Member.", notes = "Returns Member")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    @PostMapping("{idNumber}/addMiles")
    public ResponseEntity<GeneralResponse<MemberDto>> addMiles(
            @PathVariable("idNumber") final String idNumber) {
        MemberDto memberResponse = memberFlow.addMiles(idNumber);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
