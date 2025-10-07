
package main.java.com.ms.mail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ms.mail.entities.Email;


@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}