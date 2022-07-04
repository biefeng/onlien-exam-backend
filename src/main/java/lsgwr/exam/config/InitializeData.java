package lsgwr.exam.config;

import lsgwr.exam.entity.Role;
import lsgwr.exam.enums.RoleEnum;
import lsgwr.exam.repository.RoleRepository;
import lsgwr.exam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitializeData {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public void initRole(){
        int i = 0;
        for (RoleEnum roleEnum : RoleEnum.values()) {
            Role role = new Role();
            role.setRoleId(role.getRoleId());
            role.setRoleDetail(roleEnum.getRole());

        }

    }
}
