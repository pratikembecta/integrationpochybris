/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratoraddon.interceptors;


import de.hybris.platform.acceleratorstorefrontcommons.interceptors.BeforeViewHandler;
import de.hybris.platform.b2bacceleratoraddon.constants.B2bacceleratoraddonConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;


public class B2BAcceleratorAddonBeforeViewHandler implements BeforeViewHandler
{

	public static final String VIEW_NAME_MAP_KEY = "viewName";
	private Map<String, Map<String, String>> viewMap;

	@Override
	public void beforeView(final HttpServletRequest request, final HttpServletResponse response, final ModelAndView modelAndView)
	{
		final String viewName = modelAndView.getViewName();
		if (viewMap.containsKey(viewName))
		{
			modelAndView.setViewName(B2bacceleratoraddonConstants.ADDON_PREFIX + viewMap.get(viewName).get(VIEW_NAME_MAP_KEY));
		}
	}

	public Map<String, Map<String, String>> getViewMap()
	{
		return viewMap;
	}

	public void setViewMap(final Map<String, Map<String, String>> viewMap)
	{
		this.viewMap = viewMap;
	}

}
