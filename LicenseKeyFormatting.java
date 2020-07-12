
public class LicenseKeyFormatting {
	public static void main(String[] args) {
		String S = "2-5g-3-J";
		int K = 2;
		System.out.println(licensekey(S,K));
	}
	
	public static String licensekey(String S, int K) {
		S = S.replace("-","").toUpperCase();
	    int t = S.length()/K;
	    int firstLength = S.length() - t*K;
	    int j = 0;
	    String ans = "";
	    if (firstLength>0) {
	    	ans+=S.substring(0,firstLength);
	    	ans+="-";
	    	j+=firstLength;
	    }
	    for (int i=0;i<t;i++) {
	    	if (i==t-1) {
	    		ans+=S.substring(j,j+K);
	    	}
	    	else {
	    		ans+=S.substring(j,j+K);
		    	ans+="-";
		    	j+=K;
	    	}
	    }
	    return ans;
	}

}
