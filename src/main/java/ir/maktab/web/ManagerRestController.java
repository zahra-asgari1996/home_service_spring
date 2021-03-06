package ir.maktab.web;


import ir.maktab.dto.*;
import ir.maktab.service.OfferService;
import ir.maktab.service.OrderService;
import ir.maktab.service.UserService;
import ir.maktab.service.exception.NotFoundOrderException;
import ir.maktab.service.exception.NotFoundUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/managerRestController")
@RestController
public class ManagerRestController {
    private final OrderService orderService;
    private final OfferService offerService;
    private final UserService userService;

    public ManagerRestController(OrderService orderService, OfferService offerService, UserService userService) {
        this.orderService = orderService;
        this.offerService = offerService;
        this.userService = userService;
    }

    @PostMapping(value = "/filterOrders",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> filterOrders(@RequestBody @Valid OrderHistoryFilterDto dto)
            throws NotFoundOrderException {
        List<OrderDto> list = orderService.filterOrders(dto);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/filterUserOrders",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> filterUserOrders(@RequestBody @Valid UserOrdersFilterDto dto) throws NotFoundOrderException {
        List<OrderDto> list = orderService.filterUserOrders(dto);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/filterUsers",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> filterUsers(@RequestBody @Valid UserHistoryDto dto) throws NotFoundUserException {
        List<UserDto> list = userService.userHistory(dto);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<Object> bindExceptionHandler(BindException ex) {
        List<String> validationErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            validationErrors.add(error.getField() + ": " + error.getDefaultMessage());
        });
        ApiErrorDto dto = new ApiErrorDto(HttpStatus.BAD_REQUEST, ex.getClass().getName(), validationErrors);
        return new ResponseEntity<>(dto, dto.getStatus());
    }

    @ExceptionHandler(value = {NotFoundOrderException.class,NotFoundUserException.class})
    public ResponseEntity <?> exceptionHAndler(Exception e){
        List<String> exceptions = new ArrayList<>();
        exceptions.add(e.getMessage());
        ApiErrorDto dto = new ApiErrorDto(HttpStatus.INTERNAL_SERVER_ERROR,e.getClass().getName(),exceptions);
        return new ResponseEntity<>(dto,dto.getStatus());

    }



}
