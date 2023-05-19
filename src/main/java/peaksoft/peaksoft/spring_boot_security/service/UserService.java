package peaksoft.peaksoft.spring_boot_security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.peaksoft.spring_boot_security.entities.Role;
import peaksoft.peaksoft.spring_boot_security.entities.User;
import peaksoft.peaksoft.spring_boot_security.repository.RoleRepository;
import peaksoft.peaksoft.spring_boot_security.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        Set<Role> rolesSet = new HashSet<>();
        user.setPassword(encoder.encode(user.getPassword()));
        rolesSet.add(roleRepository.getRoleByName(user.getRoleName().toUpperCase()));
        user.setRoles(rolesSet);
        userRepository.save(user);

    }

    public User getByName(String name) {
        return userRepository.getUserByName(name);

    }

    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    public void updateUser(Long id, User user, String roleName) {
        User user1 = userRepository.findById(id).get();
        user1.setUsername(user.getUsername());
        user1.setLastName(user.getLastName());
        user1.setAge(user.getAge());
        user1.setEmail(user.getEmail());
        Role role = roleRepository.getRoleByName(roleName);
        Set<Role> rolesSet = new HashSet<>();
        rolesSet.add(role);
        user1.setRoles(rolesSet);
        user1.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user1);

    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }


}
