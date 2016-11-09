package No4;

import java.util.Scanner;

public class MapperOfIPFilter {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext())

		{
			String line = s.nextLine();
			String[] tt;
			tt = line.split(" ");// 切

			String str = tt[3];// 去[

			System.out.printf("%s\t%s\n", tt[0], str.substring(1, str.length()));// 截取第一个到.length长度个字符

		}
	}
}
