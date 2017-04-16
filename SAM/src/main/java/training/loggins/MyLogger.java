package training.loggins;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@Aspect
public class MyLogger {

    //    public void printValue(Object obj) {
//        System.out.println(obj);
//    }
//
//    public void init() {
//        System.out.println("init");
//    }
//
//    public void close(){
//        System.out.println("close");
//    }
    @Pointcut("execution(* *(..))")
    private void allMethods() {

    }

    ;

    @Around("allMethods() && @annotation(training.annotation.ShowTime)")
    public Object watchTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        System.out.println("method begin: " + joinPoint.getSignature().toShortString());
        Object outPut = null;

        for (Object object : joinPoint.getArgs()) {
            System.out.println("Param: " + object);
        }

        try {
            outPut = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("method end: " + joinPoint.getSignature().toShortString() + ", time=" + time + " ms");

        return outPut;
    }

    @AfterReturning(pointcut = "allMethods() && @annotation(training.annotation.ShowResult)", returning = "obj")
    public void print(Object obj) {
        System.out.println("Print info begin >>");

        if (obj instanceof Set) {
            Set set = (Set) obj;
            for (Object object : set) {
                System.out.println(object);
            }
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            for (Object object : map.keySet()) {
                System.out.println("key=" + object + ", " + map.get(object));
            }
        }
        System.out.println("Print info end <<");
        System.out.println();
    }
}
