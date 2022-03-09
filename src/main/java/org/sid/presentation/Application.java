package org.sid.presentation;

import org.sid.aspects.SecurityContext;
import org.sid.metier.Imetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//les package a scanner
@ComponentScan(value = {"org.sid.metier","org.sid.aspects"})
public class Application {
    public static void main(String[] args) {
        SecurityContext.Authentication("root","1234",new String[]{"USER"});
        ApplicationContext context=new AnnotationConfigApplicationContext(Application.class);//on sepecifier la classe de config
        Imetier metier=context.getBean(Imetier.class);
        System.out.println("**************");
        System.out.println(metier.getClass().getName());
        System.out.println("***************");
        metier.process();
        System.out.println(metier.compute());

    }
}
