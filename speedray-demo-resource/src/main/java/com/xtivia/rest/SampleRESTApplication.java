package com.xtivia.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.*;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.api.impl.BookApiImpl;
import io.swagger.api.impl.PeopleApiImpl;
import io.swagger.api.impl.UsersApiImpl;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import io.swagger.annotations.Api;

/*
 * A sample application to demonstrate implementing a JAX-RS endpoint in DXP
 */
@Component(immediate=true,
           service=Application.class,
           configurationPid = "com.xtivia.rest.SampleRESTConfiguration",
           configurationPolicy = ConfigurationPolicy.OPTIONAL,
           property={"jaxrs.application=true"}
)
@ApplicationPath("/samples")
@Api("Samples for JAX-RS in Liferay 7 OSGI")
public class SampleRESTApplication extends Application {
	/*
	 * This method demonstrates how you can perform logic when your bundle is activated/updated. For simplicity's
	 * sake we print a message to the console--this is particularly useful during update-style deployments.
	 *
	 * This method will also be invoked when the OSGi configuration changes for this bundle and we reflect that
	 * by printing out the current value of our configuration object.
	 */
	@Activate
	@Modified
	public void activate(Map<String, Object> properties) {

		System.out.println("The sample DXP REST app has been activated/updated at " + new Date().toString());

		/*
		 * Demonstrate updates to the configuration object for this bundle.
		 */

		_sampleRESTConfiguration = ConfigurableUtil.createConfigurable(SampleRESTConfiguration.class, properties);

		if (_sampleRESTConfiguration != null) {
			System.out.println("For sample DXP REST config, info="+_sampleRESTConfiguration.info());
			System.out.println("For sample DXP REST config, infoNum="+_sampleRESTConfiguration.infoNum());
		} else {
			System.out.println("The sample DXP REST config object is not yet initialized");
		}

		// Clear list for modify action
		_singletons.clear();

		//add the automated Jackson marshaller for JSON
		_singletons.add(new JacksonJsonProvider());

		// add our REST endpoints (resources)
		_singletons.add(new PeopleApiImpl());
		_singletons.add(new UsersApiImpl());
		_singletons.add(new BookApiImpl());
	}

    @Override
    public Set<Object> getSingletons() {
        return _singletons;
    }

    private Set<Object> _singletons = new HashSet<Object>();
	private SampleRESTConfiguration _sampleRESTConfiguration;
    private static final Log log = LogFactoryUtil.getLog(SampleRESTApplication.class);
}
