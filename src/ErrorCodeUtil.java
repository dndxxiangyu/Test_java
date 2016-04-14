

public class ErrorCodeUtil {

	public static String inputErrorCode(int code){
		String temp = "";
		switch (code) {
		case -1:
			System.out.println("-1");
			break;

		default:
			break;
		}
		return temp;
	}
	public static void main(String[] args){
		inputErrorCode(-1);
	}
}
