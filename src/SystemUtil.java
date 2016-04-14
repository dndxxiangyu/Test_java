
import java.math.BigInteger;

public class SystemUtil {
	public static final String OSNAME = System.getProperty("os.name");
	public static final String OSARCH = System.getProperty("os.arch");
	public static final String SEPARATOR = System.getProperty("file.separator");
	public static final String CURR_ENCODING = System
			.getProperty("file.encoding");
	public static final String LINE_SEPARATOR = System
			.getProperty("line.separator");
	public static final String CRLF = LINE_SEPARATOR; // Carriage Return/Line
	// Feed
	public static final String CRLF_LINUX = "\n";
	public static final String CHARSET_UTF = "UTF-8";
	public static final String CHARSET_GBK = "GBK";
	public static final String CHARSET_GB2312 = "GB2312";
	public static final String CHARSET_GB18030 = "GB18030";
	public static final String CHARSET_UNICODE = "UNICODE";
	public static final String CHARSET_ISO88591 = "ISO-8859-1";

	public static boolean isWindows = false;
	public static boolean isHP_UX = false;
	public static boolean isSolaris = false;
	public static boolean isOS32bit = true;
	public static final int BUFF_SIZE = 4096;
	public static final String KEY_ALGORITHM_RSA = "RSA";
	public final static String KEY_ALGORITHM_DES = "DES";
	public static final String KEY_ALGORITHM_SHA1withRSA = "SHA1withRSA";
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
	public static final String KEY_SHA = "SHA";
	public static final String KEY_SHA1 = "SHA-1";
	public static final String KEY_MD5 = "MD5";
	public static final String KEY_HMAC_SHA256 = "HMACSHA256";
	public static final String KEY_HMAC_SHA1 = "HmacSHA1";
	public static final String CERTIFICATEFACTORY_X509 = "X.509";
	public static final char[] HEXCHAR = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	public static BigInteger bigInt1 = BigInteger.valueOf(1l);
	public static final String CONTENTTYPE_HTML = "text/html";
	public static final String CONTENTTYPE_JSON = "application/json";
	public static final String CONTENTTYPE_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

	public static final String CONTENTTYPE_OCTET_STREAM = "application/octet-stream";

	public static final String PROCOTOL_HTTP = "http";
	public static final String PROCOTOL_HTTPS = "https";

	public static final int NEGATIVE_ONE = -1;
	public static final String EMPTY = "";
	static {
		if (SystemUtil.OSNAME.toLowerCase().contains("window")) {
			isWindows = true;
		}
		if (SystemUtil.OSNAME.toLowerCase().contains("hp-ux")) {
			isHP_UX = true;
		}
		if (SystemUtil.OSNAME.toLowerCase().contains("Solaris")) {
			isSolaris = true;
		}
		if (SystemUtil.OSARCH.contains("64")) {
			isOS32bit = false;
		}
	}

	private SystemUtil() {
		throw new Error("Don't let anyone instantiate this class.");
	}

	
}
