package next.hello;

import java.lang.reflect.Method;

@FunctionalInterface
public interface MethodMatcher {
    boolean matches(Method method, Class<?> targetClass, Object[] args);
}
