package com.crazybookings.operations;

import static org.junit.Assert.*;

import org.junit.Test;

import com.crazybookings.operations.Suma;

public class SumaTest {

	   @Test
	   public void sumaPositivos() {
	      System.out.println("Sumando dos n�meros positivos ...");
	       Suma S = new Suma(2, 3);
	       assertTrue(S.sumar() == 5);
	   }

	   @Test
	   public void sumaNegativos() {
	       System.out.println("Sumando dos n�meros negativos ...");
	       Suma S = new Suma(-2, -3);
	       assertTrue(S.sumar() == -5);
	   }

	   @Test
	   public void sumaPositivoNegativo() {
	       System.out.println("Sumando un n�mero positivo y un n�mero negativo ...");
	       Suma S = new Suma(2, -3);
	       assertTrue(S.sumar() == -1);
	   }

}
