package tw.idv.cha102.g7.schedule.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ScheduleExceptionHandler {
// 測試中待開發

    @ExceptionHandler(ScheduleNotFoundException.class)
    public ResponseEntity<String> handle(ScheduleNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("ScheduleNotFoundException: " + exception.getMessage());
    }
}
