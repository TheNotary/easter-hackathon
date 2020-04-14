package com.njax.destructocats.java.app.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// public interface HelloRepository extends JpaRepository<HelloEntity,Integer> {
@Repository
public interface HelloRepository extends CrudRepository<HelloEntity,Integer> {

    

    // @Query(value = "Select * from hellos where id = ?1", nativeQuery = true)
    // public HelloEntity findId(int id);

    // @Query(value = "SELECT * FROM Claim WHERE ClaimId = ?1", nativeQuery = true)
    // public HelloEntity findByClaimId(String claimId);
    //
    // @Query(value = "SELECT * FROM Claim WHERE ClaimId = ?1 and PlatformId = ?2 and Subgroup = ?3 and MemberNumber = ?4", nativeQuery = true)
    // public HelloEntity findByClaimIdAndPlatformIdAndSubgroupAndMemberNumber(String claimId, int platformId, String subgroup, String memberNumber);
    //
    // @Query(value = "SELECT * FROM Claim WHERE ClaimId = ?1 and PlatformId = ?2 and Subgroup = ?3 and StartingServiceDate = ?4", nativeQuery = true)
    // public HelloEntity findByClaimIdAndPlatformIdAndSubgroupAndStartingServiceDate(String claimId, int platformId, String subgroup, LocalDate startingServiceDate);
    //
    // @Query(value = "SELECT * FROM Claim WHERE ClaimId = ?1 and PlatformId = ?2 and Subgroup = ?3 and ProviderMpin = ?4", nativeQuery = true)
    // public HelloEntity findByClaimIdAndPlatformIdAndSubgroupAndProviderMpin(String claimId, int platformId, String subgroup, String providerMpin);
    //
    // @Query(value = "SELECT * FROM Claim WHERE ContractID = ?1 ORDER BY RowId LIMIT ?3, ?2", nativeQuery = true)
    // public List<HelloEntity> findByContractId(int contractID, int claimLimit, int claimSkip);

}
