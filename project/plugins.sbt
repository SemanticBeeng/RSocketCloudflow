resolvers += "Bintray Repository" at "https://dl.bintray.com/shmishleniy/"

evictionErrorLevel := Level.Info

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.5")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.8.0")
addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.8.2")
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")



addSbtPlugin("org.scalariform"  %  "sbt-scalariform" % "1.8.2")
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.10.0-RC1")
