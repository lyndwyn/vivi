package ch.zhaw.vivi.webContext.domain.user;





/**
 * This class implements an additional layer of logic to the traditional entity
 * user.
 *
 * @author Yves Kaufmann
 */
public class UserDetailsImpl /*implements UserDetails*/ {
	/*
	private User user;
	
	/**
	 *
	 *//*
	public UserDetailsImpl() {
		super();
	}
	
	/**
	 * @param user
	 *//*
	@Autowired
	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}
	
	/**
	 * {@inheritDoc}
	 *//*
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Role role : user.getRoles()) {
			for (Authority authority : role.getAuthorities()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
			}
		}
		return grantedAuthorities;
	}
	
	/*
	ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Role role : user.getRoles()) {
			for (Authority authority : role.getAuthorities()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
			}
		}
		return grantedAuthorities;
	*/
	
	/**
	 * {@inheritDoc}
	 *//*
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	/**
	 * {@inheritDoc}
	 *//*
	@Override
	public String getUsername() {
		return user.getUsername();
	}
	
	/**
	 * {@inheritDoc}
	 *//*
	@Override
	public boolean isAccountNonExpired() {
		// TODO implement account expired check
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 *//*
	@Override
	public boolean isAccountNonLocked() {
		return !user.isLocked();
	}
	
	/**
	 * {@inheritDoc}
	 *//*
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO implement credentials expired check
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 *//*
	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}
	
	/**
	 * @return the user
	 *//*
	public User getUser() {
		return user;
	}
	
	/**
	 * @param user the user to set
	 *//*
	public void setUser(User user) {
		this.user = user;
	}*/
}
