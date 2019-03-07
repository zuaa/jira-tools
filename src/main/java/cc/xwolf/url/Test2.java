package cc.xwolf.url;

import java.util.List;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;
 
 

public class Test2 {
    public static void main(String[] args) throws JiraException {

        BasicCredentials creds = new BasicCredentials("这里是用户名", "这里是密码");
        JiraClient jira = new JiraClient("http://jira.域名.com", creds);
        ExcelReader reader = ExcelUtil.getReader("C:\\Users\\zuac\\Documents\\文件名字.xlsx");
        List<List<Object>> readAll = reader.read();
         for (int j = 1; j < readAll.size(); j++) {//跳过第一行
             System.out.println(readAll.get(j));
             List item = readAll.get(j);
             Issue newIssue = jira.createIssue("YXZB", "Task")//项目的id 和 bug类型  
             .field(Field.SUMMARY, item.get(0))
             .field(Field.DESCRIPTION,  item.get(0))
             .field(Field.REPORTER, "xuping")
             .field(Field.ASSIGNEE,  item.get(1)) 
             .execute();
             System.out.println(newIssue );
         }
     }
   

}
