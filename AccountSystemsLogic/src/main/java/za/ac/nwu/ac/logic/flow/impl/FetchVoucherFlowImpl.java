package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.translator.VoucherTranslator;
import za.ac.nwu.domain.dto.VoucherDto;
import za.ac.nwu.ac.logic.flow.FetchVoucherFlow;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchVoucherFlowImpl implements FetchVoucherFlow{

    private final VoucherTranslator voucherTranslator;

    @Autowired
    public FetchVoucherFlowImpl(VoucherTranslator voucherTranslator) {
        this.voucherTranslator = voucherTranslator;
    }

    @Override
    public List<VoucherDto> getAllVouchers() {
        return voucherTranslator.getAllVouchers();
    }

}
