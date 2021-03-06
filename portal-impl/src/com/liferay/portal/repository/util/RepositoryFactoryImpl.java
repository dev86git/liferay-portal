/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.repository.util;

import com.liferay.portal.kernel.repository.BaseRepository;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.ProxyFactory;
import com.liferay.portal.repository.proxy.BaseRepositoryProxyBean;

/**
 * @author Mika Koivisto
 */
public class RepositoryFactoryImpl implements RepositoryFactory {

	public RepositoryFactoryImpl(String className) {
		_className = className;
	}

	public RepositoryFactoryImpl(String className, ClassLoader classLoader) {
		_classLoader = classLoader;
		_className = className;
	}

	@Override
	public BaseRepository getInstance() throws Exception {
		if (_classLoader == null) {
			return (BaseRepository)InstanceFactory.newInstance(_className);
		}
		else {
			BaseRepository baseRepository =
				(BaseRepository)ProxyFactory.newInstance(
					_classLoader, BaseRepository.class, _className);

			return new BaseRepositoryProxyBean(baseRepository, _classLoader);
		}
	}

	private ClassLoader _classLoader;
	private String _className;

}