package es.uvigo.ei.sing.mla.view.initiators;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Initiator;

public class SecurityInitiator implements Initiator {
	private final static Set<String> IGNORE_PAGES = new HashSet<String>();

	static {
		IGNORE_PAGES.add("/index.zul");
		IGNORE_PAGES.add("/signUp.zul");
	}

	@Override
	public void doInit(Page page, Map<String, Object> args) throws Exception {
		final String requestPath = page.getRequestPath();

		if (requestPath.equals("/logout.zul")) {
			final Session session = Sessions.getCurrent(false);
			
			if (session != null) {
				session.invalidate();
			}

			Executions.sendRedirect("/index.zul");
		} else 	if (!IGNORE_PAGES.contains(requestPath)) {
			final Session session = Sessions.getCurrent(false);
			
			if (session == null || !session.hasAttribute("user")) {
				Executions.sendRedirect("/index.zul");
			}
		}
	}
}
