package com.leftxmas.streampocwithkafka;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    private final GreetingsService greetingsService;

    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @GetMapping("/greetings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void greetings(@RequestParam("message") String message) {
        for (int i = 0; i < 100; i++) {
            Greetings greetings = Greetings.builder()
                    .message(message + i)
                    .timestamp(System.currentTimeMillis())
                    .build();

            greetingsService.sendGreeting(greetings);
        }
    }
}
