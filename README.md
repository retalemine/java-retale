Java-retale(app):
=================
 * Code base containing experimental concepts, packages

* Maven commands
  * Maven Archetype for quick java project
``
mvn archetype:generate \
	-DarchetypeGroupId=org.apache.maven.archetypes \
	-DarchetypeArtifactId=maven-archetype-quickstart \
	-DarchetypeVersion=LATEST
``
  * mvn eclipse:eclipse __converts to eclipse java project__
  * mvn clean
  * mvn compile
  * mvn exec:java -Dexec.mainClass="in.retalemine.App"

