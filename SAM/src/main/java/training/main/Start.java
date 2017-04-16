package training.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import training.objects.FileManager;

public class Start {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans\\context.xml");
//        SomeService someService = (SomeService) context.getBean("someService");
//        double val = someService.getDoubleValue();
//        System.out.println(val);

        FileManager fileUtil = (FileManager) context.getBean("fileManager");
        fileUtil.getExtensionCount("c:\\Windows\\System32");
        fileUtil.getExtensionCount("c:\\Windows\\");
        fileUtil.getExtensionList("c:\\Windows\\system32\\drivers");
    }
}
