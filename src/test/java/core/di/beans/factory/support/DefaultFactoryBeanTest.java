package core.di.beans.factory.support;

import core.di.beans.factory.FactoryBean;
import next.hello.HelloTarget;
import next.interceptor.UppercaseMethodInterceptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DefaultFactoryBeanTest {

    @DisplayName("DefaultBeanFactory를 생성한다.")
    @Test
    void construct() throws Exception {
        DefaultFactoryBean defaultFactoryBean = new DefaultFactoryBean(HelloTarget.class, new UppercaseMethodInterceptor());
        Object object = defaultFactoryBean.getObject();
        assertThat(object).isNotNull();
    }
}