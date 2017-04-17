package training.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import training.objects.FileManager;
import training.objects.FileManager2;

public class Start {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans\\context.xml");
//        SomeService someService = (SomeService) context.getBean("someService");
//        double val = someService.getDoubleValue();
//        System.out.println(val);

        FileManager fileUtil = (FileManager) context.getBean("fileManager");
        FileManager2 fileUtil2 = (FileManager2) context.getBean("fileManager2");
        fileUtil.getExtensionCount("c:\\Windows\\System32");
        fileUtil.getExtensionCount("c:\\Windows\\");
        fileUtil.getExtensionList("c:\\Windows\\system32\\drivers");

        fileUtil2.getExtensionCount("c:\\Windows");
    }
}
