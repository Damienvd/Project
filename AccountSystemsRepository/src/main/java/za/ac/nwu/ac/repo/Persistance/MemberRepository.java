package za.ac.nwu.ac.repo.Persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import za.ac.nwu.domain.dto.persistance.Member;

@Component
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

   @Query(value = "SELECT " +
           "           m" +
           "   FROM " +
           "       Member m" +
           "   WHERE m.idNumber = :idNumber")
   Member getMemberById(String idNumber);

}
