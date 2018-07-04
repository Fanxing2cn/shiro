package shiro;


import javax.servlet.annotation.HandlesTypes;

import org.apache.catalina.Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {
	
	//认证数据
	SimpleAccountRealm realm = new SimpleAccountRealm();
	
	@Before
	public void addUser() {
		realm.addAccount("fix", "123456");
		realm.addAccount("pymm", "888888","admin");
	}
	
	@Test
	public void testAuthenticat() {
		//构建securityManager 环境
		DefaultSecurityManager securityManager =new DefaultSecurityManager();
		securityManager.setRealm(realm);
		//主体提交验证
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("pymm","888888");
		subject.login(token);		
		System.out.println("是否认证" + subject.isAuthenticated());
		
		//检查权限
		subject.checkRole("admin");
		
//		subject.checkRoles("admin","user");
		
//		subject.logout();
//		System.out.println("是否认证" + subject.isAuthenticated());
	}

}
