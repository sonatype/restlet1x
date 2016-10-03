# Sonatype Restlet1x

This repository holds an ancient Restlet 1.1.x that is patched here and there for needs of Sonatype Nexus Repository Manager.

## Build A Sonatype / Restlet Release

There is a script in the same directory as this README.md - `build.xml`. This script is supposed to document and make easier the building of a single zip file containing the dependencies used
by Sonatype Nexus Repository Manager. It simply calls out to the main restlet build file to create a Maven distribution. Then the script copies only the needed dependencies in Maven 2 layout into a single zip file
suitable to upload to a Nexus RM content-compressed endpoint.

### Prepare

First make sure you are running the build with Java 7, else you might get random test failures because of how HashMap ordering changed in JDK8.

In other words, make sure `java -version` shows java 7 - the build.xml will also check for this. 

Next, adjust the release number of the build to what you need.

```
[cstamas@zaphod restlet1x (master)]$ edit restlet-1.1.6-5346-sonatype/build/build.properties
```

Look for the property `release-number`. Set this value to your custom release number.

### Build It

Run the build using ant from the same directory as this readme.

```
> ant
Buildfile: /Users/plynch/Downloads/restlet1x/build.xml

validate-release-version:
     [echo] The file /Users/plynch/Downloads/restlet1x/restlet-1.1.6-5346-sonatype/build/build.properties has a calculated Sonatype release version of 1.1.6-SONATYPE-5348-V8.

validate-jdk:

build-restlet:
...

sonatype-dist-zip:
   [delete] Deleting: /Users/plynch/Downloads/restlet1x/restlet-1.1.6-5346-sonatype/build/sonatype-restlet-1.1.6-SONATYPE-5348-V8.zip
      [zip] Building zip: /Users/plynch/Downloads/restlet1x/restlet-1.1.6-5346-sonatype/build/sonatype-restlet-1.1.6-SONATYPE-5348-V8.zip

sonatype-dist:

BUILD SUCCESSFUL
Total time: 2 minutes 44 seconds

```

When the build is finished, you should end up with a single zip file containing all the dependencies nexus needs:
 
```
> jar tf restlet-1.1.6-5346-sonatype/build/sonatype-restlet-1.1.6-SONATYPE-5348-V9.zip
com/
com/noelios/
com/noelios/restlet/
com/noelios/restlet/com.noelios.restlet/
com/noelios/restlet/com.noelios.restlet.ext.httpclient/
com/noelios/restlet/com.noelios.restlet.ext.httpclient/1.1.6-SONATYPE-5348-V9/
com/noelios/restlet/com.noelios.restlet.ext.jetty/
com/noelios/restlet/com.noelios.restlet.ext.jetty/1.1.6-SONATYPE-5348-V9/
com/noelios/restlet/com.noelios.restlet.ext.servlet/
com/noelios/restlet/com.noelios.restlet.ext.servlet/1.1.6-SONATYPE-5348-V9/
com/noelios/restlet/com.noelios.restlet/1.1.6-SONATYPE-5348-V9/

...
org/restlet/org.restlet/1.1.6-SONATYPE-5348-V9/org.restlet-1.1.6-SONATYPE-5348-V9.jar.md5
org/restlet/org.restlet/1.1.6-SONATYPE-5348-V9/org.restlet-1.1.6-SONATYPE-5348-V9.jar.sha1
org/restlet/org.restlet/1.1.6-SONATYPE-5348-V9/org.restlet-1.1.6-SONATYPE-5348-V9.pom
org/restlet/org.restlet/1.1.6-SONATYPE-5348-V9/org.restlet-1.1.6-SONATYPE-5348-V9.pom.md5
org/restlet/org.restlet/1.1.6-SONATYPE-5348-V9/org.restlet-1.1.6-SONATYPE-5348-V9.pom.sha1

```

## Deploying a public Sonatype / Restlet release

Deploy the resulting zip file into RSO's 3rd party repository, using the unpack plugin - example:

```
$ curl -i -u rso_username -X PUT -T restlet-1.1.6-5346-sonatype/build/sonatype-restlet-1.1.6-SONATYPE-5348-V9.zip \
 https://repository.sonatype.org/service/local/repositories/third-party/content-compressed
```

Important: _Please notice that URL has NO trailing slash!_ You must not
add trailing slash to URL as in that case cURL will append uploaded file's name to URL and your uploaded ZIP file will 
not be exploded in 3rd party repository root, but a level lower, in directory named "sonatype-restlet-1.1.6-SONATYPE-5348-V9.zip/".

Verify that deploy went fine, by browsing RSO 3rd party repository.

Finally, after "deploy", tag the stuff you did (use unique tags, this below is just an example!):

```
[cstamas@zaphod build (master)]$ git tag -a -m "V9 release of Restlet 1.1.x patch" V9
[cstamas@zaphod build (master)]$ git push --tags
```

## Testing a restlet build locally with Nexus

Since we this build process does not produce snapshots, suggest deploying the zip into your local Nexus instance `thirdparty` repo, then perform a build of Nexus RM against your local Nexus public repo with an empty 
Maven local repository.

Have fun!
Sonatype Team
