package com.example.projectwebburguer.repository;

import com.example.projectwebburguer.model.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRecord, Long> {
    Optional<UserRecord> findByDocument(String document);
    Optional<UserRecord> findByDocumentOrEmail(String document, String email);
    Optional<UserRecord> findByIdAndCodeOtp(long id, String codeOtp);
}
