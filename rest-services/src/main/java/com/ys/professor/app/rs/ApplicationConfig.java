package com.ys.professor.app.rs;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;


/**
 * Created by rob on 1/15/15.
 */
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig () {
        register(RequestContextFilter.class);
        register(QuestionServiceBean.class);
    }

}
