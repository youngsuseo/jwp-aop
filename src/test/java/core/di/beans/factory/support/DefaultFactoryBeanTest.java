package core.di.beans.factory.support;

import core.di.beans.factory.FactoryBean;
import core.di.context.annotation.AnnotatedBeanDefinitionReader;
import core.di.factory.example.ExampleConfig;
import core.di.factory.example.HelloConfig;
import next.factory.HelloFactoryBean;
import next.hello.HelloTarget;
import next.interceptor.UppercaseMethodInterceptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

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

    @Test
    void register_simple() throws Exception {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();
        BeanDefinitionReader abdr = new AnnotatedBeanDefinitionReader(beanFactory);
        abdr.loadBeanDefinitions(HelloConfig.class);
        beanFactory.preInstantiateSingletons();

        HelloFactoryBean bean = beanFactory.getBean(HelloFactoryBean.class); // FIXME 빈 등록이 문제가 있다 -> bean으로 등록되어야하는데, 뭔가 object가 등록????
        assertThat(bean).isNotNull();
        Object object = bean.getObject();
        assertThat(object).isNotNull();
    }
}