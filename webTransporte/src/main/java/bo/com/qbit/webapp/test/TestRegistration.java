package bo.com.qbit.webapp.test;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.Test;
import bo.com.qbit.webapp.service.DataAccessService;

//The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class TestRegistration extends DataAccessService<Test> {

    public TestRegistration() {
        super(Test.class);
    }

}