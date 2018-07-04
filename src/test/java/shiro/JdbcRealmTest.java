package shiro;


import javax.servlet.annotation.HandlesTypes;

import org.apache.catalina.Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Before;
import org.junit.Test;
import org.apache.shiro.mgt.SecurityManager;

import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;

public class JdbcRealmTest {
	 	
	@Test
	public void testAuthenticat() {
		
		Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:jdbc_realm.ini");
		 	
		//构建securityManager 环境
		SecurityManager securityManager =factory.getInstance();
		
		//主体提交验证
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("fix","123456");
		subject.login(token);		
		System.out.println("是否认证" + subject.isAuthenticated());
		
		 
	}

}
