package fr.afjg.coinbot.entity.datatprocessing;

public class LastTrend {
	
	
	private String trend; // return up or down
	private PointXY lastPt;
	private PointXY otherPt;
	private double leadingDirect;
	private double ordOrigin;
	private TrendCalculation trendCalculation;
	private boolean validityTrend;
	
	public LastTrend(TrendCalculation trendCalculation,PointXY lastPt,PointXY otherPt, String trend) {
		this.setTrendCalculation(trendCalculation);
		this.setLastPt(lastPt);
		this.setOtherPt(otherPt);
		this.setTrend(trend);
		this.calculingEquationLastTrend();
		this.checkTrend();
		
	}

	//getters & setters----------------------------------------------------------
	
	public String getTrend() {
		return trend;
	}

	public void setTrend(String trend) {
		this.trend = trend;
	}

	public PointXY getLastPt() {
		return lastPt;
	}

	public void setLastPt(PointXY lastPt) {
		this.lastPt = lastPt;
	}

	public PointXY getOtherPt() {
		return otherPt;
	}

	public void setOtherPt(PointXY otherPt) {
		this.otherPt = otherPt;
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

	public TrendCalculation getTrendCalculation() {
		return trendCalculation;
	}

	public void setTrendCalculation(TrendCalculation trendCalculation) {
		this.trendCalculation = trendCalculation;
	}
	
	public boolean isValidityTrend() {
		return validityTrend;
	}

	public void setValidityTrend(boolean validityTrend) {
		this.validityTrend = validityTrend;
	}

	
	
	// methods-----------------------------------------------------------------
	

	public void calculingEquationLastTrend () {
		
		double pt1X = this.getLastPt().getX();
		double pt1Y = this.getLastPt().getY();
		double pt2X = this.getOtherPt().getX();
		double pt2Y = this.getOtherPt().getY();
		
		// parameters of line equation last trend
		this.setOrdOrigin((pt1X * pt2Y - pt1Y * pt2X) / (pt1X - pt2X));
		
		double b = this.getOrdOrigin();
		
		this.setLeadingDirect((pt1Y - b) / pt1X);
		
		
		
	}
	
	public void checkTrend() {
		
		double a = this.getLeadingDirect();
		
		if (a>0 && "up".equals(this.getTrend())) {
			
			this.setValidityTrend(true);
			
		}else if (a<0 && "down".equals(this.getTrend())){
			
			this.setValidityTrend(true);
			
		}else {
			
			this.setValidityTrend(false);
		}
		
		System.out.println("dernière tendance a = " + this.getLeadingDirect() + " , b = " + this.getOrdOrigin() + " , validité :" + this.isValidityTrend());
	}
	
	

}
