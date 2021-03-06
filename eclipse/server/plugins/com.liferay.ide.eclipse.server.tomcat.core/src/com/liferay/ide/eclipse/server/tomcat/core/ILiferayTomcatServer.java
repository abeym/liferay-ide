/*******************************************************************************
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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
 *
 *******************************************************************************/

package com.liferay.ide.eclipse.server.tomcat.core;

import com.liferay.ide.eclipse.server.core.ILiferayServer;

import org.eclipse.jst.server.tomcat.core.internal.ITomcatServer;

/**
 * @author Greg Amerson
 */
@SuppressWarnings("restriction")
public interface ILiferayTomcatServer extends ILiferayServer, ITomcatServer
{

	/**
	 * Property which specifies the directory where liferay scans for
	 * autodeployment
	 */
	String PROPERTY_AUTO_DEPLOY_DIR = "autoDeployDir";

	String PROPERTY_AUTO_DEPLOY_INTERVAL = "autoDeployInterval";

	String PROPERTY_EXTERNAL_PROPERTIES = "externalProperties";

	String PROPERTY_MEMORY_ARGS = "memoryArgs";

	String PROPERTY_USER_TIMEZONE = "userTimezone";

	String getAutoDeployDirectory();

	String getAutoDeployInterval();

	String getExternalProperties();

	String getMemoryArgs();

	String getUserTimezone();

}
