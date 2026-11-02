package com.MyOrg.Linkly.repository;

import com.MyOrg.Linkly.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom finder methods
    Optional<User> findByEmail(String email);
    List<User> findByFirstname(String firstname);
    List<User> findByFirstnameAndLastname(String firstname, String lastname);
    List<User> findByFirstnameContainingAndLastnameContaining(String firstname, String lastname);

    //JPQL -> @Query annotation
    @Query("SELECT u FROM User u WHERE u.email = :mail")
    Optional<User> searchByEmail(@Param("mail") String email);

    // Native Query -> SQL (According to the exact Database)
    @Query(
            value =
                    """
                    SELECT *
                    FROM users
                    ORDER BY
                    firstname ASC,
                    lastname ASC
                    """,
            nativeQuery = true)
    List<User> getAllUsers();
}
