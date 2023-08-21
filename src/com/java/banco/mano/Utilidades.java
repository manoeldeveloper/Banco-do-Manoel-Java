package com.java.banco.mano;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utilidades {

	static NumberFormat valorFormatado = new DecimalFormat("R$ ##,##0.00");
	
	public static String doubleToString(double valor) {
		return valorFormatado.format(valor);
	}
	
}
