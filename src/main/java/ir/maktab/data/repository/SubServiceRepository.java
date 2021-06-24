package ir.maktab.data.repository;

import ir.maktab.data.domain.Expert;
import ir.maktab.data.domain.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubServiceRepository extends JpaRepository<SubService, Integer> {

    Optional<SubService> findByName(String name);

    @Query("select s from SubService as s where s.service.name=:name")
    List<SubService> findByServiceName(@Param("name") String name);
}
