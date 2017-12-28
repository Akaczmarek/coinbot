package fr.afgj.coinbot.calculation.impl;

public class LineEquationSupport extends LineEquation {

	
	public LineEquationSupport() {
		super();
		this.setName("Support");
	}
	
	@Override
	public void run() {

		// Stage 0 : calculation of equation 
		this.calculationSupportLineEquation();
		
		// stage 1 : save line equation
		this.getTrendNote().getLineEquations().add(this);
		
	}

}
