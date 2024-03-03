package com.gevorgyan.partner;

import com.gevorgyan.partner.exception.PartnerInvalidException;
import com.gevorgyan.partner.exception.PartnerNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public List<Partner> getPartners(){
        return partnerRepository.findAll();
    }

    public Partner getPartnerById(Long id) throws PartnerNotFoundException {
        return partnerRepository.findById(id)
                .orElseThrow(() -> new PartnerNotFoundException("Partner with id: " + id + " does not exists."));
    }

    public Partner createPartner(Partner partner) throws PartnerInvalidException {
        try {
            return partnerRepository.save(partner);
        } catch (DataIntegrityViolationException e){
            throw new PartnerInvalidException("Partner is not well defined");
        }
    }

    public Partner updatePartner(Long id, Partner partner) throws PartnerNotFoundException {
        if(!partnerRepository.existsById(id)){
            throw new PartnerNotFoundException("Partner with id: " + id + " does not exists.");
        }
        partner.setId(id);
        return partnerRepository.save(partner);
    }

    public void deletePartner(Long id) throws PartnerNotFoundException {
        Partner partner = getPartnerById(id);
        partnerRepository.delete(partner);
    }
}
