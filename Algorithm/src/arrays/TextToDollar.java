package arrays;

public class TextToDollar {

	private static final String _0 = "ZERO";
	private static final String _100 = "Hundred";
	private static final String CODE = "DOLLARS";
	private static final String[] _1_TO_9 = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
	private static final String[] _11_TO_19 = {"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	private static final String   _10 = "Ten";
	private static final String[] _HIGHER_DIGIT = {"","THOUSAND","MILLION"};
	
	
	private static String printDollarToText(String s){
		if(s.equals("0")){
			return _0 + " "+CODE;
		}
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
//		while(){
//			
//		}
		return null;
	}
	
	
	
	public static void main(String[] args) {
		printDollarToText("1234");

	}

}
