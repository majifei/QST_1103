package No3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex3
 * 1. 编写代码完成以下功能：
 * 		a. 从access.log中读入数据，获取IP和Time
 * 		b. 输出在时间区间[beginTime, endTime]内的IP和Time，以tab分割
 * 2. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class FilterByTime {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = regularFormat.parse("2015-12-31 18:00:00");
		Date endDate = regularFormat.parse("2015-12-31 19:00:00");
		String filePath = "./access.log";
		FileInputStream inputStream = new FileInputStream(filePath);
		Scanner scanner = new Scanner(inputStream, "UTF-8");
		while (scanner.hasNext()) {
			// 对每行进行处理
			String line = scanner.nextLine();
			// 切分获取IP，Time

			Pattern time = Pattern.compile(
					"(((0[1-9]|[12][0-9]|3[01])/((0[13578]|1[02]))|((0[1-9]|[12][0-9]|30)/(0[469]|11))|(0[1-9]|[1][0-9]|2[0-8])/(02))/([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}))|(29/02/(([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00)))");
			Matcher mTime = time.matcher(line);

			

			String strTime = mTime.group(1);

			String[] strIp = line.split(" ");

			Date date = regularFormat.parse(strTime);
			// 对在时间区间内的数据进行输出
			if(endDate.getTime() > date.getTime() && date.getTime() > beginDate.getTime()) {

				System.out.println(strIp[0] + "\t" + date);

			}

		}
	}

}
