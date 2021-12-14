package team.sb.resourceserver.domain.user.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import team.sb.resourceserver.domain.user.api.dto.UserInfoResponse;
import team.sb.resourceserver.domain.user.entity.User;
import team.sb.resourceserver.global.exception.AuthenticationNotFoundException;

@Service
public class UserService {

    public UserInfoResponse getUserInfo() {
        return new UserInfoResponse(getCurrentUser());
    }

    private User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!(principal instanceof UserDetails))
            throw AuthenticationNotFoundException.EXCEPTION;

        return (User) principal;
    }

}
