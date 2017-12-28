package fr.afgj.coinbot.calculation.impl;

public class LineEquationCeiling extends LineEquation {

	public LineEquationCeiling() {
		super();
		this.setName("Ceiling");
	}
	
	@Override
	public void run() {
	
		// Stage 0 : calculation of equation 
		this.calculationCeilingLineEquation();
		
		// stage 1 : save line equation
		this.getTrendNote().getLineEquations().add(this);
		
	}



}
