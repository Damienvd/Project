package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.logic.flow.MemberVoucherFlow;
import za.ac.nwu.domain.dto.MemberVoucherDto;
import za.ac.nwu.domain.dto.service.GeneralResponse;

import java.util.List;

@RestController
@RequestMapping("member-voucher")
public class MemberVoucherController {
    private final MemberVoucherFlow memberVoucherFlow;

    @Autowired
    public MemberVoucherController(MemberVoucherFlow memberVoucherFlow) {
        this.memberVoucherFlow = memberVoucherFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get Member.", notes = "Returns list Member")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "MemberVoucher returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<MemberVoucherDto>>> getAll() {
        List<MemberVoucherDto> memberVouchers = memberVoucherFlow.getAllMemberVouchers();
        GeneralResponse<List<MemberVoucherDto>> response = new  GeneralResponse<>(true, memberVouchers);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Buy a voucher.", notes = "Buy a voucher")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Account types created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberVoucherDto>> create(
            @ApiParam(value = "Request body to create new Account Type", required = true)
            @RequestBody MemberVoucherDto memberVoucher) {
        MemberVoucherDto memberVoucherResponse = memberVoucherFlow.create(memberVoucher);
        GeneralResponse<MemberVoucherDto> response = new GeneralResponse<>(true, memberVoucherResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
