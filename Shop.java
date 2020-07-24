package OOPTest;
interface DiscountRate{
	//SDP=Service Discount Premium
	//SDG=Service Discount Gold
	//SDS=Service Discount Silver
	final double SDP=0.2;
	final double SDG=0.15;
	final double SDS=0.1;
	//PDP=Product Discount Premium
    //PDG=Product Discount Gold
    //PDS=Product Discount Silver
	final double PDP=0.1;
	final double PDG=0.1;
	final double PDS=0.1;
	public double ServiceRate(String s) ;
	public double ProductRate(String s) ;
	
	
	
}
class Customer{
	String name;
	Boolean memb;
	String MType;
	Customer(String name,Boolean memb,String MType)
{     
		       this.name=name;
		       this.memb=memb;
		       this.MType=MType;
}
	public Boolean isMember() {
		return memb;
	
	}
	public String ShowC() {
		return " Name : "+name+"\n Member Type : "+MType;
	}
	}




public class Shop extends Customer implements DiscountRate {
	Customer c;
    int d;
    double ServiceE;
    double ProductE;
	Shop(Customer c,int d,double s,double p) {
		super(c.name,c.memb,c.MType);
		
		
		this.d=d;
		this.ServiceE=s;
		this.ProductE=p;
		
	}
	
	public static void main(String[] arg) {
		Customer c=new Customer("Mg Mg",true,"gold");
		System.out.println(c.ShowC());
		Shop s=new Shop(c,11,100,100);
		if(c.memb==true) {
//		s.ServiceRate(c.MType);
//		s.ProductRate(c.MType);
		double ans1=s.STexp(s.ServiceE,s.ServiceRate(c.MType));
		System.out.println("Total cost for service :"+ans1);
		double ans2=s.PTexp(s.ProductE,s.ProductRate(c.MType));
		System.out.println("Total cost for product :"+ans2);
		
		}else {
			System.out.println(c.ShowC());
			System.out.println("Sorry only members can get discount");
			System.out.println("Total cost for service : "+s.ServiceE);
			System.out.println("Total cost for product : "+s.ProductE);
			
		}
		
	}

	
	public double ServiceRate(String s) {
		double dis = 0;
		switch(s) {
		case"premium":dis=ServiceE*SDP;break;
		case"gold":dis=ServiceE*SDG;break;
		case"silver":dis=ServiceE*SDS;break;
		
		}
		return dis;
	
	}

	
	public double ProductRate(String s) {
		double dis=0;
		switch(s) {
		
		case"premium":dis=ProductE*PDP;break;
		case"gold":dis=ProductE*PDG;break;
		case"silver":dis=ProductE*PDS;break;
		}
	
		return dis;
	}
	public double STexp(double m,double d) {
		double tot=m-d;
	    return tot;
	}
	public double PTexp(double m,double d) {
		double tot=m-d;
	    return tot;
	}
  
    	
    
}
