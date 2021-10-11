package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.repo.Persistance.VoucherRepository;
import za.ac.nwu.ac.translator.VoucherTranslator;
import za.ac.nwu.domain.dto.VoucherDto;
import za.ac.nwu.domain.dto.persistance.Voucher;

import java.util.ArrayList;
import java.util.List;

@Component
public class VoucherTranslatorImpl implements VoucherTranslator {
    private final VoucherRepository voucherRepository;

    @Autowired
    public VoucherTranslatorImpl(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    @Override
    public List<VoucherDto> getAllVouchers() {
        List<VoucherDto> voucherDtos = new ArrayList<>();
        try {
            for (Voucher voucher : voucherRepository.findAll()) {
                voucherDtos.add(new VoucherDto(voucher));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return voucherDtos;
    }

    @Override
    public VoucherDto create(VoucherDto voucherDto) {
        try {
            Voucher voucher = voucherRepository.save(voucherDto.getVoucher());
            return new VoucherDto(voucher);
        } catch (Exception e ) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

}
