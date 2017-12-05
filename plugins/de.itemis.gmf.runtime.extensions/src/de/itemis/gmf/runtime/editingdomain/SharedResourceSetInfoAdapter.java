/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.runtime.editingdomain;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

public class SharedResourceSetInfoAdapter extends AdapterImpl {

	private SharedResourceSetInfoDelegate sharedResourceSetInfoDelegate;

	@Override
	public boolean isAdapterForType(Object type) {
		return type == SharedResourceSetInfoDelegate.class;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		super.setTarget(newTarget);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(newTarget);
		if(editingDomain != null) {
			sharedResourceSetInfoDelegate = new SharedResourceSetInfoDelegate(editingDomain);
		}
	}
	
	@Override
	public void unsetTarget(Notifier oldTarget) {
		super.unsetTarget(oldTarget);
		sharedResourceSetInfoDelegate = null;
	}
	
	public SharedResourceSetInfoDelegate getSharedResourceSetInfoDelegate() {
		return sharedResourceSetInfoDelegate;
	}
	
	public static class Factory extends AdapterFactoryImpl {
		@Override
		public boolean isFactoryForType(Object type) {
			return type == SharedResourceSetInfoDelegate.class;
		}
		
		@Override
		protected Adapter createAdapter(Notifier target) {
			return new SharedResourceSetInfoAdapter();
		}
	}
}
