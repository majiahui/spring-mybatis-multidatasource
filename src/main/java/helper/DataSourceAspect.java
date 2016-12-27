package helper;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class DataSourceAspect {
	@Pointcut("execution(* service..*(..))")
	public void aspect() {
	}

	@Before("aspect()")
	public void doBefore(JoinPoint point) throws Throwable {
		final MethodSignature methodSignature = (MethodSignature) point.getSignature();
		Method method = methodSignature.getMethod();
		MzDataSource mzDataSource = method.getAnnotation(MzDataSource.class);
		if (method.getDeclaringClass().isInterface()) {
			method = point.getTarget().getClass().getMethod(method.getName(), method.getParameterTypes());
		}
		mzDataSource = method.getAnnotation(MzDataSource.class);
		if (null != mzDataSource) {
			DatabaseContextHolder.setDataSourceType(mzDataSource.value());
		}
	}

	@After("aspect()")
	public void doAfter() {
		DatabaseContextHolder.clearDataSourceKey();
	}
}
