import java.math.*;

public class MathCalc {
	
	public String convertToBinary(int intobj) {
		String s = "";
		String pad = "00000000";
		
		s = (Integer.toBinaryString(intobj));

			if (s.length() < 8)
			s = pad.substring(0, 8 - s.length()) + s;
		return s;
	}

	
	public int[] convertToInt(String s) {
		int len = 0, inparr[];
		len = s.length();
		inparr = new int[len];
		for (int i = 0; i < len; i++) {
			inparr[i] = Integer.parseInt(s.substring(i, i + 1));
		}
		return inparr;
	}

	
	public int[] exOr(int[] a, int[] b, int len) {
		int[] c = new int[len];
		for (int i = 0; i < len; i++) {
			c[i] = a[i] ^ b[i];
		}
		return c;
	}

	public int convertBinToInt(int[] block, int len) {
		int ans = 0;
		for (int i = (len - 1), j = 0; i >= 0; i--, j++) {
			if (block[j] == 1) {
				ans = ans + (int) (Math.pow(2, (double) i));
			}
		}
		return ans;
	}
	public int[] toShiftLeft(int[] arr, int sh) {
		int[] tarr = new int[28];
		for (int i = 27, j = 27 - sh; i >= sh; i--, j--) {
			tarr[j] = arr[i];
		}
		tarr[27] = arr[0];

		if (sh == 2) {
			tarr[26] = arr[0];
			tarr[27] = arr[1];
		}
		return tarr;
	}
}
