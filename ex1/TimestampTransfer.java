package No1;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少2016/11/11 11:11:11 to 1478833871000
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")
	public static void main(String[] args){//主函数
		Scanner scanner = new Scanner(System.in);//new 一个Scanner(System.in)，控制台会一直等待输入
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//新建日期的输入格式为yyyy-MM-dd HH:mm:ss
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//新建日期的输出格式为yyyy-MM-dd HH:mm:ss
		while (scanner.hasNext()){//循环，读取每一条输入的scanner
			String line = scanner.nextLine();//接受一行传给line
			Date lineDate = null;//定义日期 lineDate  值为null
			long lineTimestamp;// 定义 lineTimestamp 为 long型
			try {//捕获异常
				lineDate = inputFormat.parse(line);// 解析输入的line，并返回该日期与 1970 年 1 月 1 日午夜之间所间隔的毫秒数。
				lineTimestamp = lineDate.getTime();//得到lineDate的.getTime()，为long类型，传给lineTimestamp
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);//打印输出的linedate,lineTimestamp
			} catch (ParseException e) {//抛出异常
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
