package peaksoft.peaksoft.spring_boot_security.repository;

import peaksoft.peaksoft.spring_boot_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.username=:username")
    User getUserByName(@Param("username") String username);
//    @Query("select u from User u where u.id=:id")
//    void updateUser(@Param("id") Long id,User user);

}
