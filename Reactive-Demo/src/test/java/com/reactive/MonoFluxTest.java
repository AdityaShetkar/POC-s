package com.reactive;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class MonoFluxTest {

    @Test
    public void monoTest(){
        Mono<?> monoString = Mono.just("Adii")
                .then(Mono.error(new RuntimeException("Exception Occured")))
                .log();
        monoString.subscribe(System.out::println, (e)-> System.out.println(e.getMessage()));
    }

    @Test
    public void fluxTest(){
        Flux<String> fluxString = Flux.just("Spring", "SpringBoot", "Hibernate", "MicroServices")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception Occured in Flux")))
                .concatWithValues("Cloud")
                .log();
        fluxString.subscribe(System.out::println, (e)-> System.out.println(e.getMessage()));
    }
}