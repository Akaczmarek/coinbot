package fr.afjg.coinbot.pojo.datatprocessing;

import java.util.List;

public class LineEquationTrend implements Runnable {

	private double leadingDirect;
	private double ordOrigin;
	
	private PointXY averagePt1;
	private PointXY averagePt2;
	private String typeBidOrAsk;	//"bid" or "ask"
	private String typeLine;		//"average" or "support" or "ceiling"
	private TrendCalculation trendCalculation;
	private List<PointXY> ptList;
	
	public LineEquationTrend() {
		
	}
	
	public LineEquationTrend(TrendCalculation trendCalculation,String typeBidOrAsk,String typeLine, PointXY averagePt1,PointXY averagePt2,List<PointXY> ptList) {
		this.setTrendCalculation(trendCalculation);
		this.setTypeBidOrAsk(typeBidOrAsk);
		this.setTypeLine(typeLine);
		this.setAveragePt1(averagePt1);
		this.setAveragePt2(averagePt2);
		this.setPtList(ptList);
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
	

	public PointXY getAveragePt1() {
		return averagePt1;
	}

	public void setAveragePt1(PointXY averagePt1) {
		this.averagePt1 = averagePt1;
	}

	public PointXY getAveragePt2() {
		return averagePt2;
	}

	public void setAveragePt2(PointXY averagePt2) {
		this.averagePt2 = averagePt2;
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
	

	
	public List<PointXY> getPtList() {
		return ptList;
	}

	public void setPtList(List<PointXY> ptList) {
		this.ptList = ptList;
	}

	


	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("calcul équation lancé-----------------------------------------");
		
		//Stage 0 : variable initializing 
		double pt1X = this.getAveragePt1().getX();
		double pt1Y = this.getAveragePt1().getY();
		double pt2X = this.getAveragePt2().getX();
		double pt2Y = this.getAveragePt2().getY();
		
		
		//Stage 1 : calculation main equation line
		this.setOrdOrigin((pt1X * pt2Y - pt1Y * pt2X) / (pt1X - pt2X));
		
		double b = this.getOrdOrigin();
		
		this.setLeadingDirect((pt1Y - b) / pt1X);
		
		double a = this.getLeadingDirect();
		
		
		
		//Stage 2 : sort point list (the first point is highest point in relation to the line, the last point is the lowest point...) 
		List<PointXY> ptList = this.getPtList();
		
		

		
		//Stage 3 :correction equation for ceiling and support : change ordOrigin
		if ("ceiling".equals(this.getTypeLine())) {
			
			//Predicate<CurrencyRate> crPredicate = p -> p.getTimeRecord().getTime() < (ts1.getTime() - ts2.getTime());
			
			
		}else if ("support".equals(this.getTypeLine())) {
			
		}
		

		
		//Stage 3 :Save in list lineEquationTrend of trendCalculation
		
		this.getTrendCalculation().getLinesEquationsTrends().add(this);
		
		//Stage 4 : prevent it's finished
		
		this.getTrendCalculation().finishActionsChecked();
		
		System.out.println("calcul équation terminé ///////////////////////////////////////////");
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		
		
		
	}

	
	
	
	
	
	
}
