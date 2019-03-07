package cc.xwolf.url;

import java.util.List;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;
import net.rcarz.jiraclient.Project;
 

public class Test2 {
    public static void main(String[] args) throws JiraException {

        BasicCredentials creds = new BasicCredentials("xuping", "aaaaaaaa");
        JiraClient jira = new JiraClient("http://jira.sinochemb2c.com", creds);
        Project re =   jira.getProject("YXZB");
        System.out.println(re); 
       
    
    

        ExcelReader reader = ExcelUtil.getReader("C:\\Users\\zuac\\Documents\\集团总控系统项目计划.xlsx");
        List<List<Object>> readAll = reader.read();
         for (int j = 1; j < readAll.size(); j++) {
             System.out.println(readAll.get(j));
             List item = readAll.get(j);
             Issue newIssue = jira.createIssue("YXZB", "Task")
             .field(Field.SUMMARY, item.get(0))
             .field(Field.DESCRIPTION,  item.get(0))
             .field(Field.REPORTER, "xuping")
             .field(Field.ASSIGNEE,  item.get(1)) 
             .execute();
             System.out.println(newIssue );
         }
     }
   

}
