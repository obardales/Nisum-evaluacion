package com.nisum.obardales.resource;

import com.nisum.obardales.exception.ExceptionController;
import com.nisum.obardales.resource.request.RequestPostUsers;
import com.nisum.obardales.resource.response.ResponseGetUsers;
import com.nisum.obardales.resource.response.ResponsePostUsers;
import com.nisum.obardales.service.UserService;
import com.nisum.obardales.service.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(value = "Usuarios", tags = { "users" })
@RestController
@RequestMapping("/users")
public class UsersController {

    private Logger logger = LoggerFactory.getLogger(UsersController.class);
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Crea un Usuario", response = ResponsePostUsers.class)
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePostUsers> save(@RequestBody RequestPostUsers request) {


        UserDto userDto = request.toUser();

        this.userService.userRegister(userDto);
        logger.info(userDto.toString());

        ResponsePostUsers response = new ResponsePostUsers(userDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResponseGetUsers>> get() {

        List<UserDto> usersDto = this.userService.getAll();

        List<ResponseGetUsers> response = usersDto.stream()
                .map(ResponseGetUsers::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

}
