package com.neal.mybatispractise.interceptor;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

@Intercepts({
	@Signature(type = StatementHandler.class, method ="parameterize", args=java.sql.Statement.class)
})
public class MyInterceptor implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("hha");
		Object proceed= invocation.proceed();
		return proceed;
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		Object wrap = Plugin.wrap(target, this);
		return wrap;
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}

}
