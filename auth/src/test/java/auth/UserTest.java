package auth;

import com.yhb.auth.AuthApplication;
import com.yhb.auth.entity.dto.PermissionDTO;
import com.yhb.auth.entity.dto.RoleDTO;
import com.yhb.auth.entity.dto.UserDTO;
import com.yhb.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthApplication.class)
@EnableAutoConfiguration
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUser() {
//        Optional<UserDTE> userDOOptional = userRepository.findById(1L);
//        if (userDOOptional.isPresent()) {
//            UserDTE userDO = userDOOptional.get();
//            System.out.println("name = " + userDO.getName());
//        }

        UserDTO user = userService.findByName("yhb");
        log.info("用户信息=========: {}", user);
        for (RoleDTO role : user.getRoles()) {
            log.info("角色信息=========: {}", role);
            for (PermissionDTO permission : role.getPermissions()) {
                log.info("权限信息=========: {}", permission);
            }

        }
    }

}
