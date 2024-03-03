package com.gevorgyan.partner;

import com.gevorgyan.partner.exception.PartnerNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/partners")
@AllArgsConstructor
public class PartnerController {
    private final PartnerService partnerService;

    @GetMapping
    public List<Partner> getPartners(){
        return partnerService.getPartners();
    }

    @GetMapping("/{id}")
    public Partner getPartner(@PathVariable Long id){
        try {
            return partnerService.getPartnerById(id);
        } catch (PartnerNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Partner createPartner(@RequestBody Partner partner) {
        return partnerService.createPartner(partner);
    }

    @PutMapping("/{id}")
    public Partner updatePartner(@PathVariable Long id, @RequestBody Partner partner){
        try{
            return partnerService.updatePartner(id, partner);
        } catch (PartnerNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePartner(@PathVariable Long id){
        try {
            partnerService.deletePartner(id);
        } catch (PartnerNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
