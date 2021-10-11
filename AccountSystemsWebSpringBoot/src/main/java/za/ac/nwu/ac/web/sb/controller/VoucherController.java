package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.logic.flow.FetchVoucherFlow;
import za.ac.nwu.domain.dto.VoucherDto;
import za.ac.nwu.domain.dto.service.GeneralResponse;

import java.util.List;

@RestController
@RequestMapping("voucher")
public class VoucherController {
    private final FetchVoucherFlow fetchVoucherFlow;

    @Autowired
    public VoucherController(FetchVoucherFlow fetchVoucherFlow) {
        this.fetchVoucherFlow = fetchVoucherFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get Voucher.", notes = "Returns list of Vouchers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Vouchers returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<VoucherDto>>> getAll() {
        List<VoucherDto> vouchers = fetchVoucherFlow.getAllVouchers();
        GeneralResponse<List<VoucherDto>> response = new  GeneralResponse<>(true, vouchers);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
