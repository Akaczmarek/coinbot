package fr.afjg.coinbot.pojo.datatprocessing;

public class LineEquationTrend {

	private double leadingDirect;
	private double ordOrigin;
	private String typeBidOrAsk;	//"bid" or "ask"
	private String typeLine;		//"average" or "support" or "ceiling"
	private TrendCalculation trendCalculation;
	
	public LineEquationTrend() {
		
	}
	
	public LineEquationTrend(TrendCalculation trendCalculation,String typeBidOrAsk,String typeLine) {
		
	}
}
