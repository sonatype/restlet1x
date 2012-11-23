# Sonatype Restlet1x

This repository holds an ancient Restlet 1.1.x that is patched here and there for needs of Nexus.

## Releasing it

Is manual process and is a bit labourous. Steps needed (starting from the root of repo):

```
[cstamas@zaphod restlet1x (master)]$ cd restlet-1.1.6-5346-sonatype/build/
[cstamas@zaphod build (master)]$ edit build.properties // set release-number to what needed
[cstamas@zaphod build (master)]$ ant
...
BUILD SUCCESSFUL
Total time: 1 minute 30 seconds
[cstamas@zaphod build (master)]$
```

Then go to RSO, Repositories tab and _manually_ upload neede JARs and generated POMs into "3rd party" repository, 
using Artifact Upload tab. GAV definition comes from POM, and select JAR.

Location of them, after successful build are:

POMs: `restlet-1.1.6-5346-sonatype/build/temp/poms`

JARs: `restlet-1.1.6-5346-sonatype/build/dist/classic/restlet-1.1.6-SONATYPE-5348-V5/lib`

List of Artifacts (artifactId's) you need to deploy:

* org.restlet
* org.restlet.ext.fileupload_1.2
* org.restlet.ext.jaxrs_1.0
* org.restlet.ext.velocity_1.5
* org.restlet.ext.wadl_1.0 (unused by latest Nexus 2.3 but in case of older fix needed)
* com.noelios.restlet
* com.noelios.restlet.ext.httpclient_3.1
* com.noelios.restlet.ext.jetty_6.1
* com.noelios.restlet.ext.servlet_2.5

Finally, after "deploy", tag the stuff you did:

```
[cstamas@zaphod build (master)]$ git tag -a -m "V5 release of Restlet 1.1.x patch"
[cstamas@zaphod build (master)]$ git push --tags"
```


Have fun!
Sonatype Team
