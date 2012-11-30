# Sonatype Restlet1x

This repository holds an ancient Restlet 1.1.x that is patched here and there for needs of Nexus.

## Releasing it

Is manual process and is a bit labourous. Steps needed (starting from the root of repo):

```
[cstamas@zaphod restlet1x (master)]$ cd restlet-1.1.6-5346-sonatype/build/
[cstamas@zaphod build (master)]$ edit build.properties // set release-number to what needed
[cstamas@zaphod build (master)]$ ant -Dmaven=true
...
BUILD SUCCESSFUL
Total time: 1 minute 30 seconds
[cstamas@zaphod build (master)]$ cd dist/maven2/restlet-1.1.6-SONATYPE-5348-V8/
[cstamas@zaphod build (master)]$
```

And you end up in the root of Restlet Maven2 repository. Warning: this repository contains
all the dependencies too! We need only few (Restlet) artifacts from here, best is to "stage"
them separately, into new repository. Stage only following artifacts, best into newly
created empty directory somewhere on your system:

* org.restlet
* org.restlet.ext.fileupload_1.2
* org.restlet.ext.jaxrs_1.0
* org.restlet.ext.velocity_1.5
* org.restlet.ext.wadl_1.0 (unused by latest Nexus 2.3 but in case of older fix needed)

* com.noelios.restlet
* com.noelios.restlet.ext.httpclient_3.1
* com.noelios.restlet.ext.jetty_6.1
* com.noelios.restlet.ext.servlet_2.5

Then, ZIP the directly from it's root.

```
$ cd ~/restlet-V5-stage
$ zip -r v5.zip .
```

And finally, deploy it into RSO's 3rd party repository, using the unpack plugin:

```
$ curl -i -u cstamas -X PUT -T v5.zip https://repository.sonatype.org/service/local/repositories/third-party/content-compressed
```

Note: this command above will ask you for RSO password! _Please notice that URL has NO trailing slash!_ You must not
add trailing slash to URL as in that case cURL will append uploaded file's name to URL and your uploaded ZIP file will 
not be exploded in 3rd party repository root, but a level lower, in directory named "v5.zip/".

Verify that deploy went fine, by browsing RSO 3rd party repository.

Finally, after "deploy", tag the stuff you did (use unique tags, this below is just an example!):

```
[cstamas@zaphod build (master)]$ git tag -a -m "V5 release of Restlet 1.1.x patch" V5
[cstamas@zaphod build (master)]$ git push --tags
```


Have fun!
Sonatype Team
