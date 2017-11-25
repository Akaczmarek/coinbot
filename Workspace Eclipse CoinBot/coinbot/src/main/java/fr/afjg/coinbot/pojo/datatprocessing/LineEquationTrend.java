package fr.afjg.coinbot.pojo.datatprocessing;

public class LineEquationTrend implements Runnable {

	private double leadingDirect;
	private double ordOrigin;
	private String typeBidOrAsk;	//"bid" or "ask"
	private String typeLine;		//"average" or "support" or "ceiling"
	private TrendCalculation trendCalculation;
	
	public LineEquationTrend() {
		
	}
	
	public LineEquationTrend(TrendCalculation trendCalculation,String typeBidOrAsk,String typeLine) {
		
	}

	public double getLeadingDirect() {
		return leadingDirect;
	}

	public void setLeadingDirect(double leadingDirect) {
		this.leadingDirect = leadingDirect;
	}

	public double getOrdOrigin() {
		return ordOrigin;
	}

	public void setOrdOrigin(double ordOrigin) {
		this.ordOrigin = ordOrigin;
	}

	public String getTypeBidOrAsk() {
		return typeBidOrAsk;
	}

	public void setTypeBidOrAsk(String typeBidOrAsk) {
		this.typeBidOrAsk = typeBidOrAsk;
	}

	public String getTypeLine() {
		return typeLine;
	}

	public void setTypeLine(String typeLine) {
		this.typeLine = typeLine;
	}

	public TrendCalculation getTrendCalculation() {
		return trendCalculation;
	}

	public void setTrendCalculation(TrendCalculation trendCalculation) {
		this.trendCalculation = trendCalculation;
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
	}
	
	
}
