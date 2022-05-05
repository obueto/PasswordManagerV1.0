//package services;
//
//import com.example.passwordmgtsystem.dtos.requests.RegisterUserDetails;
//import com.example.passwordmgtsystem.dtos.requests.UserDetailsRequests;
//import com.example.passwordmgtsystem.models.UserDetails;
//import com.example.passwordmgtsystem.repository.UserRepository;
//import com.example.passwordmgtsystem.services.UserService;
//import com.example.passwordmgtsystem.services.UserServiceImpl;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class UserServiceImplTest {
//    UserRepository userRepository;
//
//    @Test void  testThatUserDetailCanBeAdded(){
//        UserService addUserService = new UserServiceImpl();
//        UserDetailsRequests userDetailsRequests = new UserDetailsRequests();
//        userDetailsRequests.setEmail("jay@gmail.com");
//        userDetailsRequests.setUrlAddress("");
//        userDetailsRequests.setAppName("");
//        userDetailsRequests.setPassword("");
//
//        addUserService.register(userDetailsRequests);
//        assertEquals(1,addUserService.getRepository().count());
//
//
//    }
//}
