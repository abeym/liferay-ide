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
 * Contributors:
 *               Kamesh Sampath - initial implementation
 *******************************************************************************/

package com.liferay.ide.eclipse.portlet.core.model;

import org.eclipse.sapphire.java.JavaType;
import org.eclipse.sapphire.java.JavaTypeConstraint;
import org.eclipse.sapphire.java.JavaTypeKind;
import org.eclipse.sapphire.java.JavaTypeName;
import org.eclipse.sapphire.modeling.IModelElement;
import org.eclipse.sapphire.modeling.ListProperty;
import org.eclipse.sapphire.modeling.ModelElementList;
import org.eclipse.sapphire.modeling.ModelElementType;
import org.eclipse.sapphire.modeling.ReferenceValue;
import org.eclipse.sapphire.modeling.Value;
import org.eclipse.sapphire.modeling.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.CountConstraint;
import org.eclipse.sapphire.modeling.annotations.GenerateImpl;
import org.eclipse.sapphire.modeling.annotations.Image;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Reference;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.modeling.xml.annotations.XmlListBinding;

/**
 * @author <a href="mailto:kamesh.sampath@accenture.com">Kamesh Sampath</a>
 */
@GenerateImpl
@Image( path = "images/elcl16/filter_16x16.gif" )
public interface IFilter extends IModelElement, IDescribeable, IDisplayable {

	ModelElementType TYPE = new ModelElementType( IFilter.class );

	// *** Name ***

	@Label( standard = "name" )
	@Required
	@XmlBinding( path = "filter-name" )
	ValueProperty PROP_NAME = new ValueProperty( TYPE, "Name" );

	Value<String> getName();

	void setName( String value );

	// *** Implementation ***

	@Type( base = JavaTypeName.class )
	@Reference( target = JavaType.class )
	@Label( standard = "implementation class", full = "Filter implementation class" )
	@Required
	@JavaTypeConstraint( kind = JavaTypeKind.CLASS, type = { "javax.portlet.filter.ResourceFilter",
		"javax.portlet.filter.RenderFilter", "javax.portlet.filter.ActionFilter", "javax.portlet.filter.EventFilter" } )
	@XmlBinding( path = "filter-class" )
	ValueProperty PROP_IMPLEMENTATION = new ValueProperty( TYPE, "Implementation" );

	ReferenceValue<JavaTypeName, JavaType> getImplementation();

	void setImplementation( String value );

	void setImplementation( JavaTypeName value );

	// *** LifeCycle ***

	@Type( base = ILifeCycle.class )
	@Label( standard = "lifecycle" )
	@CountConstraint( min = 1 )
	@XmlListBinding( mappings = @XmlListBinding.Mapping( element = "lifecycle", type = ILifeCycle.class ) )
	ListProperty PROP_LIFE_CYCLE = new ListProperty( TYPE, "LifeCycle" );

	ModelElementList<ILifeCycle> getLifeCycle();

	// *** InitParams ***

	@Type( base = IParam.class )
	@Label( standard = "initialization parameters" )
	@XmlListBinding( mappings = @XmlListBinding.Mapping( element = "init-param", type = IParam.class ) )
	ListProperty PROP_INIT_PARAMS = new ListProperty( TYPE, "InitParams" );

	ModelElementList<IParam> getInitParams();

}
