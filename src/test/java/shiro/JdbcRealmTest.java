package shiro;


import javax.servlet.annotation.HandlesTypes;

import org.apache.catalina.Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class JdbcRealmTest {
	 	
	@Test
	public void testAuthenticat() {
		
		JdbcRealm jdbcRealm =new JdbcRealm();
		
		//构建securityManager 环境
		DefaultSecurityManager securityManager =new DefaultSecurityManager();
		securityManager.setRealm(jdbcRealm);
		//主体提交验证
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("liubo","888888");
		subject.login(token);		
		System.out.println("是否认证" + subject.isAuthenticated());
		
		 
	}

}
