package cc.xwolf.url;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;
import net.rcarz.jiraclient.Project;
 

public class Test1 {
    public static void main(String[] args) throws JiraException {
        BasicCredentials creds = new BasicCredentials("xuping", "aaaaaaaa");
        JiraClient jira = new JiraClient("http://jira.sinochemb2c.com", creds);
        Project re =   jira.getProject("YXZB");
        System.out.println(re); 
        Issue newIssue = jira.createIssue("YXZB", "Task")
        .field(Field.SUMMARY, "Bat signal is broken")
        .field(Field.DESCRIPTION, "Commissioner Gordon reports the Bat signal is broken.")
        .field(Field.REPORTER, "xuping")
        .field(Field.ASSIGNEE, "zhangran") 
        .execute();
    
    System.out.println(newIssue );
    }

}
