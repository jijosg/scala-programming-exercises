  resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.4")
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "latest.integration")
