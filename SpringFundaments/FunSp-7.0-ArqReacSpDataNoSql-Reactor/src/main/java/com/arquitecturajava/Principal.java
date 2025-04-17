package com.arquitecturajava;

import java.time.Duration;

import reactor.core.publisher.Mono;

public class Principal {

	public static void main(String[] args) {
		//esto es un proceso asincrono
		//mono emite un elemento de forma asincrona
		//al añadir el delayElement esto se ejectua en otro thread 
		Mono<String> mono = Mono.just("Hola desde reactor").delayElement(Duration.ofSeconds(2));
		Mono<String> mono2 = Mono.just("Hola desde reactor2").delayElement(Duration.ofSeconds(4));
		
		//a este proceso asincrono me puedo suscribir
		mono.doOnNext((e)->System.out.println(Thread.currentThread().getName())).subscribe((e)->System.out.println(e));
		mono2.doOnNext((e)->System.out.println(Thread.currentThread().getName())).subscribe((e)->System.out.println(e));
		//el thread principal se ejectua en nada por lo que necesitamos hacerle un delay
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());//como podemos ver cada una se de las operaciones se realiza en su propio hilo
		System.out.println("termino el main");
	}
}
