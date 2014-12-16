package com.sofans.service.sys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sofans.dao.sys.CommonDAO;
import com.sofans.entity.SofansSysModule;
import com.sofans.entity.SofansSysModuleAction;
import com.sofans.entity.SofansSysUser;
import com.sofans.entity.SofansSysUserRole;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	CommonDAO commonDAO;
	
	@Override
	// 登录验证
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		// 这里应该可以不用再查了
		@SuppressWarnings("unchecked")
		List<SofansSysUser> users = null;
		try {
			users = commonDAO.findByProperty("username", arg0, SofansSysUser.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SofansSysUser sufansSysUser = users.get(0);

		Collection<GrantedAuthority> grantedAuths = null;
		try {
			grantedAuths = obtionGrantedAuthorities(sufansSysUser);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean enables = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		// 封装成spring security的user
		User userdetail = new User(sufansSysUser.getName(),
				sufansSysUser.getPassword(), enables, accountNonExpired,
				credentialsNonExpired, accountNonLocked, grantedAuths);
		return userdetail;
	}

	// 取得用户的权限
	@SuppressWarnings("unchecked")
	private Set<GrantedAuthority> obtionGrantedAuthorities(SofansSysUser user) throws Exception {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		List<SofansSysModule> resources = new ArrayList<SofansSysModule>();
		List<SofansSysUserRole> roles = commonDAO.findByProperty("userid", (long)user.getId(), SofansSysUserRole.class);

		for (SofansSysUserRole role : roles) {
			List<SofansSysModuleAction> tempRes = commonDAO.findByProperty("roleid", (long)role.getId(), SofansSysModuleAction.class);
			for (SofansSysModuleAction res : tempRes) {
				resources.add((SofansSysModule)commonDAO.findById(res.getModuleid(), SofansSysModule.class));
			}
		}
		for (SofansSysModule res : resources) {
			authSet.add(new GrantedAuthorityImpl(res.getModulename()));
		}
		return authSet;
	}
}
