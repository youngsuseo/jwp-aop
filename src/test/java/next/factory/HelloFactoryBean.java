package next.factory;

import core.di.beans.factory.FactoryBean;
import next.hello.Hello;
import next.hello.HelloTarget;
import next.interceptor.UppercaseMethodInterceptor;
import next.wrapper.EnhancerWrapper;

public class HelloFactoryBean implements FactoryBean<Hello> {

    @Override
    public HelloTarget getObject() throws Exception {
        EnhancerWrapper enhancerWrapper = new EnhancerWrapper(HelloTarget.class, new UppercaseMethodInterceptor());
        return enhancerWrapper.create();
    }

    @Override
    public Class<Hello> getObjectType() {
        return Hello.class;
    }
}