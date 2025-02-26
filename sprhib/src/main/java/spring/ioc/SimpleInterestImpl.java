package spring.ioc;

public class SimpleInterestImpl implements SimpleInterest {

	private Arithmetic arithmetic;
	
	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}
	
	@Override
	public int compute(int prin,int rate,int time) {
		return arithmetic.div(arithmetic.mul(prin, arithmetic.mul(rate, time)),100);
	}
}
