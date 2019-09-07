package com.xianzhi.platform.webapp.controller.exception;

import com.xianzhi.platform.webapp.common.constant.Constant;
import com.xianzhi.platform.webapp.common.exception.api.IException;
import com.xianzhi.platform.webapp.common.rs.api.ServiceResponse;
import com.xianzhi.platform.webapp.exception.CommentsOverLimitException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/6 14:26
 */
@RestController
@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(RuntimeException.class)
    public ServiceResponse exceptionHandler(Exception e) {

        ServiceResponse response = new ServiceResponse();
        String code = UUID.randomUUID().toString();

        if (e instanceof IException) {
            response.setResultMessage(((IException)e).message());
            response.setResultCode(((IException)e).code());
        } else {
            response.setResultMessage(Constant.ERROR_MESSAGE);
            response.setResultCode(Constant.ERROR_CODE);
        }
        response.setErrorId(code);

        log.error(e.getMessage() + " code: " + code);

        return response;
    }

}
