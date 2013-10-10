package org.cdisource.springintegration;

import javax.enterprise.inject.spi.BeanManager;

import org.cdisource.beancontainer.BeanContainer;
import org.cdisource.beancontainer.BeanContainerManager;
import org.cdisource.beancontainer.BeanManagerLocator;

public class BeanManagerLocationUtil {

	private final String BEAN_MANAGER_LOCATION = "java:comp/BeanManager";
	private BeanManager beanManager;

	BeanManager beanManager() {
		if (this.beanManager!=null) {
			return this.beanManager;
		}
        BeanContainer beanContainer = BeanContainerManager.getInstance();
        this.beanManager = ((BeanManagerLocator) beanContainer)
                .getBeanManager();

		if (this.beanManager==null) {
			throw new IllegalStateException("BEAN MANAGER IS NULL");
		}
		return this.beanManager;

	}


}
