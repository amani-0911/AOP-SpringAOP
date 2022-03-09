package org.sid.metier;

import org.sid.aspects.Log;
import org.sid.aspects.SecuredByAspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ImetierImpl implements Imetier {
    @Override
    @Log
    @SecuredByAspect(roles={"USER"})
    public void process() {
        System.out.println("Business Process .......");
    }
    @Log
    @Override
    @SecuredByAspect(roles={"ADMIN"})
    public double compute() {

        double data=80;
        System.out.println("Business Computing .....");
        return data;
    }
}
