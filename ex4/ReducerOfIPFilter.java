package No4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ReducerOfIPFilter {
	public static void main(String[] args) throws ParseException {

		String key;
		String value;
		Set<String> set = new HashSet<String>();
		@SuppressWarnings("resource")
		// Scanner 负责从System.in中读入
		Scanner sc;
		sc = new Scanner(System.in);
		SimpleDateFormat regularFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss");
		// 是这样输入吗？
		Date beginDate = regularFormat.parse("30/Dec/2015:00:02:09");
		Date endDate = regularFormat.parse("31/Dec/2015:00:02:09");

		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] val = line.split("\t");
			key = val[1];// time
			value = val[0];// ip
			Date date = regularFormat.parse(key);// strong转data
			if (endDate.getTime() > date.getTime() && date.getTime() > beginDate.getTime()) {
				// ip去重

				set.add(value);

			}

		}

		System.out.println(set.size());
	}
}
