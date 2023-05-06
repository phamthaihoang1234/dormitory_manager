    package com.example.dormitory_manager.Services;

    import com.example.dormitory_manager.entities.Role;

    import java.util.Optional;

    public interface RoleService {
        Optional<Role> findByName(String name);

        Role save(Role role);

        Iterable<Role> findAll();
    }
