package ru.gb.Spring_HW12_Tests_Aspects_Integrations.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectChanger {

    @AfterReturning(value = "@annotation(Changer)", returning = "returnedValue")
    public void change(Object returnedValue) {
        System.out.println("Добавлена новая задача: " + returnedValue);
    }
}