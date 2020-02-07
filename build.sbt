scalaVersion := "2.13.1"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "is.cir" %% "ciris" % "1.0.4",
  "is.cir" %% "ciris-refined" % "1.0.4",
  "is.cir" %% "ciris-enumeratum" % "1.0.4",
  "io.estatico" %% "newtype" % "0.4.3",
  "eu.timepit" %% "refined" % "0.9.12",
  "com.beachape" %% "enumeratum" % "1.5.15",
  "org.flywaydb" % "flyway-core" % "6.2.1",
  "org.postgresql" % "postgresql" % "42.2.9"
)

scalacOptions += "-Ymacro-annotations"
