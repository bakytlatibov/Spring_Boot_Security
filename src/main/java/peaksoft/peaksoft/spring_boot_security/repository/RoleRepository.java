package peaksoft.peaksoft.spring_boot_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.peaksoft.spring_boot_security.entities.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("select r from Role  r where r.roleName=:name")
    Role getRoleByName(@Param("name")String name);

}
