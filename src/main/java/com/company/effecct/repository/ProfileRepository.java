package com.company.effecct.repository;

import com.company.effecct.entity.ProfileEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/11/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    Optional<ProfileEntity> findById(Long id);

    Optional<ProfileEntity> findByEmailAndCreatedDateNotNull(String email);

    @Transactional
    @Modifying
    @Query("update ProfileEntity set name =?1, email =?2  where id =?3")
    int updateProfileDetails(String name, String email, Long id);

    @Transactional
    @Modifying
    @Query("update ProfileEntity set password =?1 where id =?2")
    void updatePassword(String password, Long id);



}
