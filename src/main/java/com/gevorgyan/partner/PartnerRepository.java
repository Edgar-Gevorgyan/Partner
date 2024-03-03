package com.gevorgyan.partner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PartnerRepository extends JpaRepository<Partner, Long> {
}
