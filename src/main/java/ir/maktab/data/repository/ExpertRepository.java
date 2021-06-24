package ir.maktab.data.repository;

import ir.maktab.data.domain.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Integer> {

    Optional<Expert> findByEmail(String email);
}
