package com.arquitecturajava;

import java.time.Duration;

import reactor.core.publisher.Flux;

public class Principal2 {

	public static void main(String[] args) {
		//el flux es una coleccion de elementos asincronos
		Flux<String> flux = Flux.just("Hola","desde","reactor").delayElements(Duration.ofSeconds(2));
		//a este proceso asincrono me puedo suscribir
		flux.doOnNext((e)->System.out.println(Thread.currentThread().getName())).subscribe((e)->System.out.println(e));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());//un flux no es ni siquiera un hilo son varios
		System.out.println("termino el main");
	}
}
