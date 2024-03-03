package com.gevorgyan.partner;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return partnerService.getPartnerById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Partner createPartner(@RequestBody Partner partner) {
        return partnerService.createPartner(partner);
    }

    @PutMapping("/{id}")
    public Partner updatePartner(@PathVariable Long id, @RequestBody Partner partner){
       return partnerService.updatePartner(id, partner);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePartner(@PathVariable Long id){
        partnerService.deletePartner(id);
    }
}
