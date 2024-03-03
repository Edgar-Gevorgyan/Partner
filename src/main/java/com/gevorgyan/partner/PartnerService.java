package com.gevorgyan.partner;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public List<Partner> getPartners(){
        return partnerRepository.findAll();
    }

    public Partner getPartnerById(Long id) {
        return partnerRepository.findById(id).orElse(null);
    }

    public Partner createPartner(Partner partner) {
        return partnerRepository.save(partner);
    }

    public Partner updatePartner(Long id, Partner partner) {
        partner.setId(id);
        return partnerRepository.save(partner);
    }

    public void deletePartner(Long id){
        Partner partner = getPartnerById(id);
        partnerRepository.delete(partner);
    }
}
