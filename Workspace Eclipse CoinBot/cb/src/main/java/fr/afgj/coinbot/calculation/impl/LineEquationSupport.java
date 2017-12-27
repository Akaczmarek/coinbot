package fr.afgj.coinbot.calculation.impl;

public class LineEquationSupport extends LineEquation {

	@Override
	public void run() {

		// Stage 0 : calculation of equation 
		this.calculationSupportLineEquation();
		
		// stage 1 : save line equation
		this.getTrendNote().getLineEquations().add(this);
		
	}

}
