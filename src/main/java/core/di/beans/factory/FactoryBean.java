package core.di.beans.factory;

import next.hello.HelloTarget;

public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<T> getObjectType();
}