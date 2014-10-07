/*
 * SURITTEC
 * Copyright 2014, SURITTEC CONSULTORIA LTDA, 
 * and individual contributors as indicated by the @authors tag
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package br.com.surittec.suricdi.example.util;

import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

import br.com.surittec.suricdi.faces.rewrite.provider.SecureHttpConfigurationProvider;

@RewriteConfiguration
public class RewriteConfigurationProvider extends SecureHttpConfigurationProvider {

	@Override
	public ConfigurationBuilder getConfigurationBuilder(final ServletContext context) {
		return ConfigurationBuilder.begin()
				
				.addRule(Join.path("/").to("/view/home.xhtml"))
				.addRule(Join.path("/403").to("/view/403.xhtml").withInboundCorrection())
				.addRule(Join.path("/404").to("/view/404.xhtml").withInboundCorrection())
				.addRule(Join.path("/500").to("/view/500.xhtml").withInboundCorrection())
				
		;
	}

}