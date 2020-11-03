package com.github.ioridazo.asyncsample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class AsyncController {

    private final AsyncService service;

    public AsyncController(final AsyncService service) {
        this.service = service;
    }

    @GetMapping("/async")
    public String async() {
        // firstを実行
        service.executeFirst()
                // firstが完了したらsecondを実行
                .thenAcceptAsync(unused -> service.executeSecond()
                        // secondとotherが完了したら
                        .thenAcceptBoth(service.executeOther(),
                                // lastを実行
                                (unused1, unused2) -> service.executeLast()));
        return "";
    }
}
